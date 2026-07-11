# 数据模型、配置与持久化

## MongoDB 数据域

应用通过 Spring Data MongoDB 与 `MongoTemplate` 访问文档集合。默认连接为 `mongodb://localhost:27017/xianyu_assistant`，生产环境必须显式设置 `SPRING_DATA_MONGODB_URI`。

### 身份与凭证

- `sys_user`：系统用户与 BCrypt 密码摘要，用户名唯一。
- `sys_login_token`、`sys_refresh_token`：短期访问令牌和可撤销刷新令牌。
- `xianyu_account`、`xianyu_cookie`：闲鱼账号、Cookie、设备与远端 Token 状态。

首次管理员注册还要求部署者提供 `BOOTSTRAP_TOKEN`。初始化完成后注册入口永久关闭，部署配置中也应移除 bootstrap token。

### 商品、消息与自动化

- `xianyu_goods`、`xianyu_goods_config`、`xianyu_goods_sku`、`xianyu_goods_sku_property` 保存商品与 SKU。
- `xianyu_chat_message`、`xianyu_human_intervention_record` 保存聊天及人工接管窗口。
- `xianyu_keyword_reply_rule`、`xianyu_keyword_reply_content`、`xianyu_goods_auto_reply_record` 保存回复规则与执行记录。
- `xianyu_goods_auto_delivery_config`、`xianyu_goods_order`、`xianyu_order` 保存发货配置、claim 状态和订单。
- `xianyu_kami_config`、`xianyu_kami_item`、`xianyu_kami_usage_record` 保存卡密库存与使用审计。
- `xianyu_operation_log`、`xianyu_sys_setting` 保存操作元数据与动态配置。

实体上的唯一/复合索引保护消息 pnmId、回复会话消息、商品/SKU 配置、卡密使用及发货 claim 等关键约束。涉及多集合的业务操作仍需显式补偿、对账或在支持事务的 MongoDB 拓扑上使用事务。

## AI 向量数据

RAG 使用 MongoDB Atlas Vector Search，而不是本地向量文件：

- `MONGODB_VECTOR_COLLECTION` 默认 `xianyu_vector_store`。
- `MONGODB_VECTOR_INDEX` 默认 `xianyu_vector_index`。
- Atlas 部署需要创建与 embedding 维度、相似度配置匹配的 Vector Search 索引。

普通 MongoDB 可运行非向量业务；启用知识库检索时需要 Atlas Vector Search 能力。

## 必需安全配置

- `JWT_SECRET`：至少 32 字节的外部随机密钥；没有安全值时应用应拒绝启动。
- `BOOTSTRAP_TOKEN`：仅首次管理员注册使用的一次性秘密。
- `SPRING_DATA_MONGODB_URI`：MongoDB URI；可能包含凭证，不得输出到日志或提交仓库。
- `JWT_ACCESS_EXPIRATION_MS`：访问令牌有效期，默认 15 分钟。
- `JWT_REFRESH_EXPIRATION_MS`：刷新令牌有效期，默认 7 天。

AI 预算通过 `AI_MAX_PROMPT_CHARACTERS`、`AI_MAX_CONCURRENT_REQUESTS`、`AI_REQUEST_TIMEOUT_SECONDS` 和 `AI_MAX_OUTPUT_TOKENS` 配置。日志只应记录长度、模型、耗时和状态，不记录 prompt 原文。

## 运行配置

- 服务端口默认 12400。
- MongoDB 自动索引创建默认开启。
- WebSocket 心跳间隔 15 秒、超时 5 秒。
- Token 刷新间隔 3600 秒，失败重试间隔 300 秒。
- 凭证保活随机区间 15 到 20 分钟。
- 原始解密消息日志默认关闭。

## 备份与恢复

应用内备份按模块导出结构化数据，并报告记录级成功、失败和跳过明细。它不能替代数据库灾难恢复：

1. 使用 `mongodump`、Atlas 快照或托管 MongoDB 快照保护整个数据库。
2. 定期在隔离环境执行恢复演练并核对集合数量、索引和关键业务记录。
3. 备份 MongoDB URI、Cookie、Token、卡密或 AI Key 时使用加密存储和严格访问控制。
4. 镜像升级前同时保存数据库备份与当前 GHCR 镜像标签，确保可回滚。

应用容器内不存在需要备份的业务数据库目录；只挂载 `/app/logs` 并不能保护业务数据。
