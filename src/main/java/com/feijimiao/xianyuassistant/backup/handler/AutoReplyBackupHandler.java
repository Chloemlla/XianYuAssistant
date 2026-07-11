package com.feijimiao.xianyuassistant.backup.handler;

import com.feijimiao.xianyuassistant.backup.DataBackupHandler;
import com.feijimiao.xianyuassistant.backup.BackupImportReporter;
import com.feijimiao.xianyuassistant.entity.XianyuAccount;
import com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig;
import com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper;
import com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class AutoReplyBackupHandler implements DataBackupHandler {

    @Autowired
    private XianyuGoodsConfigMapper goodsConfigMapper;

    @Autowired
    private XianyuAccountMapper accountMapper;

    @Override
    public String getModuleKey() {
        return "autoReply";
    }

    @Override
    public String getModuleName() {
        return "自动回复";
    }

    @Override
    public Map<String, Object> exportData() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (XianyuGoodsConfig config : goodsConfigMapper.selectAllWithAutoReply()) {
            XianyuAccount account = accountMapper.selectById(config.getXianyuAccountId());
            if (account == null) continue;
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("unb", account.getUnb());
            map.put("xyGoodsId", config.getXyGoodsId());
            map.put("autoReplyOn", config.getXianyuAutoReplyOn());
            map.put("autoReplyContextOn", config.getXianyuAutoReplyContextOn());
            map.put("fixedMaterial", config.getFixedMaterial());
            result.add(map);
        }

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("autoReplyConfigs", result);
        return data;
    }

    @Override
    public void importData(Map<String, Object> data, Map<String, Object> context) {
        if (data == null) return;

        @SuppressWarnings("unchecked")
        Map<String, Long> unbToAccountId = context.get("unbToAccountId") != null
                ? (Map<String, Long>) context.get("unbToAccountId")
                : Collections.emptyMap();

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> configMaps = (List<Map<String, Object>>) data.get("autoReplyConfigs");
        if (configMaps == null) return;

        int skippedCount = 0;
        for (Map<String, Object> map : configMaps) {
            try {
                String unb = (String) map.get("unb");
                String xyGoodsId = (String) map.get("xyGoodsId");
                if (unb == null || xyGoodsId == null) continue;

                Long accountId = unbToAccountId.get(unb);
                if (accountId == null) {
                    log.warn("[AutoReplyBackup] 跳过: 找不到账号, unb={}, xyGoodsId={}", unb, xyGoodsId);
                    skippedCount++;
                    continue;
                }

                Integer autoReplyOn = map.get("autoReplyOn") != null ? ((Number) map.get("autoReplyOn")).intValue() : null;
                Integer autoReplyContextOn = map.get("autoReplyContextOn") != null ? ((Number) map.get("autoReplyContextOn")).intValue() : null;
                String fixedMaterial = (String) map.get("fixedMaterial");

                XianyuGoodsConfig existing = goodsConfigMapper.selectByAccountAndGoodsId(accountId, xyGoodsId);
                if (existing == null) {
                    XianyuGoodsConfig config = new XianyuGoodsConfig();
                    config.setXianyuAccountId(accountId);
                    config.setXyGoodsId(xyGoodsId);
                    config.setXianyuAutoReplyOn(autoReplyOn);
                    config.setXianyuAutoReplyContextOn(autoReplyContextOn);
                    config.setFixedMaterial(fixedMaterial);
                    goodsConfigMapper.insert(config);
                } else {
                    existing.setXianyuAutoReplyOn(autoReplyOn);
                    existing.setXianyuAutoReplyContextOn(autoReplyContextOn);
                    existing.setFixedMaterial(fixedMaterial);
                    goodsConfigMapper.update(existing);
                }
            } catch (Exception e) {
                BackupImportReporter.recordFailure(context, getModuleKey(), "autoReplyConfig", e);
                log.warn("[AutoReplyBackup] 导入单条自动回复配置失败: {}", e.getMessage());
            }
        }
        if (skippedCount > 0) {
            log.warn("[AutoReplyBackup] 共跳过 {} 条数据（账号不存在）", skippedCount);
        }
    }
}
