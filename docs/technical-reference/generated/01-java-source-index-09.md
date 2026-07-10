# Java 源码逐文件技术索引（第 9 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 主类型：CookieRefreshService
- 包：com.feijimiao.xianyuassistant.service
- 规模：46 行；文件大小 1252 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/DataBackupService.java

- 主类型：DataBackupService
- 包：com.feijimiao.xianyuassistant.service
- 规模：14 行；文件大小 343 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.service.bo.*。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/delivery/DeliveryContentStrategy.java

- 主类型：DeliveryContentStrategy
- 包：com.feijimiao.xianyuassistant.service.delivery
- 规模：32 行；文件大小 1088 字节。
- 职责判断：自动发货策略与上下文，隔离不同交付模式。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/delivery/DeliveryContext.java

- 主类型：DeliveryContext
- 包：com.feijimiao.xianyuassistant.service.delivery
- 规模：22 行；文件大小 606 字节。
- 职责判断：自动发货策略与上下文，隔离不同交付模式。
- 注解：@Data、@Builder。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig。
- 主要外部依赖：lombok.Builder、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/delivery/DeliveryStrategyResolver.java

- 主类型：DeliveryStrategyResolver
- 包：com.feijimiao.xianyuassistant.service.delivery
- 规模：38 行；文件大小 1241 字节。
- 职责判断：自动发货策略与上下文，隔离不同交付模式。
- 注解：@Slf4j、@Component、@Autowired。
- 显式方法：resolve(int deliveryMode, DeliveryContext context)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/delivery/KamiDeliveryStrategy.java

- 主类型：KamiDeliveryStrategy
- 包：com.feijimiao.xianyuassistant.service.delivery
- 规模：97 行；文件大小 4373 字节。
- 职责判断：自动发货策略与上下文，隔离不同交付模式。
- 注解：@Slf4j、@Component、@Autowired、@Override。
- 显式方法：supports(int deliveryMode)；resolve(DeliveryContext context)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuKamiItem、com.feijimiao.xianyuassistant.entity.XianyuKamiUsageRecord、com.feijimiao.xianyuassistant.mapper.XianyuKamiUsageRecordMapper、com.feijimiao.xianyuassistant.service.KamiConfigService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/delivery/OrderDetailFetcher.java

- 主类型：OrderDetailFetcher
- 包：com.feijimiao.xianyuassistant.service.delivery
- 规模：215 行；文件大小 9595 字节。
- 职责判断：自动发货策略与上下文，隔离不同交付模式。
- 注解：@Slf4j、@Component、@Autowired、@SuppressWarnings("unchecked")。
- 显式方法：fetch(Long accountId, String xyGoodsId, String orderId)；parseBuyerInfo(Map&lt;String, Object&gt; module, OrderDetailInfo info)；parseCommonData(Map&lt;String, Object&gt; module, OrderDetailInfo info)；parseItemInfo(Map&lt;String, Object&gt; module, OrderDetailInfo info)；parsePriceInfo(Map&lt;String, Object&gt; module, OrderDetailInfo info)；parseSkuInfo(Long accountId, String xyGoodsId, Map&lt;String, Object&gt; module, OrderDetailInfo info)。
- 项目内依赖：com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.GoodsSkuService、com.feijimiao.xianyuassistant.utils.XianyuApiCallUtils。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/delivery/SkuResolver.java

- 主类型：SkuResolver
- 包：com.feijimiao.xianyuassistant.service.delivery
- 规模：102 行；文件大小 4104 字节。
- 职责判断：自动发货策略与上下文，隔离不同交付模式。
- 注解：@Slf4j、@Component、@Autowired。
- 显式方法：parseSkuInfoToValueText(String skuInfoStr)；resolveSkuIdByText(Long accountId, String xyGoodsId, String skuValueText)；normalize(String text)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSku、com.feijimiao.xianyuassistant.service.GoodsSkuService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/delivery/TextDeliveryStrategy.java

- 主类型：TextDeliveryStrategy
- 包：com.feijimiao.xianyuassistant.service.delivery
- 规模：30 行；文件大小 1048 字节。
- 职责判断：自动发货策略与上下文，隔离不同交付模式。
- 注解：@Slf4j、@Component、@Override。
- 显式方法：supports(int deliveryMode)；resolve(DeliveryContext context)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/EmailNotifyService.java

- 主类型：EmailNotifyService
- 包：com.feijimiao.xianyuassistant.service
- 规模：89 行；文件大小 2524 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/EnhancedMessageSendService.java

- 主类型：EnhancedMessageSendService
- 包：com.feijimiao.xianyuassistant.service
- 规模：56 行；文件大小 1418 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/GoodsInfoService.java

- 主类型：GoodsInfoService
- 包：com.feijimiao.xianyuassistant.service
- 规模：140 行；文件大小 4087 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.controller.dto.ItemDTO。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/GoodsSkuPropertyService.java

- 主类型：GoodsSkuPropertyService
- 包：com.feijimiao.xianyuassistant.service
- 规模：14 行；文件大小 425 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSkuProperty。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/GoodsSkuService.java

- 主类型：GoodsSkuService
- 包：com.feijimiao.xianyuassistant.service
- 规模：16 行；文件大小 429 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSku。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/ImageUploadService.java

- 主类型：ImageUploadService
- 包：com.feijimiao.xianyuassistant.service
- 规模：28 行；文件大小 740 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/AccountServiceImpl.java

- 主类型：AccountServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：645 行；文件大小 27641 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Transactional(rollbackFor = Exception.class)。
- 显式方法：getCurrentTimeString()；getFutureTimeString(int days)；extractMH5TkFromCookie(String cookie)；saveAccountAndCookie(String accountNote, String unb, String cookieText)；saveAccountAndCookie(String accountNote, String unb, String cookieText, String mH5Tk)；getCookieByAccountId(Long accountId)；getCookieByUnb(String unb)；getCookieByAccountNote(String accountNote)；updateCookie(Long accountId, String cookieText)；getMh5tkByAccountId(Long accountId)；getAccountIdByAccountNote(String accountNote)；getAccountIdByUnb(String unb)；updateCookieStatus(Long accountId, Integer cookieStatus)；updateCookieStatus(Long accountId, Integer cookieStatus, boolean sendNotify)；deleteAccountAndRelatedData(Long accountId)；updateAccountCookie(Long accountId, String unb, String cookieText)；getOrGenerateDeviceId(Long accountId, String unb)；updateDeviceId(Long accountId, String deviceId)；getXianyuUserId(Long accountId)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuCookie、com.feijimiao.xianyuassistant.entity.XianyuChatMessage、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuCookieMapper、com.feijimiao.xianyuassistant.mapper.XianyuChatMessageMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoDeliveryConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoReplyRecordMapper、com.feijimiao.xianyuassistant.mapper.XianyuOperationLogMapper、com.feijimiao.xianyuassistant.service.AccountService。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、org.springframework.transaction.annotation.Transactional。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/AIServiceImpl.java

- 主类型：AIServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：678 行；文件大小 28925 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Service、@Slf4j、@Autowired、@Override。
- 显式方法：extractAiErrorMessage(Throwable e)；chatByRAG(String prompt, String goodsId)；chatByRAGWithDetails(String msg, String goodsId)；chatByRAGWithDetails(String msg, String goodsId, String contextMessages)；chatByRAGWithFixedMaterialStream(String msg, String goodsId, String fixedMaterial, String goodsDetail)；chatByRAGWithFixedMaterial(String msg, String goodsId, String fixedMaterial, String goodsDetail)；chatByRAGWithFixedMaterial(String msg, String goodsId, String contextMessages, String fixedMaterial, String goodsDetail)；chatWithoutContext(ChatClient chatClient, String prompt, long startTime)；putDataToRAG(String content, String goodsId)；queryRAGDataBygoodsId(String goodsId)；deleteRAGDataByDocumentId(String documentId)；getSimilarityThreshold()；simpleChat(String message)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.rag.DynamicAIChatClientManager、com.feijimiao.xianyuassistant.config.rag.DynamicVectorStoreManager、com.feijimiao.xianyuassistant.service.AIService、com.feijimiao.xianyuassistant.service.SysSettingService、com.feijimiao.xianyuassistant.service.bo.RAGDataRespBO、com.feijimiao.xianyuassistant.service.bo.RAGReplyResult。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.ai.chat.client.ChatClient、org.springframework.ai.document.Document、org.springframework.ai.transformer.splitter.TokenTextSplitter、org.springframework.ai.vectorstore.SearchRequest、org.springframework.ai.vectorstore.VectorStore、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、reactor.core.publisher.Flux。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/AuthServiceImpl.java

- 主类型：AuthServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：261 行；文件大小 9571 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override。
- 显式方法：checkUserExists()；register(RegisterReqBO reqBO)；login(LoginReqBO reqBO)；isTokenValid(String token)；checkLoginAttempt(String ip)；recordLoginFailure(String ip)；clearLoginFailure(String ip)；getCurrentUser(Long userId)；changePassword(ChangePasswordReqBO reqBO)；logout(String token)。
- 项目内依赖：com.feijimiao.xianyuassistant.cache.CacheService、com.feijimiao.xianyuassistant.entity.SysLoginToken、com.feijimiao.xianyuassistant.entity.SysUser、com.feijimiao.xianyuassistant.mapper.SysLoginTokenMapper、com.feijimiao.xianyuassistant.mapper.SysUserMapper、com.feijimiao.xianyuassistant.service.AuthService、com.feijimiao.xianyuassistant.service.bo.*、com.feijimiao.xianyuassistant.util.JwtUtil。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/AutoDeliveryConfigServiceImpl.java

- 主类型：AutoDeliveryConfigServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：181 行；文件大小 8781 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override。
- 显式方法：saveOrUpdateConfig(AutoDeliveryConfigReqDTO reqDTO)；getConfig(AutoDeliveryConfigQueryReqDTO reqDTO)；getConfigsByGoodsId(Long xianyuAccountId, String xyGoodsId)；getConfigsByAccountId(Long xianyuAccountId)；deleteConfig(Long xianyuAccountId, String xyGoodsId)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoDeliveryConfigMapper、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigReqDTO、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigRespDTO、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigQueryReqDTO、com.feijimiao.xianyuassistant.service.AutoDeliveryConfigService。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.BeanUtils、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/AutoDeliveryServiceImpl.java

- 主类型：AutoDeliveryServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：586 行；文件大小 30757 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Lazy、@Override。
- 显式方法：getGoodsConfig(Long accountId, String xyGoodsId)；getAutoDeliveryConfig(Long accountId, String xyGoodsId)；saveOrUpdateGoodsConfig(XianyuGoodsConfig config)；saveOrUpdateAutoDeliveryConfig(XianyuGoodsAutoDeliveryConfig config)；recordAutoDelivery(Long accountId, String xyGoodsId, String buyerUserId, String buyerUserName, String content, Integer state)；handleAutoDelivery(Long accountId, String xyGoodsId, String sId, String buyerUserId, String buyerUserName)；handleAutoDelivery(Long accountId, String xyGoodsId, String sId, String buyerUserId, String buyerUserName, String orderId)；handleAutoReply(Long accountId, String xyGoodsId, String sId, String buyerMessage)；executeDelivery(Long recordId, Long accountId, String xyGoodsId, String sId, String orderId, String buyerUserName, boolean needHumanLikeDelay)；executeAutoConfirmShipment(Long accountId, String orderId)；updateRecordState(Long recordId, Integer state, String content, String failReason)；updateAutoConfirmShipment(Long accountId, String xyGoodsId, Integer autoConfirmShipment)；manualDelivery(Long xianyuAccountId, String orderId, String content)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig、com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder、com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoReplyRecord、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoDeliveryConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoReplyRecordMapper、com.feijimiao.xianyuassistant.service.AutoDeliveryService、com.feijimiao.xianyuassistant.service.EmailNotifyService、com.feijimiao.xianyuassistant.service.OrderService、com.feijimiao.xianyuassistant.service.WebSocketService、com.feijimiao.xianyuassistant.service.delivery.DeliveryContext、com.feijimiao.xianyuassistant.service.delivery.DeliveryStrategyResolver、com.feijimiao.xianyuassistant.service.delivery.OrderDetailFetcher、com.feijimiao.xianyuassistant.utils.HumanLikeDelayUtils。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.annotation.Lazy、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/AutoReplyServiceImpl.java

- 主类型：AutoReplyServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：282 行；文件大小 13401 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Autowired(required = false)、@Override。
- 显式方法：executeAutoReply(ChatMessageData messageData)；executeAutoReply(List&lt;ChatMessageData&gt; messageList)；isAutoReplyEnabled(Long accountId, String xyGoodsId)；isAnyReplyEnabled(Long accountId, String xyGoodsId)；updateRecordState(Long recordId, Integer state, String replyContent)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.rag.DynamicAIChatClientManager、com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoReplyRecord、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.entity.XianyuChatMessage、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.entity.bo.AutoReplyTriggerContext、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoReplyRecordMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper、com.feijimiao.xianyuassistant.mapper.XianyuChatMessageMapper、com.feijimiao.xianyuassistant.service.AIService、com.feijimiao.xianyuassistant.service.AutoReplyService、com.feijimiao.xianyuassistant.service.WebSocketService、com.feijimiao.xianyuassistant.service.bo.RAGReplyResult、com.feijimiao.xianyuassistant.service.reply.ReplyStrategy、com.feijimiao.xianyuassistant.service.reply.ReplyStrategyResolver。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/ChatMessageServiceImpl.java

- 主类型：ChatMessageServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：164 行；文件大小 7210 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override。
- 显式方法：getMessagesByAccountId(Long accountId, int page, int pageSize)；getMessagesBySessionId(String sessionId)；getMessageList(MsgListReqDTO reqDTO)；getContextMessages(MsgContextReqDTO reqDTO)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuChatMessage、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuChatMessageMapper、com.feijimiao.xianyuassistant.controller.dto.MsgContextReqDTO、com.feijimiao.xianyuassistant.controller.dto.MsgDTO、com.feijimiao.xianyuassistant.controller.dto.MsgListReqDTO、com.feijimiao.xianyuassistant.controller.dto.MsgListRespDTO、com.feijimiao.xianyuassistant.service.ChatMessageService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/CookieRefreshServiceImpl.java

- 主类型：CookieRefreshServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：665 行；文件大小 33770 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Autowired(required = false)、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getRefreshLock(Long accountId)；checkLoginStatus(Long accountId)；checkLoginStatusQuietly(Long accountId)；doCheckLoginStatus(Long accountId, boolean logOperation)；doCheckLoginStatusWithRetry(Long accountId, int retryCount, boolean logOperation)；refreshCookie(Long accountId)；refreshCookieWithBrowser(Long accountId)；markAccountAsCookieRefreshAbnormal(Long accountId, String reason)；updateAccountStatusToNormal(Long accountId, String reason)；buildBrowserCookies(Map&lt;String, String&gt; cookieMap)；buildCookieText(List&lt;Cookie&gt; cookies)；clearDuplicateCookies(String cookieStr)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.PlaywrightManager、com.feijimiao.xianyuassistant.constants.OperationConstants、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuCookie、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuCookieMapper、com.feijimiao.xianyuassistant.service.CookieRefreshService、com.feijimiao.xianyuassistant.service.OperationLogService、com.feijimiao.xianyuassistant.utils.SessionCookieJar、com.feijimiao.xianyuassistant.utils.XianyuSignUtils。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、okhttp3.*、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/DataBackupServiceImpl.java

- 主类型：DataBackupServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：129 行；文件大小 5166 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getModules()；exportData(BackupExportReqBO reqBO)；importData(BackupImportReqBO reqBO)。
- 项目内依赖：com.feijimiao.xianyuassistant.backup.DataBackupHandler、com.feijimiao.xianyuassistant.service.DataBackupService、com.feijimiao.xianyuassistant.service.bo.*。
- 主要外部依赖：com.fasterxml.jackson.core.type.TypeReference、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/EmailNotifyServiceImpl.java

- 主类型：EmailNotifyServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：508 行；文件大小 28792 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Async。
- 显式方法：sendWsDisconnectNotifyEmail(Long accountId, String accountNote)；isWsDisconnectNotifyEnabled()；sendCookieExpireNotifyEmail(Long accountId, String accountNote)；isCookieExpireNotifyEnabled()；isEmailConfigured()；sendTestEmail()；buildTestEmailContent(String time)；buildMailSender()；buildWsDisconnectEmailContent(Long accountId, String accountNote, String time)；buildCookieExpireEmailContent(Long accountId, String accountNote, String time)；getSettingValue(String key)；isNotEmpty(String str)；sendKamiAlertEmail(String toEmail, String configName, int availableCount, int totalCount)；sendKamiStockOutEmail(String toEmail, String configName, String orderId)；buildKamiStockOutEmailContent(String configName, String orderId, String time)；sendAutoDeliveryFailEmail(String toEmail, String xyGoodsId, String orderId, String failReason)；buildAutoDeliveryFailEmailContent(String xyGoodsId, String orderId, String failReason, String time)；buildKamiAlertEmailContent(String configName, int availableCount, int totalCount, String time)；sendCaptchaRequiredEmail(Long accountId, String accountNote, String reason)；buildCaptchaRequiredEmailContent(Long accountId, String accountNote, String reason, String time)。
- 项目内依赖：com.feijimiao.xianyuassistant.service.EmailNotifyService、com.feijimiao.xianyuassistant.service.SysSettingService。
- 主要外部依赖：jakarta.mail.internet.MimeMessage、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.mail.javamail.JavaMailSenderImpl、org.springframework.mail.javamail.MimeMessageHelper、org.springframework.scheduling.annotation.Async、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/EnhancedMessageSendServiceImpl.java

- 主类型：EnhancedMessageSendServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：170 行；文件大小 6745 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override。
- 显式方法：sendMessageWithRetry(Long accountId, String chatId, String toUserId, String message)；sendMessageWithRetry(Long accountId, String chatId, String toUserId, String message, boolean simulateHumanDelay)；simulateHumanTypingDelay(String message)；getMessageSendStats(Long accountId)；resetMessageSendStats(Long accountId)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.WebSocketConfig、com.feijimiao.xianyuassistant.service.EnhancedMessageSendService、com.feijimiao.xianyuassistant.service.WebSocketService、com.feijimiao.xianyuassistant.websocket.XianyuWebSocketClient。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/GoodsInfoServiceImpl.java

- 主类型：GoodsInfoServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
- 规模：371 行；文件大小 17014 字节。
- 职责判断：业务服务实现层，编排持久化、远端调用、缓存或消息链路。
- 注解：@Slf4j、@Service、@Autowired、@Override、@Transactional(rollbackFor = Exception.class)。
- 显式方法：getCurrentTimeString()；saveOrUpdateGoodsInfo(ItemDTO itemDTO, Long xianyuAccountId)；batchSaveOrUpdateGoodsInfo(List&lt;ItemDTO&gt; itemList, Long xianyuAccountId)；getByXyGoodId(String xyGoodId)；listByStatus(Integer status)；listByStatusAndAccountId(Integer status, Long xianyuAccountId)；listByStatus(Integer status, int pageNum, int pageSize)；listByStatusAndAccountId(Integer status, Long xianyuAccountId, int pageNum, int pageSize)；listByAccountId(Long xianyuAccountId, int pageNum, int pageSize)；countByStatusAndAccountId(Integer status, Long xianyuAccountId)；countByAccountId(Long xianyuAccountId)；updateDetailInfo(String xyGoodId, String detailInfo)；getDetailInfoByGoodsId(String xyGoodId)；deleteGoodsInfo(Long xianyuAccountId, String xyGoodId)；updateSkuCount(String xyGoodId, int skuCount)；markOfflineIfNotInRemote(Long xianyuAccountId, Set&lt;String&gt; remoteItemIds)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper、com.feijimiao.xianyuassistant.controller.dto.ItemDTO、com.feijimiao.xianyuassistant.service.GoodsInfoService。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、org.springframework.transaction.annotation.Transactional。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/impl/GoodsSkuPropertyServiceImpl.java

- 主类型：GoodsSkuPropertyServiceImpl
- 包：com.feijimiao.xianyuassistant.service.impl
