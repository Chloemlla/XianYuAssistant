# Java 源码逐文件技术索引（第 11 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 注解：@Slf4j、@Service、@Autowired、@PostConstruct、@PreDestroy、@Override。
- 显式方法：init()；shutdown()；submitDelayTask(ChatMessageData messageData)；cancelDelayTask(Long accountId, String sId)；getPendingTaskCount()；recordSellerManualReply(Long accountId, String xyGoodsId, String sId)；buildTaskKey(Long accountId, String sId)。
- 项目内依赖：com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.service.AutoReplyDelayService、com.feijimiao.xianyuassistant.service.AutoReplyService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Service、jakarta.annotation.PostConstruct、jakarta.annotation.PreDestroy。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/HumanTakeoverManager.java

- 主类型：HumanTakeoverManager
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：152 行；文件大小 5387 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
- 注解：@Slf4j、@Component、@PostConstruct、@PreDestroy。
- 显式方法：init()；destroy()；takeover(Long accountId, String sId, int minutes)；takeover(Long accountId, String sId)；isTakenOver(Long accountId, String sId)；getActiveCount()；cleanup()；buildKey(Long accountId, String sId)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：jakarta.annotation.PostConstruct、jakarta.annotation.PreDestroy、lombok.extern.slf4j.Slf4j、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/KeywordReplyStrategy.java

- 主类型：KeywordReplyStrategy
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：77 行；文件大小 3137 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
- 注解：@Slf4j、@Component、@Autowired、@Override。
- 显式方法：execute(List&lt;ChatMessageData&gt; messageList)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.bo.KeywordReplyRuleBO、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.service.KeywordReplyService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/KeywordWithAIPolishStrategy.java

- 主类型：KeywordWithAIPolishStrategy
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：145 行；文件大小 6521 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
- 注解：@Slf4j、@Component、@Autowired、@Override。
- 显式方法：execute(List&lt;ChatMessageData&gt; messageList)；executeKeywordWithPolish(Long accountId, List&lt;KeywordReplyRuleBO&gt; matchedRules)；executeAIReply(Long accountId, String xyGoodsId, String buyerMessage)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.rag.DynamicAIChatClientManager、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.entity.bo.KeywordReplyRuleBO、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper、com.feijimiao.xianyuassistant.service.AIService、com.feijimiao.xianyuassistant.service.KeywordReplyService、com.feijimiao.xianyuassistant.service.bo.RAGReplyResult。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/ReplyConfigProvider.java

- 主类型：ReplyConfigProvider
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：104 行；文件大小 4507 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
- 注解：@Slf4j、@Component、@Autowired。
- 显式方法：getDelaySeconds(Long accountId, String xyGoodsId)；isHumanInterventionEnabled(Long accountId, String xyGoodsId)；getInterventionMinutes(Long accountId, String xyGoodsId)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoDeliveryConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/ReplyStrategy.java

- 主类型：ReplyStrategy
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：63 行；文件大小 2094 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
- 注解：@lombok.Data。
- 显式方法：text(String text, int replyType)；image(String imageUrl, int replyType)；textAndImage(String text, String imageUrl, int replyType)；of(List&lt;ReplyItem&gt; items)；fail()。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.bo.KeywordReplyRuleBO、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/reply/ReplyStrategyResolver.java

- 主类型：ReplyStrategyResolver
- 包：com.feijimiao.xianyuassistant.service.reply
- 规模：52 行；文件大小 1933 字节。
- 职责判断：自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。
- 注解：@Slf4j、@Component、@Autowired。
- 显式方法：resolve(List&lt;ChatMessageData&gt; messageList)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.entity.bo.KeywordReplyRuleBO、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.service.KeywordReplyService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/RiskControlService.java

- 主类型：RiskControlService
- 包：com.feijimiao.xianyuassistant.service
- 规模：60 行；文件大小 1355 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/SentMessageSaveService.java

- 主类型：SentMessageSaveService
- 包：com.feijimiao.xianyuassistant.service
- 规模：64 行；文件大小 2192 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/SysSettingService.java

- 主类型：SysSettingService
- 包：com.feijimiao.xianyuassistant.service
- 规模：38 行；文件大小 711 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.service.bo.*。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/TokenRefreshService.java

- 主类型：TokenRefreshService
- 包：com.feijimiao.xianyuassistant.service
- 规模：38 行；文件大小 930 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/WebSocketService.java

- 主类型：WebSocketService
- 包：com.feijimiao.xianyuassistant.service
- 规模：85 行；文件大小 2391 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/WebSocketTokenService.java

- 主类型：WebSocketTokenService
- 包：com.feijimiao.xianyuassistant.service
- 规模：46 行；文件大小 1102 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/util/JwtUtil.java

- 主类型：JwtUtil
- 包：com.feijimiao.xianyuassistant.util
- 规模：123 行；文件大小 3351 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：@Slf4j、@Component、@Value("${jwt.secret:xianyu-assistant-jwt-secret-key-2026-04-22-very-long-secret}")、@Value("${jwt.expiration:2592000000}")。
- 显式方法：generateToken(Long userId, String username)；createToken(Map&lt;String, Object&gt; claims, String subject)；parseToken(String token)；getUserIdFromToken(String token)；getUsernameFromToken(String token)；validateToken(String token)；getExpiration()；getSecretKey()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Value、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/AccountDisplayNameUtils.java

- 主类型：AccountDisplayNameUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：109 行；文件大小 3260 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j、@Component、@Autowired。
- 显式方法：getDisplayName(Long accountId)；getDisplayName(String accountId)；updateCache(Long accountId, String accountNote)；clearCache(Long accountId)；clearAllCache()。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/CookieUtils.java

- 主类型：CookieUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：102 行；文件大小 3015 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j。
- 显式方法：parseCookies(String cookieStr)；formatCookies(Map&lt;String, String&gt; cookies)；extractToken(String cookieStr)；generateSign(String timestamp, String token, String data)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/DatabaseChecker.java

- 主类型：DatabaseChecker
- 包：com.feijimiao.xianyuassistant.utils
- 规模：79 行；文件大小 3305 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j、@Component、@Autowired、@PostConstruct。
- 显式方法：checkAutoDeliveryConfigData()；addAutoDeliveryImageUrlColumn()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.jdbc.core.JdbcTemplate、org.springframework.stereotype.Component、jakarta.annotation.PostConstruct。
- Web 映射注解：无。
- 持久化表线索：sqlite_master、xianyu_goods_auto_delivery_config。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/HttpClientUtils.java

- 主类型：HttpClientUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：170 行；文件大小 6336 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j。
- 显式方法：post(String url, Map&lt;String, String&gt; headers, Map&lt;String, String&gt; body)；postWithHeaders(String url, Map&lt;String, String&gt; headers, Map&lt;String, String&gt; body)；getBody()；setBody(String body)；getStatusCode()；setStatusCode(int statusCode)；getHeaders()；setHeaders(HttpHeaders headers)；getHeaderValues(String headerName)；get(String url, Map&lt;String, String&gt; headers)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.http.*、org.springframework.web.client.RestTemplate。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/HumanLikeDelayUtils.java

- 主类型：HumanLikeDelayUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：120 行；文件大小 3562 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j。
- 显式方法：shortDelay()；mediumDelay()；longDelay()；delay(int minMs, int maxMs)；readingDelay(int textLength)；thinkingDelay()；typingDelay(int textLength)；pageScrollDelay()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/ItemDetailUtils.java

- 主类型：ItemDetailUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：210 行；文件大小 9509 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j。
- 显式方法：extractDescFromDetailJson(String detailJson)；extractSkuList(String detailJson)；extractSkuPropertyList(String detailJson)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSku、com.feijimiao.xianyuassistant.entity.XianyuGoodsSkuProperty。
- 主要外部依赖：com.fasterxml.jackson.databind.JsonNode、com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/MessageDecryptUtils.java

- 主类型：MessageDecryptUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：109 行；文件大小 4339 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j。
- 显式方法：decrypt(String encryptedData)；tryDecrypt(String message)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.msgpack.core.MessagePack、org.msgpack.core.MessageUnpacker、org.msgpack.value.Value。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/OperationLogUtils.java

- 主类型：OperationLogUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：168 行；文件大小 6727 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j、@Component、@Autowired。
- 显式方法：logWebSocketConnect(Long accountId, boolean success, String errorMessage)；logWebSocketReconnect(Long accountId, boolean success, boolean isManual, String errorMessage)；logAccountAdd(Long accountId, String accountNote, boolean success, String errorMessage)；logQRLogin(Long accountId, boolean success, String errorMessage)；logCookieUpdate(Long accountId, boolean success, String errorMessage)；logTokenRefresh(Long accountId, String tokenType, boolean success, String errorMessage)。
- 项目内依赖：com.feijimiao.xianyuassistant.constants.OperationConstants、com.feijimiao.xianyuassistant.service.OperationLogService。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/SessionCookieJar.java

- 主类型：SessionCookieJar
- 包：com.feijimiao.xianyuassistant.utils
- 规模：213 行；文件大小 7195 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Override。
- 显式方法：initFromCookieString(String cookieStr)；getCookieString()；getCookie(String name)；getCookieMap()；getMh5tkToken()；saveFromResponse(HttpUrl url, List&lt;Cookie&gt; cookies)；loadForRequest(HttpUrl url)；extractTopDomain(String host)；createHttpClient()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：okhttp3.Cookie、okhttp3.CookieJar、okhttp3.HttpUrl、okhttp3.OkHttpClient。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/XianyuApiCallUtils.java

- 主类型：XianyuApiCallUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：316 行；文件大小 13157 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j、@Component、@Autowired、@SuppressWarnings("unchecked")。
- 显式方法：updateCookiesFromResponse(Long accountId, String currentCookieStr, List&lt;String&gt; setCookieHeaders)；mergeCookies(String oldCookieStr, List&lt;String&gt; newCookies)；isTokenExpired(String retCode)；isRiskControl(String retCode)；isSuccess()；getResponse()；getErrorMessage()；isTokenExpired()；extractData()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/XianyuApiUtils.java

- 主类型：XianyuApiUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：381 行；文件大小 13866 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j、@SuppressWarnings("unchecked")。
- 显式方法：buildStandardHeaders(String cookiesStr)；buildStandardParams(String apiName, String timestamp, String sign)；addSpmParams(Map&lt;String, String&gt; params, String spmCnt, String spmPre)；getBody()；getHeaders()；getSetCookieHeaders()；callApi(String apiName, Map&lt;String, Object&gt; dataMap, String cookiesStr)；buildUrl(String apiName, Map&lt;String, String&gt; params)；isSuccess(String response)；extractData(String response)；extractError(String response)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/XianyuDeviceUtils.java

- 主类型：XianyuDeviceUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：87 行；文件大小 2589 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j。
- 显式方法：generateDeviceId(String userId)；generateMid()；generateUuid()；main(String[] args)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/utils/XianyuSignUtils.java

- 主类型：XianyuSignUtils
- 包：com.feijimiao.xianyuassistant.utils
- 规模：94 行；文件大小 2864 字节。
- 职责判断：远端协议、签名、Cookie、JSON、邮件等通用技术工具。
- 注解：@Slf4j。
- 显式方法：parseCookies(String cookiesStr)；generateSign(String timestamp, String token, String data)；extractToken(Map&lt;String, String&gt; cookies)；formatCookies(Map&lt;String, String&gt; cookies)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/websocket/DefaultWebSocketMessageHandler.java

- 主类型：DefaultWebSocketMessageHandler
- 包：com.feijimiao.xianyuassistant.websocket
- 规模：40 行；文件大小 1190 字节。
- 职责判断：闲鱼长连接、消息解析、连接状态或事件分发组件。
- 注解：@Slf4j、@Component、@Autowired、@Override。
- 显式方法：handleMessage(String accountId, Map&lt;String, Object&gt; message)；handleHeartbeat(String accountId)；handleError(String accountId, Exception error)。
