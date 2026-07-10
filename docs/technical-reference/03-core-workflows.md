# 核心业务链路

## 账号接入与凭证

账号可通过二维码或手工凭证方式添加。二维码流程由前端弹窗调用 QRLoginController，后端通过 QRLoginService 和 PlaywrightManager 维护短期会话，前端轮询登录状态并在成功后获取 Cookie。

账号、Cookie、WebSocket Token 和设备标识被拆分保存。连接启动前会读取账号与 Cookie，必要时刷新 `_m_h5_tk` 或获取 WebSocket access token。

Cookie 或 Token 失效会抛出专门异常，并可触发前端更新凭证、二维码刷新或自动重试流程。

TokenRefreshServiceImpl 含多个定时检查入口；WebSocketServiceImpl 也维护按账号的 tokenRefreshTasks。修改刷新策略时必须检查是否会出现重复刷新或竞争重连。

## WebSocket 连接

启动连接时，WebSocketController 调用 WebSocketService，服务构造请求头和客户端，连接闲鱼 WebSocket 地址，再由 WebSocketInitializer 执行初始化握手。

每个账号对应一个 XianyuWebSocketClient，并在 ConcurrentHashMap 中维护。连接后启动心跳和 Token 刷新任务。

连接关闭时，根据主动关闭、Token 失效或网络异常等状态决定是否进入自动重连。重连有延迟与最大次数配置。

发送文本和图片都要求目标账号客户端存在且处于连接状态；失败会返回错误并写操作日志。

应用关闭时 WebSocketServiceImpl 的清理逻辑停止所有连接和相关任务。

## 入站消息事件链

XianyuWebSocketClient 接收原始帧后交给 WebSocketMessageHandler 解码、识别消息类型并构造 ChatMessageData。

处理器发布 ChatMessageReceivedEvent，把“收到消息”与具体业务动作解耦。

ChatMessageEventSaveListener 负责保存消息，唯一索引用账号与 pnmId 等键防止重复入库。

ChatMessageEventHumanInterventionListener 识别人工接管切换信号并维护会话暂停自动化的时间窗口。

ChatMessageEventAutoReplyListener 进入回复策略链。

ChatMessageEventAutoDeliveryListener 识别订单/付款相关消息并进入发货链。

## 自动回复

商品配置决定是否启用自动回复，以及 RAG 延迟等参数。

关键词回复由规则表和内容表组成，支持模糊匹配、精准匹配和未匹配兜底规则；一个规则可以对应文本和图片内容。

reply 包中的策略解析器根据上下文选择关键词、RAG 或其他回复策略。关键词通常应优先于成本更高且结果不确定的 AI 路径。

RAG 路径使用 DynamicAIChatClientManager 和 DynamicVectorStoreManager。API Key 缺失时设计为降级，而不是阻止整个系统启动。

SimpleVectorStore 持久化到 `dbdata/vectorstore.json`。商品详情可同步为固定资料，额外资料可通过 `/ai/putNewData` 加入。

AutoReplyDelayService 管理延迟发送和去重；自动回复记录表使用账号、会话和消息标识的唯一约束降低重复回复风险。

人工接管记录在指定结束时间前应抑制自动回复，避免机器人与卖家同时发送。

## 自动发货

商品发货配置支持商品级或 SKU 级。唯一索引把空 SKU 归一化，保证同账号、同商品、同 SKU 只有一份配置。

发货模式包括自动文本/图片、卡密和自定义 API 等形态，由 DeliveryStrategyResolver 选择 DeliveryContentStrategy。

OrderDetailFetcher 获取订单与 SKU 上下文；DeliveryContext 聚合账号、商品、买家、订单、会话和配置。

卡密策略从绑定的卡密配置中原子选择未使用明细，写入使用记录，并按模板替换 `{kmKey}`。需要关注并发订单下的库存一致性和重复订单幂等。

发送成功后更新 xianyu_goods_order 状态；若启用自动确认发货，再调用闲鱼确认接口并更新 confirm_state。

pnmId 唯一索引用于避免同一付款消息重复创建发货记录，orderId 索引用于后续查询和确认。

待发货页面支持人工批量触发以及虚拟发货，属于自动链路失败后的运营补偿入口。

## 商品同步

商品列表和详情通过闲鱼 HTTP API 获取，写入 xianyu_goods、SKU 和 SKU 属性表。

全量刷新返回 syncId，前端通过 `/api/items/syncProgress/{syncId}` 轮询进度，并可通过 `/syncing/{accountId}` 判断账号是否已有同步任务。

商品基础配置、自动发货配置、关键词规则和 RAG 资料都以 xyGoodsId 关联；删除或重新同步时要避免产生孤儿配置。

## 备份与恢复

DataBackupService 按模块委派给 Account、Goods、AutoDelivery、AutoReply、Kami 和 SystemSetting 处理器。

导出请求选择模块并产生结构化备份；导入请求应分别报告成功、失败和跳过数量。

备份恢复不是数据库文件的裸复制，因此模块处理器需要维持 ID 映射、依赖顺序和唯一键冲突策略。
