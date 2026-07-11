package com.feijimiao.xianyuassistant.service;

import com.feijimiao.xianyuassistant.entity.XianyuAccount;
import com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig;
import com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder;
import com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper;
import com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper;
import com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

@Slf4j
@Service
public class ApiDeliveryScheduler {

    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PendingOrderPollService pendingOrderPollService;

    @Autowired
    private XianyuAccountMapper accountMapper;

    @Autowired
    private XianyuGoodsConfigMapper goodsConfigMapper;

    @Autowired
    private XianyuGoodsOrderMapper orderMapper;

    @Autowired
    @Qualifier("deliveryExecutor")
    private ExecutorService deliveryExecutor;

    @Autowired
    private com.feijimiao.xianyuassistant.concurrent.BoundedDelayScheduler delayScheduler;

    private final Set<Long> accountsInFlight = ConcurrentHashMap.newKeySet();

    @Scheduled(fixedDelay = 25000, initialDelay = 60000)
    public void scheduledApiDelivery() {
        try {
            List<XianyuAccount> accounts = accountMapper.selectList(null);
            if (accounts == null || accounts.isEmpty()) return;

            for (XianyuAccount account : accounts) {
                if (webSocketService.isConnected(account.getId()) || !accountsInFlight.add(account.getId())) continue;
                try {
                    deliveryExecutor.execute(() -> {
                        try {
                            pollAndDeliver(account.getId());
                        } catch (Exception e) {
                            log.warn("【账号{}】API发货轮询异常: {}", account.getId(), e.getMessage());
                        } finally {
                            accountsInFlight.remove(account.getId());
                        }
                    });
                } catch (RejectedExecutionException e) {
                    accountsInFlight.remove(account.getId());
                    log.warn("【账号{}】API发货队列已满，本轮跳过", account.getId());
                }
            }
        } catch (Exception e) {
            log.error("API发货扫描失败", e);
        }
    }

    @SuppressWarnings("unchecked")
    private void pollAndDeliver(Long accountId) {
        List<Map<String, Object>> pendingOrders = orderService.queryPendingOrders(accountId);
        if (pendingOrders == null || pendingOrders.isEmpty()) return;

        pendingOrderPollService.syncOrdersToDb(accountId, pendingOrders);

        List<XianyuGoodsConfig> goodsConfigs = goodsConfigMapper.selectByAccountId(accountId);
        Set<String> autoDeliveryGoodsIds = new HashSet<>();
        if (goodsConfigs != null) {
            for (XianyuGoodsConfig config : goodsConfigs) {
                if (config.getXianyuAutoDeliveryOn() != null && config.getXianyuAutoDeliveryOn() == 1) {
                    autoDeliveryGoodsIds.add(config.getXyGoodsId());
                }
            }
        }
        if (autoDeliveryGoodsIds.isEmpty()) return;

        List<ClaimedOrder> toDeliver = new ArrayList<>();
        for (Map<String, Object> order : pendingOrders) {
            try {
                Object commonDataObj = order.get("commonData");
                if (!(commonDataObj instanceof Map)) continue;
                Map<String, Object> commonData = (Map<String, Object>) commonDataObj;

                String orderId = (String) commonData.get("orderId");
                String orderStatus = (String) commonData.get("orderStatus");
                String itemId = (String) commonData.get("itemId");

                if (orderId == null || !"待发货".equals(orderStatus)) continue;
                if (itemId == null || !autoDeliveryGoodsIds.contains(itemId)) continue;

                String claimToken = UUID.randomUUID().toString();
                XianyuGoodsOrder claimed = orderMapper.claimForApiDelivery(
                        accountId, orderId, claimToken, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30));
                if (claimed != null) toDeliver.add(new ClaimedOrder(order, claimed, claimToken));
            } catch (Exception e) {
                log.warn("【账号{}】筛选待发货订单异常: {}", accountId, e.getMessage());
            }
        }

        if (toDeliver.isEmpty()) return;

        log.info("【账号{}】API发货: 发现{}笔待发货订单(WS未连接)", accountId, toDeliver.size());

        long cumulativeDelaySeconds = ThreadLocalRandom.current().nextLong(20, 31);
        for (int i = 0; i < toDeliver.size(); i++) {
            ClaimedOrder claimedOrder = toDeliver.get(i);
            int sequence = i + 1;
            long delaySeconds = cumulativeDelaySeconds;
            try {
                delayScheduler.schedule(() -> submitDelivery(accountId, claimedOrder, sequence, toDeliver.size()), delaySeconds, TimeUnit.SECONDS);
            } catch (RejectedExecutionException e) {
                orderMapper.finishApiDeliveryClaim(claimedOrder.record().getId(), claimedOrder.claimToken(), false, "延迟任务队列已满");
            }
            cumulativeDelaySeconds += ThreadLocalRandom.current().nextLong(5, 11);
        }
    }

    @SuppressWarnings("unchecked")
    private void submitDelivery(Long accountId, ClaimedOrder claimedOrder, int sequence, int total) {
        try {
            deliveryExecutor.execute(() -> {
                Map<String, Object> order = claimedOrder.payload();
                try {
                Map<String, Object> commonData = (Map<String, Object>) order.get("commonData");
                String orderId = (String) commonData.get("orderId");
                String itemId = (String) commonData.get("itemId");

                log.info("【账号{}】API发货[{}/{}]: orderId={}, itemId={}", accountId, sequence, total, orderId, itemId);
                String result = orderService.consignDummyDeliveryWithConfig(accountId, itemId, orderId);
                boolean success = result != null;
                orderMapper.finishApiDeliveryClaim(claimedOrder.record().getId(), claimedOrder.claimToken(), success,
                        success ? null : "API发货返回空结果");
            } catch (Exception e) {
                orderMapper.finishApiDeliveryClaim(claimedOrder.record().getId(), claimedOrder.claimToken(), false, e.getMessage());
                log.warn("【账号{}】API发货异常: {}", accountId, e.getMessage());
                }
            });
        } catch (RejectedExecutionException e) {
            orderMapper.finishApiDeliveryClaim(claimedOrder.record().getId(), claimedOrder.claimToken(), false, "发货执行队列已满");
        }
    }

    private record ClaimedOrder(Map<String, Object> payload, XianyuGoodsOrder record, String claimToken) {}
}
