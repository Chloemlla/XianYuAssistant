# 后端分层与 HTTP 接口

## 请求通用链路

请求通常先进入 AuthInterceptor。标注 `@NoAuth` 的入口可跳过登录校验；其余接口通过令牌解析建立 UserContext，再由控制器把 DTO 转换为服务层参数，最终统一封装为 ResultObject。

GlobalExceptionHandler 把 BusinessException、TokenInvalidException、CookieExpiredException、CookieNotFoundException、CaptchaRequiredException 等异常转换成前端可消费的响应。

## 控制器域

- `/api/login`：检查用户、注册、登录、退出。
- `/api/system`：当前用户、修改密码、版本与更新检查。
- `/api/account`：闲鱼账号列表、新增、手工新增、更新、删除和详情。
- `/api/qrlogin`：生成二维码、轮询状态、读取 Cookie 和清理会话。
- `/api/websocket`：启动/停止连接、发送文本或图片、读取状态、刷新 Cookie/Token、登录检查和验证码等待状态。
- `/api/items`：商品刷新、查询、详情、自动发货/确认/回复开关、删除、单品同步、记录和同步进度。
- `/api/goods-sku`：SKU 列表和详情。
- `/api/order`：订单列表、确认发货、详情、待发货订单、批量交付和虚拟发货。
- `/api/autoDelivery`：自动或手动触发发货。
- `/api/auto-delivery-config`：保存、读取、按商品列出、分页列出和删除发货配置。
- `/api/kami-config`：卡密配置、卡密明细、批量导入、查询、重置和导出。
- `/api/keyword-reply`：关键词规则、兜底规则和回复内容的增删改。
- `/api/msg`：消息列表和上下文。
- `/ai`：SSE 对话、测试对话、RAG 数据增删查、固定资料保存读取和商品详情同步。
- `/api/dashboard` 与 `/api/data-panel`：统计、趋势、实时收入和销售收入。
- `/api/setting`：系统设置读取、列表、保存、删除和邮件测试。
- `/api/backup`：备份模块、导出、导入、日志日期和日志下载。
- `/api/operation-log`：操作日志查询和历史清理。
- `/api/image`：文件上传和 URL 图片转存。

## 服务层分工

AccountService 管理账号主数据；CookieService、CookieRefreshService、TokenRefreshService 与 WebSocketTokenService 管理多种凭证生命周期。

WebSocketService 是连接生命周期门面，WebSocketServiceImpl 保存账号到客户端及定时任务的映射，并处理启动、停止、消息发送、心跳、刷新和重连。

ItemService、XianyuApiService 和 SKU 相关服务负责远端商品获取、本地同步、详情解析和配置关联。

OrderService、AutoDeliveryService、AutoDeliveryConfigService、ApiDeliveryScheduler 与 delivery 包协作完成订单识别、配置解析、内容生成、发送和确认发货。

AutoReplyService、AutoReplyDelayService、KeywordReplyService、AIService 和 reply 包协作完成关键词优先、RAG 补充、延时去重和发送。

DataBackupService 使用多个模块处理器备份账号、商品、发货、回复、卡密和系统设置。

OperationLogService 采用异步记录，避免日志写入阻塞主业务请求。

## DTO 与 BO

controller/dto 是最大单一包，说明接口边界进行了较细拆分。请求和响应通常是独立类型，例如 ItemListReqDTO/RespDTO、OrderListReqDTO/RespDTO、BackupExportReqDTO/RespDTO。

service/bo 用于控制器 DTO 之外的服务层契约，避免 HTTP 模型直接渗透到核心业务。

维护时要注意 Lombok 自动生成方法不会被简单文本扫描列出，字段变更仍可能改变 JSON 和 Bean Validation 行为。

## 持久化层

Mapper 多数继承 MyBatis-Plus 基础 Mapper，实体通过表名和字段映射连接 SQLite。

CustomLocalDateTimeTypeHandler 处理 SQLite 与 Java 时间类型差异。

MybatisConfig、MybatisPlusConfig 和 DatabaseConfig 共同负责类型处理、分页/插件和数据源行为。

DatabaseInitListener 与 SqlSchemaParser 在启动阶段解析并应用 schema，数据库演进依赖 `CREATE IF NOT EXISTS`、索引重建和兼容 SQL。

## API 维护约定

新增常规接口时，应同时更新控制器映射、DTO、服务接口/实现、前端 api 文件和调用页面。

新增 `/ai` 接口时需特别核对前端是否使用 fetch；把它误放入 baseURL 为 `/api` 的 Axios 工具会形成 `/api/ai/*` 错误路径。

涉及文件下载、SSE 或图片上传的接口不是普通 JSON 请求，应保留响应流、Content-Type 和鉴权头的专门处理。

接口完整逐文件映射见 generated 目录中的 Java 控制器索引和前端 API 索引。
