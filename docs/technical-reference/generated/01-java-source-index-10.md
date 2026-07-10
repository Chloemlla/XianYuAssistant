# Java 源码逐文件技术索引（第 10 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 规模：56 行；文件大小 2395 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Transactional(rollbackFor = Exception.class)。
- 显式方法：listByXyGoodsId(String xyGoodsId)；saveProperties(String xyGoodsId, Long xianyuAccountId, List&lt;XianyuGoodsSkuProperty&gt; propertyList)；deleteByXyGoodsId(String xyGoodsId)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSkuProperty、com.feijimiao.xianyuassistant.mapper.XianyuGoodsSkuPropertyMapper、com.feijimiao.xianyuassistant.service.GoodsSkuPropertyService。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、org.springframework.transaction.annotation.Transactional。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/GoodsSkuServiceImpl.java

- 主类型：GoodsSkuServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：67 行；文件大小 2644 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Transactional(rollbackFor = Exception.class)。
- 显式方法：getCurrentTimeString()；listByXyGoodsId(String xyGoodsId)；countByXyGoodsId(String xyGoodsId)；saveSkus(String xyGoodsId, Long xianyuAccountId, List&lt;XianyuGoodsSku&gt; skuList)；deleteByXyGoodsId(String xyGoodsId)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSku、com.feijimiao.xianyuassistant.mapper.XianyuGoodsSkuMapper、com.feijimiao.xianyuassistant.service.GoodsSkuService。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、org.springframework.transaction.annotation.Transactional。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/ImageUploadServiceImpl.java

- 主类型：ImageUploadServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：291 行；文件大小 12634 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override。
- 显式方法：uploadImage(Long accountId, byte[] imageData, String filename)；uploadImageFromUrl(Long accountId, String imageUrl)；compressImage(byte[] imageData)；uploadToGoofishCDN(String cookie, byte[] imageData, String filename)；parseUploadResponse(String responseBody)；downloadImage(String imageUrl)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.ImageUploadService。
- 主要外部依赖：com.fasterxml.jackson.databind.JsonNode、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、org.springframework.web.multipart.MultipartFile。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/ItemDetailSyncServiceImpl.java

- 主类型：ItemDetailSyncServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：287 行；文件大小 10983 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Async。
- 显式方法：startSync(Long accountId, List&lt;ItemDTO&gt; items)；executeSync(String syncId, Long accountId, List&lt;ItemDTO&gt; items, String cookieStr)；fetchAndSaveDetail(String itemId, String cookieStr, Long accountId)；syncSingleItem(Long accountId, String itemId)；extractDescFromDetailJson(String detailJson)；getProgress(String syncId)；cancelSync(String syncId)；isSyncing(Long accountId)。
- 项目内依赖：com.feijimiao.xianyuassistant.controller.dto.ItemDTO、com.feijimiao.xianyuassistant.controller.dto.SyncProgressRespDTO、com.feijimiao.xianyuassistant.entity.XianyuGoodsSku、com.feijimiao.xianyuassistant.entity.XianyuGoodsSkuProperty、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.GoodsInfoService、com.feijimiao.xianyuassistant.service.GoodsSkuService、com.feijimiao.xianyuassistant.service.GoodsSkuPropertyService、com.feijimiao.xianyuassistant.service.ItemDetailSyncService、com.feijimiao.xianyuassistant.utils.ItemDetailUtils、com.feijimiao.xianyuassistant.utils.XianyuApiUtils。
- 主要外部依赖：com.fasterxml.jackson.databind.JsonNode、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.scheduling.annotation.Async、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/ItemServiceImpl.java

- 主类型：ItemServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：1110 行；文件大小 54279 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@SuppressWarnings("unchecked")、@Override。
- 显式方法：getItemList(ItemListReqDTO reqDTO)；refreshItems(AllItemsReqDTO reqDTO)；getItemsFromDb(ItemListFromDbReqDTO reqDTO)；getItemDetail(ItemDetailReqDTO reqDTO)；buildItemWithConfig(XianyuGoodsInfo item)；fetchItemDetailFromApi(String itemId, String cookieId)；fetchDetailFromApi(String itemId, String cookiesStr)；isDetailInfoFresh(String updatedTime)；parseItemListResponse(Map&lt;String, Object&gt; responseMap, int pageNumber, int pageSize)；getAccountIdFromCookieId(String cookieId)；getCookieFromDb(String cookieId)；updateAutoDeliveryStatus(UpdateAutoDeliveryReqDTO reqDTO)；updateAutoReplyStatus(UpdateAutoReplyReqDTO reqDTO)；deleteItem(DeleteItemReqDTO reqDTO)；ensureMh5tkInCookie(String cookieText, Long accountId)；getRagAutoReplyConfig(RagAutoReplyConfigReqDTO reqDTO)；updateRagAutoReplyConfig(UpdateRagAutoReplyConfigReqDTO reqDTO)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.*、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.entity.XianyuGoodsSku、com.feijimiao.xianyuassistant.entity.XianyuGoodsSkuProperty、com.feijimiao.xianyuassistant.service.ItemService、com.feijimiao.xianyuassistant.utils.XianyuApiUtils、com.feijimiao.xianyuassistant.utils.XianyuSignUtils、com.feijimiao.xianyuassistant.utils.ItemDetailUtils。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/KamiConfigServiceImpl.java

- 主类型：KamiConfigServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：418 行；文件大小 18045 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Transactional。
- 显式方法：createOrUpdateConfig(KamiConfigReqDTO reqDTO)；getConfigsByAccountId(Long xianyuAccountId)；getConfigById(Long id)；deleteConfig(Long id)；addKamiItem(KamiItemReqDTO reqDTO)；batchImportKamiItems(KamiBatchImportReqDTO reqDTO)；getKamiItemsByConfigId(Long kamiConfigId)；getKamiItemsByConfigIdWithFilter(KamiItemQueryReqDTO reqDTO)；deleteKamiItem(Long id)；resetKamiItem(Long id)；acquireKami(Long kamiConfigId, String orderId)；sendStockOutEmailIfNeeded(XianyuKamiConfig config, Long kamiConfigId, String orderId)；getConfig(Long kamiConfigId)；exportKamiItems(KamiExportReqDTO reqDTO)；refreshConfigCounts(Long kamiConfigId)；toConfigRespDTO(XianyuKamiConfig config)；toItemRespDTO(XianyuKamiItem item)；checkAndSendAlert(XianyuKamiConfig config, Long kamiConfigId)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.*、com.feijimiao.xianyuassistant.entity.XianyuKamiConfig、com.feijimiao.xianyuassistant.entity.XianyuKamiItem、com.feijimiao.xianyuassistant.mapper.XianyuKamiConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuKamiItemMapper、com.feijimiao.xianyuassistant.service.EmailNotifyService、com.feijimiao.xianyuassistant.service.KamiConfigService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、org.springframework.transaction.annotation.Transactional。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/KeywordReplyServiceImpl.java

- 主类型：KeywordReplyServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：239 行；文件大小 9678 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override。
- 显式方法：getRules(Long accountId, String xyGoodsId)；addRule(Long accountId, String xyGoodsId, String keyword)；deleteRule(Long ruleId)；updateKeyword(Long ruleId, String keyword)；updateMatchMode(Long ruleId, Integer matchMode)；ensureFallbackRule(Long accountId, String xyGoodsId)；addContent(Long ruleId, String replyText, String replyImageUrl)；updateContent(Long contentId, String replyText, String replyImageUrl)；deleteContent(Long contentId)；matchKeyword(Long accountId, String xyGoodsId, String message)；isKeywordReplyEnabled(Long accountId, String xyGoodsId)；toRuleBO(XianyuKeywordReplyRule rule, List&lt;XianyuKeywordReplyContent&gt; contents)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.entity.XianyuKeywordReplyContent、com.feijimiao.xianyuassistant.entity.XianyuKeywordReplyRule、com.feijimiao.xianyuassistant.entity.bo.KeywordReplyRuleBO、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuKeywordReplyContentMapper、com.feijimiao.xianyuassistant.mapper.XianyuKeywordReplyRuleMapper、com.feijimiao.xianyuassistant.service.KeywordReplyService。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/ManualModeServiceImpl.java

- 主类型：ManualModeServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：108 行；文件大小 3300 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Scheduled(fixedRate = 300000)。
- 显式方法：isManualMode(String chatId)；toggleManualMode(String chatId)；enterManualMode(String chatId)；exitManualMode(String chatId)；getAllManualModeConversations()；cleanupExpiredManualModes()；scheduledCleanup()。
- 项目内依赖：com.feijimiao.xianyuassistant.config.WebSocketConfig、com.feijimiao.xianyuassistant.service.ManualModeService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.scheduling.annotation.Scheduled、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/OperationLogServiceImpl.java

- 主类型：OperationLogServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：136 行；文件大小 5582 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Async。
- 显式方法：log(XianyuOperationLog operationLog)；log(Long accountId, String operationType, String operationDesc, Integer status)；deleteOldLogs(int days)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuOperationLog、com.feijimiao.xianyuassistant.mapper.XianyuOperationLogMapper、com.feijimiao.xianyuassistant.service.OperationLogService。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.scheduling.annotation.Async、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/OrderServiceImpl.java

- 主类型：OrderServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：505 行；文件大小 22316 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：confirmShipment(Long accountId, String orderId)；consignDummyDelivery(Long accountId, String orderId, String tradeText, List&lt;String&gt; imageUrls)；confirmShipmentToXianyu(Long accountId, String orderId)；getOrderDetail(Long accountId, String orderId)；updateOrderDetailFromApi(Long accountId, String orderId, Map&lt;String, Object&gt; responseData)；getOrderDetailFromLocal(Long accountId, String orderId)；queryPendingOrders(Long accountId)；getOrderDetailMap(Long accountId, String orderId)；consignDummyDeliveryWithConfig(Long accountId, String xyGoodsId, String orderId)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig、com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder、com.feijimiao.xianyuassistant.exception.BusinessException、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoDeliveryConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.OrderService、com.feijimiao.xianyuassistant.service.delivery.DeliveryContext、com.feijimiao.xianyuassistant.service.delivery.DeliveryStrategyResolver、com.feijimiao.xianyuassistant.utils.XianyuApiCallUtils。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/QRLoginServiceImpl.java

- 主类型：QRLoginServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：719 行；文件大小 33561 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Service、@Slf4j、@Autowired、@Override。
- 显式方法：generateHeaders()；generateApiHeaders()；getMh5tk(QRLoginSession session)；getLoginParams(QRLoginSession session)；generateQRCode()；extractParamsFromHtml(String html)；generateQRCodeImage(String content)；monitorQRStatus(String sessionId)；pollQRCodeStatus(QRLoginSession session)；getSessionStatus(String sessionId)；convertToFrontendStatus(String backendStatus)；getSessionCookies(String sessionId)；cleanupExpiredSessions()；saveCookieToDatabase(QRLoginSession session)；md5(String input)。
- 项目内依赖：com.feijimiao.xianyuassistant.controller.dto.QRLoginResponse、com.feijimiao.xianyuassistant.controller.dto.QRLoginSession、com.feijimiao.xianyuassistant.controller.dto.QRStatusResponse、com.feijimiao.xianyuassistant.service.QRLoginService、com.feijimiao.xianyuassistant.utils.CookieUtils。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、okhttp3.*、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/RiskControlServiceImpl.java

- 主类型：RiskControlServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：144 行；文件大小 4702 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Override、@SuppressWarnings("unchecked")。
- 显式方法：detectRiskControl(Map&lt;String, Object&gt; response)；handleRiskControl(Long accountId, Map&lt;String, Object&gt; response)；isTokenExpired(Map&lt;String, Object&gt; response)。
- 项目内依赖：com.feijimiao.xianyuassistant.service.RiskControlService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/SentMessageSaveServiceImpl.java

- 主类型：SentMessageSaveServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：137 行；文件大小 5773 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Async。
- 显式方法：saveManualReply(Long accountId, String cid, String toId, String text, String xyGoodsId)；saveAiAssistantReply(Long accountId, String cid, String toId, String text, String xyGoodsId)；saveManualImageReply(Long accountId, String cid, String toId, String imageUrl, String xyGoodsId)；saveAiImageReply(Long accountId, String cid, String toId, String imageUrl, String xyGoodsId)；generatePnmId()。
- 项目内依赖：com.feijimiao.xianyuassistant.context.UserContext、com.feijimiao.xianyuassistant.entity.XianyuChatMessage、com.feijimiao.xianyuassistant.mapper.XianyuChatMessageMapper、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.SentMessageSaveService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.scheduling.annotation.Async、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/SysSettingServiceImpl.java

- 主类型：SysSettingServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：147 行；文件大小 5909 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Lazy、@Override。
- 显式方法：getSettingValue(String settingKey)；getSetting(GetSettingReqBO reqBO)；getAllSettings()；saveSetting(SaveSettingReqBO reqBO)；deleteSetting(String settingKey)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.rag.DynamicAIChatClientManager、com.feijimiao.xianyuassistant.entity.XianyuSysSetting、com.feijimiao.xianyuassistant.mapper.XianyuSysSettingMapper、com.feijimiao.xianyuassistant.service.SysSettingService、com.feijimiao.xianyuassistant.service.bo.*。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.annotation.Lazy、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/TokenRefreshServiceImpl.java

- 主类型：TokenRefreshServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：593 行；文件大小 27443 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Autowired(required = false)、@PostConstruct、@Override、@Scheduled(fixedDelay = ONE_MINUTE_MS, initialDelay = ONE_MINUTE_MS)、@Scheduled(fixedDelay = 60 * 1000, initialDelay = 60 * 1000)、@Scheduled(fixedDelay = 60 * ONE_MINUTE_MS, initialDelay = 5 * ONE_MINUTE_MS)。
- 显式方法：initRefreshSchedules()；randomRefreshDelayMinutes()；scheduleNextCookieKeepAlive()；refreshMh5tkToken(Long accountId)；refreshMh5tkTokenWithRetry(Long accountId, int retryCount, boolean hasLoginAttempted)；handleMh5tkRefreshFailure(Long accountId, int retryCount, boolean hasLoginAttempted, String reason)；refreshMh5tkViaHasLogin(Long accountId, int hasLoginRetryCount)；refreshWebSocketToken(Long accountId)；needsRefresh(Long accountId)；scheduledCookieKeepAlive()；scheduledRefreshWebSocketToken()；refreshAllAccountsTokens()；triggerCookieExpireNotify(Long accountId)；scheduledCleanPlaywrightTempFiles()。
- 项目内依赖：com.feijimiao.xianyuassistant.config.PlaywrightManager、com.feijimiao.xianyuassistant.config.WebSocketConfig、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuCookie、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuCookieMapper、com.feijimiao.xianyuassistant.service.CookieRefreshService、com.feijimiao.xianyuassistant.service.OperationLogService、com.feijimiao.xianyuassistant.service.TokenRefreshService、com.feijimiao.xianyuassistant.service.WebSocketTokenService、com.feijimiao.xianyuassistant.utils.SessionCookieJar、com.feijimiao.xianyuassistant.utils.XianyuSignUtils。
- 主要外部依赖：jakarta.annotation.PostConstruct、lombok.extern.slf4j.Slf4j、okhttp3.OkHttpClient、okhttp3.Request、okhttp3.Response、org.springframework.beans.factory.annotation.Autowired、org.springframework.scheduling.annotation.Scheduled、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/WebSocketServiceImpl.java

- 主类型：WebSocketServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：971 行；文件大小 45508 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Autowired(required = false)、@Override、@PreDestroy。
- 显式方法：startWebSocket(Long accountId)；startWebSocketWithToken(Long accountId, String accessToken)；connectWebSocket(Long accountId, String cookieStr, String deviceId, String accessToken, String unb)；stopWebSocket(Long accountId)；isConnected(Long accountId)；stopAllWebSockets()；startHeartbeat(Long accountId, XianyuWebSocketClient client)；startTokenRefresh(Long accountId)；refreshTokenAndReconnect(Long accountId)；handleConnectionLost(Long accountId)；scheduleReconnect(Long accountId, int delaySeconds, boolean isManualRestart)；updateHeartbeatResponseTime(Long accountId)；stopHeartbeat(Long accountId)；sendMessage(Long accountId, String cid, String toId, String text)；sendMessageWithResult(Long accountId, String cid, String toId, String text)；completePendingResponse(Long accountId, String mid, int code)；sendImageMessage(Long accountId, String cid, String toId, String imageUrl, int width, int height)；sendImageMessageWithResult(Long accountId, String cid, String toId, String imageUrl, int width, int height)；cleanup()；triggerWsDisconnectNotify(Long accountId)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.WebSocketConfig、com.feijimiao.xianyuassistant.constants.OperationConstants、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.OperationLogService、com.feijimiao.xianyuassistant.service.WebSocketService、com.feijimiao.xianyuassistant.service.WebSocketTokenService、com.feijimiao.xianyuassistant.utils.XianyuSignUtils、com.feijimiao.xianyuassistant.websocket.WebSocketInitializer、com.feijimiao.xianyuassistant.websocket.WebSocketMessageHandler、com.feijimiao.xianyuassistant.websocket.XianyuWebSocketClient。
- 主要外部依赖：jakarta.annotation.PreDestroy、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.annotation.Lazy、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/WebSocketTokenServiceImpl.java

- 主类型：WebSocketTokenServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：912 行；文件大小 43778 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getTokenLock(Long accountId)；getAccessToken(Long accountId)；getLatestCookieFromDb(Long accountId)；getAccessTokenWithRetry(Long accountId, int retryCount)；appendUrlParam(StringBuilder sb, String key, String value)；getDeviceId(Long accountId, Map&lt;String, String&gt; cookies)；handleTokenFailure(Long accountId, int retryCount, String response, String reason)；refreshTokenViaHasLogin(Long accountId, int hasLoginRetryCount)；updateCookiesFromResponse(Long accountId, String currentCookieStr, List&lt;String&gt; setCookieHeaders)；mergeCookies(String oldCookieStr, List&lt;String&gt; newCookies)；saveToken(Long accountId, String token)；clearToken(Long accountId)；clearCaptchaWait(Long accountId)；refreshToken(Long accountId)；updateAccountStatusToCaptchaRequired(Long accountId)；updateAccountStatusToNormal(Long accountId)；updateCookieStatus(Long accountId, Integer status)；updateCookieStatus(Long accountId, Integer status, boolean sendNotify)；saveTokenToDatabase(Long accountId, String token)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuCookie、com.feijimiao.xianyuassistant.exception.CaptchaRequiredException、com.feijimiao.xianyuassistant.mapper.XianyuCookieMapper、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.CookieRefreshService、com.feijimiao.xianyuassistant.service.EmailNotifyService、com.feijimiao.xianyuassistant.service.OperationLogService、com.feijimiao.xianyuassistant.service.WebSocketTokenService、com.feijimiao.xianyuassistant.utils.XianyuSignUtils。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、okhttp3.*、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/ItemDetailSyncService.java

- 主类型：ItemDetailSyncService
- 包：com.feijimiao.xianyuassistant.service
- 规模：13 行；文件大小 507 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.controller.dto.SyncProgressRespDTO、com.feijimiao.xianyuassistant.controller.dto.ItemDTO。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/ItemService.java

- 主类型：ItemService
- 包：com.feijimiao.xianyuassistant.service
- 规模：75 行；文件大小 2067 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.*。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/KamiConfigService.java

- 主类型：KamiConfigService
- 包：com.feijimiao.xianyuassistant.service
- 规模：37 行；文件大小 1301 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.*、com.feijimiao.xianyuassistant.entity.XianyuKamiConfig、com.feijimiao.xianyuassistant.entity.XianyuKamiItem。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/KeywordReplyService.java

- 主类型：KeywordReplyService
- 包：com.feijimiao.xianyuassistant.service
- 规模：30 行；文件大小 991 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.bo.KeywordReplyRuleBO。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/ManualModeService.java

- 主类型：ManualModeService
- 包：com.feijimiao.xianyuassistant.service
- 规模：54 行；文件大小 1239 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/OperationLogService.java

- 主类型：OperationLogService
- 包：com.feijimiao.xianyuassistant.service
- 规模：40 行；文件大小 1178 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuOperationLog。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/OrderService.java

- 主类型：OrderService
- 包：com.feijimiao.xianyuassistant.service
- 规模：47 行；文件大小 1249 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/PendingOrderPollService.java

- 主类型：PendingOrderPollService
- 包：com.feijimiao.xianyuassistant.service
- 规模：242 行；文件大小 10978 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：@Slf4j、@Service、@Autowired、@SuppressWarnings("unchecked")。
- 显式方法：deliverPendingOrders(Long accountId)；syncOrdersToDb(Long accountId, List&lt;Map&lt;String, Object&gt;&gt; pendingOrders)；buildOrderRecord(Long accountId, Map&lt;String, Object&gt; order)；enrichFromDetailApi(Long accountId, String orderId, XianyuGoodsOrder existing)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder、com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/QRLoginService.java

- 主类型：QRLoginService
- 包：com.feijimiao.xianyuassistant.service
- 规模：32 行；文件大小 694 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.controller.dto.QRLoginResponse、com.feijimiao.xianyuassistant.controller.dto.QRStatusResponse。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/AIReplyStrategy.java

- 主类型：AIReplyStrategy
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：67 行；文件大小 2856 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
- 注解：@Slf4j、@Component、@Autowired、@Override。
- 显式方法：execute(List&lt;ChatMessageData&gt; messageList)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.entity.bo.KeywordReplyRuleBO、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper、com.feijimiao.xianyuassistant.service.AIService、com.feijimiao.xianyuassistant.service.bo.RAGReplyResult。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/AutoReplyDelayServiceImpl.java

- 主类型：AutoReplyDelayServiceImpl
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：234 行；文件大小 9192 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
