# 数据模型、配置与持久化

## SQLite 数据域

schema.sql 定义 18 个主要业务表以及配套索引和更新时间触发器。

### 身份域

- `sys_user`：系统登录用户，包含用户名、密码摘要和登录时间。
- `sys_login_token`：登录令牌、用户关联和过期时间。
- 用户名、Token、用户 ID 和过期时间均有索引。

### 闲鱼账号域

- `xianyu_account`：闲鱼账号标识与展示信息。
- `xianyu_cookie`：Cookie、设备标识、Token 状态与过期信息。
- 一个账号可对应凭证记录，连接和远端请求以 accountId 为隔离键。

### 商品域

- `xianyu_goods`：同步到本地的商品主数据。
- `xianyu_goods_config`：自动发货、自动确认、自动回复等商品开关。
- `xianyu_goods_sku`：SKU 价格、库存、属性文本和远端特征 JSON。
- `xianyu_goods_sku_property`：属性维度与属性值的规范化保存。
- xyGoodId/xyGoodsId 是贯穿商品、配置、回复和订单的远端业务键。

### 消息与回复域

- `xianyu_chat_message`：消息内容、类型、发送方、会话、商品和时间。
- `xianyu_goods_auto_reply_record`：买家消息、回复内容、类型、命中关键词、触发上下文和状态。
- `xianyu_keyword_reply_rule`：关键词、匹配模式和兜底标记。
- `xianyu_keyword_reply_content`：规则对应的文本或图片。
- `xianyu_human_intervention_record`：会话人工接管截止时间。

### 发货与卡密域

- `xianyu_goods_auto_delivery_config`：商品/SKU 发货模式、内容、卡密绑定、图片和自动确认开关。
- `xianyu_goods_order`：付款消息、订单、买家、会话、发货状态、确认状态和金额数量。
- `xianyu_kami_config`：卡密集合、预警策略和冗余库存统计。
- `xianyu_kami_item`：单条卡密、使用状态、订单和排序。
- `xianyu_kami_usage_record`：已交付卡密的审计记录。

### 系统域

- `xianyu_operation_log`：模块、动作、状态、目标、请求响应、错误、客户端信息和耗时。
- `xianyu_sys_setting`：键值式动态配置。

## 一致性机制

SQLite 外键表达了主要关联，但实际约束效果还依赖连接是否启用 foreign_keys pragma，应由 DatabaseConfig 明确保证。

多个表使用唯一索引实现幂等：消息 pnmId、发货 pnmId、回复会话消息、商品配置、SKU、卡密使用等。

更新时间主要通过 AFTER UPDATE 触发器回写。业务代码不应假设所有 update_time 都由 MyBatis 自动填充。

卡密配置中的 total_count/used_count 是冗余统计，写入卡密明细或使用记录时必须同步维护，或提供可靠重算路径。

## 应用配置

- `server.port=12400`。
- Jackson 使用 `yyyy-MM-dd HH:mm:ss` 和 GMT+8。
- SQLite URL 为 `jdbc:sqlite:dbdata/xianyu_assistant.db`。
- SimpleVectorStore 文件为 `dbdata/vectorstore.json`。
- AI 默认开启，但未配置 API Key 时自动降级。
- WebSocket 心跳间隔 15 秒、超时 5 秒。
- Token 刷新间隔 3600 秒，失败重试间隔 300 秒。
- 凭证保活随机区间 15 到 20 分钟。
- 消息过期 5 分钟，人工模式默认 1 小时。
- 重连延迟 5 秒，最大重连 10 次。
- 消息发送重试 3 次，间隔 1000 毫秒。
- 原始解密消息打印默认开启。

## 动态系统设置

schema 初始化 sys_prompt、ai_api_key、ai_base_url、ai_model、WebSocket 断连邮件开关和 Cookie 过期邮件开关。

AI Base URL 默认指向 DashScope OpenAI 兼容模式，模型默认 deepseek-v3。

设置页修改 AI 参数后，动态客户端管理器应失效旧实例并按新配置创建客户端，无需重启。

## 配置风险

application.yaml 含固定 JWT secret。公开部署应改用环境变量或首次启动生成的外部密钥，否则不同实例共享密钥且源码泄露后 Token 可被伪造。

`print-raw-message: true` 可能把买家消息、订单或其他敏感内容写入日志，生产环境应评估关闭或脱敏。

Cookie、Token、API Key、卡密内容和备份文件均是敏感数据。日志、异常、操作记录、导出文件和前端提示不得回显完整秘密。

SQLite 适合单实例本地部署。多进程或多副本共享同一数据库文件会增加锁竞争和一致性风险，当前架构更适合单后端实例。

## 数据演进建议

schema 当前以幂等 DDL 和局部 DROP/CREATE INDEX 演进。随着版本增长，建议建立显式 schema version 和顺序迁移记录，避免仅凭启动脚本难以判断历史升级路径。

新增字段时需同步实体、DTO、Mapper 查询、备份处理器、前端类型和导入兼容逻辑。

删除数据时应确认子表清理策略；只有关键词内容明确声明 ON DELETE CASCADE，其他关系可能需要服务层显式删除。
