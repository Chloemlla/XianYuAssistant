# Java 源码逐文件技术索引（第 12 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/websocket/handler/AbstractLwpHandler.java

- 主类型：AbstractLwpHandler
- 包：com.feijimiao.xianyuassistant.websocket.handler
- 规模：180 行；文件大小 5807 字节。
- 职责判断：闲鱼长连接、消息解析、连接状态或事件分发组件。
- 注解：@Slf4j、@Autowired、@SuppressWarnings("unchecked")。
- 显式方法：getDisplayName(String accountId)；logPrefix(String accountId)；handle(String accountId, Map<String, Object> messageData)；preHandle(String accountId, Map<String, Object> messageData)；postHandle(String accountId, Object result, Map<String, Object> messageData)；handleException(String accountId, Map<String, Object> messageData, Exception e)；getString(Map<String, Object> map, String key)；getInteger(Map<String, Object> map, String key)；getLong(Map<String, Object> map, String key)；getMap(Map<String, Object> map, String key)；getList(Map<String, Object> map, String key)。
- 项目内依赖：com.feijimiao.xianyuassistant.utils.AccountDisplayNameUtils。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/websocket/handler/SyncMessageHandler.java

- 主类型：SyncMessageHandler
- 包：com.feijimiao.xianyuassistant.websocket.handler
- 规模：613 行；文件大小 25243 字节。
- 职责判断：闲鱼长连接、消息解析、连接状态或事件分发组件。
- 注解：@Slf4j、@Component、@Autowired、@Override、@SuppressWarnings("unchecked")、@Data。
- 显式方法：getLwpPath()；parseParams(String accountId, Map<String, Object> messageData)；doHandle(String accountId, Object params, Map<String, Object> messageData)；postHandle(String accountId, Object result, Map<String, Object> messageData)；parseAndPublishEvent(String accountId, String decryptedData, String lwp)；publishChatMessageReceivedEvent(XianyuChatMessage message)；extractOrderIdFromMessage(String completeMsg)；extractOrderIdFromDxCard(Map<String, Object> contentMap)；extractOrderIdFromDynamicOperation(Map<String, Object> contentMap)；extractOrderIdFromUrl(String url)；formatJson(String json)；extractItemIdFromUrl(String url)；extractString(Map<String, Object> map, String key)；extractInteger(Map<String, Object> map, String key)；extractLong(Map<String, Object> map, String key)。
- 项目内依赖：com.feijimiao.xianyuassistant.config.WebSocketConfig、com.feijimiao.xianyuassistant.entity.XianyuChatMessage、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageReceivedEvent、com.feijimiao.xianyuassistant.service.GoodsInfoService、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.utils.MessageDecryptUtils。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、org.springframework.beans.BeanUtils、lombok.Data、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.ApplicationEventPublisher、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/websocket/WebSocketInitializer.java

- 主类型：WebSocketInitializer
- 包：com.feijimiao.xianyuassistant.websocket
- 规模：160 行；文件大小 6098 字节。
- 职责判断：闲鱼长连接、消息解析、连接状态或事件分发组件。
- 注解：@Slf4j、@Component、@Autowired。
- 显式方法：generateMid()；getDisplayName(String accountId)；logPrefix(String accountId)；sendRegistrationMessage(XianyuWebSocketClient client, String token, String deviceId, String accountId)；sendSyncStatusMessage(XianyuWebSocketClient client, String accountId)；initialize(XianyuWebSocketClient client, String token, String deviceId, String accountId)。
- 项目内依赖：com.feijimiao.xianyuassistant.utils.AccountDisplayNameUtils。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/websocket/WebSocketMessageHandler.java

- 主类型：WebSocketMessageHandler
- 包：com.feijimiao.xianyuassistant.websocket
- 规模：33 行；文件大小 742 字节。
- 职责判断：闲鱼长连接、消息解析、连接状态或事件分发组件。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/websocket/WebSocketMessageRouter.java

- 主类型：WebSocketMessageRouter
- 包：com.feijimiao.xianyuassistant.websocket
- 规模：244 行；文件大小 8843 字节。
- 职责判断：闲鱼长连接、消息解析、连接状态或事件分发组件。
- 注解：@Slf4j、@Component、@Autowired(required = false)、@Autowired、@Lazy、@SuppressWarnings("unchecked")。
- 显式方法：ensureInitialized()；registerHandlers()；registerHandler(AbstractLwpHandler handler)；route(String accountId, Map<String, Object> messageData)；handleResponseMessage(String accountId, Map<String, Object> messageData)；handleUnknownMessage(String accountId, Map<String, Object> messageData)；updateCookieStatusIfPresent(String accountId, int status)；unregisterHandler(String lwp)；getRegisteredRoutes()；getHandler(String lwp)。
- 项目内依赖：com.feijimiao.xianyuassistant.service.WebSocketService、com.feijimiao.xianyuassistant.websocket.handler.*、com.feijimiao.xianyuassistant.service.AccountService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.annotation.Lazy、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/websocket/XianyuWebSocketClient.java

- 主类型：XianyuWebSocketClient
- 包：com.feijimiao.xianyuassistant.websocket
- 规模：973 行；文件大小 40970 字节。
- 职责判断：闲鱼长连接、消息解析、连接状态或事件分发组件。
- 注解：@Slf4j、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getDisplayName()；logPrefix()；setMessageHandler(WebSocketMessageHandler handler)；setOnRegistrationSuccess(Runnable callback)；setMyUserId(String userId)；setOnTokenExpired(Runnable callback)；setOnHeartbeatResponse(Runnable callback)；setOnConnectionClosed(Runnable callback)；setIntentionalClose(boolean intentional)；onOpen(ServerHandshake handshakedata)；onMessage(String message)；handleMessageWithSemaphore(String message)；handleMessage(String message)；determineMessageDirection(String decryptedData, String accountId)；sendAckMessage(Map<String, Object> messageData)；handleHeartbeatResponse()；onClose(int code, String reason, boolean remote)；onError(Exception ex)；sendHeartbeat()；isConnected()；sendMessage(String cid, String toId, String text)；completePendingResponse(String mid, int code)；sendMessageWithResult(String cid, String toId, String text)；sendImageMessage(String cid, String toId, String imageUrl, int width, int height)；sendImageMessageWithResult(String cid, String toId, String imageUrl, int width, int height)；generateMid()；generateUuid()。
- 项目内依赖：com.feijimiao.xianyuassistant.utils.AccountDisplayNameUtils。
- 主要外部依赖：com.fasterxml.jackson.databind.ObjectMapper、lombok.extern.slf4j.Slf4j、org.java_websocket.client.WebSocketClient、org.java_websocket.handshake.ServerHandshake。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/XianYuAssistantApplication.java

- 主类型：XianYuAssistantApplication
- 包：com.feijimiao.xianyuassistant
- 规模：30 行；文件大小 1372 字节。
- 职责判断：Spring Boot 应用启动入口。
- 注解：@EnableScheduling、@EnableAsync、@SpringBootApplication。
- 显式方法：main(String[] args)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：org.springframework.ai.model.openai.autoconfigure.OpenAiAudioSpeechAutoConfiguration、org.springframework.ai.model.openai.autoconfigure.OpenAiAudioTranscriptionAutoConfiguration、org.springframework.ai.model.openai.autoconfigure.OpenAiChatAutoConfiguration、org.springframework.ai.model.openai.autoconfigure.OpenAiEmbeddingAutoConfiguration、org.springframework.ai.model.openai.autoconfigure.OpenAiImageAutoConfiguration、org.springframework.ai.model.openai.autoconfigure.OpenAiModerationAutoConfiguration、org.springframework.boot.SpringApplication、org.springframework.boot.autoconfigure.SpringBootApplication、org.springframework.scheduling.annotation.EnableAsync、org.springframework.scheduling.annotation.EnableScheduling。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

