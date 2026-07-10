# 系统架构与技术栈

## 产品定位

XianYuAssistant 是一个面向闲鱼卖家的本地化自动化管理系统，核心能力包括账号与凭证管理、WebSocket 长连接、商品同步、消息留存、关键词与 RAG 自动回复、自动发货、卡密库存、订单处理、仪表盘、操作日志和数据备份。

系统采用前后端分离开发、同仓库交付的形态。后端提供 JSON/SSE API 并承载闲鱼协议交互；Vue 前端负责配置、监控和人工操作。

## 总体组件

```text
Vue 3 管理端
  -> Axios / fetch
Spring MVC 控制器
  -> 业务服务与策略解析器
  -> MyBatis-Plus / SQLite
  -> OkHttp / Java-WebSocket / Playwright
  -> Spring AI / SimpleVectorStore
闲鱼 HTTP、WebSocket、二维码登录与 AI 兼容接口
```

## 后端基础栈

- Java 21。
- Spring Boot 3.5.7。
- Spring MVC、Bean Validation、Mail、异步任务和调度任务。
- MyBatis-Plus 3.5.5。
- SQLite JDBC 3.42.0.0，默认数据库位于 `dbdata/xianyu_assistant.db`。
- Java-WebSocket 1.5.4 负责长连接客户端。
- OkHttp 4.12.0 负责闲鱼 HTTP 接口调用。
- Playwright 1.40.0 用于需要浏览器上下文的二维码或凭证流程。
- ZXing 3.5.3 生成或处理二维码。
- MessagePack 0.9.8 参与二进制消息协议处理。
- JJWT 0.12.6 与 Spring Security Crypto 负责登录令牌和密码相关能力。
- Spring AI 1.1.4、OpenAI 兼容模型客户端和 SimpleVectorStore 提供 RAG 能力。
- Lombok 减少实体、DTO 和服务类样板代码。

## 前端基础栈

- Vue 3.5.22，主要使用 Composition API 与 `<script setup>`。
- Vue Router 4.6.3 管理登录页和业务页面。
- Pinia 3.0.3 已引入，但当前显式 store 主要是模板式 counter，核心业务状态多在页面 composable 内维护。
- Axios 1.16.0 作为常规 `/api` 请求客户端。
- 原生 fetch 用于 `/ai` SSE/特殊请求及日志文件下载。
- Vite 7.1.11、TypeScript 5.9、vue-tsc 3.1.1。
- xlsx 0.18.5 用于表格数据处理或导出场景。

## 代码规模与分层

- Java 文件 306 个，其中 DTO 85 个、服务接口 32 个、服务实现 29 个、Mapper 21 个、实体 21 个、控制器 20 个。
- 前端包含 106 个 Vue 文件和 37 个 TypeScript 文件。
- 后端主要包为 controller、service、entity、mapper、websocket、event、backup、config、utils、exception。
- 前端主要目录为 api、views、components、router、utils、stores 和 assets。

## 运行边界

HTTP 服务默认监听 12400 端口。

后端同时管理每个闲鱼账号的 WebSocket 客户端、心跳任务、Token 刷新任务和重连任务，因此它既是 Web 应用，也是有状态连接守护进程。

SQLite、向量存储、上传文件和日志属于本地持久化资产，容器化部署时必须正确挂载，否则容器重建会导致数据丢失。

AI API Key、Base URL 和模型名主要存放在 `xianyu_sys_setting`，由动态管理器读取，以实现无需重启的配置更新。

## 关键设计模式

- Controller-Service-Mapper 分层：隔离 HTTP、业务和持久化。
- 策略模式：自动发货与自动回复分别通过策略接口、上下文和解析器选择实现。
- 事件驱动：WebSocket 消息解析后发布聊天消息事件，由保存、自动发货、自动回复、人工干预监听器分别处理。
- 模块化备份：不同数据域由独立 BackupHandler 实现导入导出。
- 动态客户端：AI ChatClient 与 VectorStore 根据数据库配置动态建立或刷新。
- 本地缓存：CacheService 抽象及 LocalMap 实现承载短期状态。
- 上下文模式：UserContext 为当前 HTTP 请求传播登录用户信息。

## 架构上的重要事实

前端常规请求工具的 baseURL 为 `/api`，但 AIChatController 的类级路径是 `/ai`，因此 AI 模块不能直接复用同一 baseURL，源码中明确使用 fetch 直连 `/ai/*`。

系统版本存在两个可见来源：Maven/前端包版本为 2.0.3，而 `application.yaml` 的 `app.version` 为 1.1.8。发布流程应明确哪个来源是权威值，并避免版本展示漂移。

后端长期任务由 Spring `@Scheduled`、`@Async` 以及显式 `ScheduledExecutorService` 混合实现。关闭应用时需要确保连接、线程池和延迟任务被释放。
