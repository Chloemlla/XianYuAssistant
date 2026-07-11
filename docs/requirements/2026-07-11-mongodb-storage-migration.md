# MongoDB 全量数据存储迁移需求

## 目标

将 XianYuAssistant 当前依赖 SQLite、MyBatis-Plus/JDBC 及本地业务数据文件的持久化实现迁移为 MongoDB，使 MongoDB 成为应用唯一的业务数据持久化数据库。

## 交付物

- 使用 Spring Data MongoDB 替代 SQLite JDBC、MyBatis-Plus Mapper 和数据库初始化逻辑。
- 将现有业务实体映射为 MongoDB 文档，并保留对外 API 的字段、行为和主要排序/分页语义。
- 将业务查询、更新、删除、统计、备份和恢复逻辑迁移到 MongoDB。
- 审计本地持久化文件；上传文件等业务二进制数据若存在本地落盘，则迁移到 GridFS。
- 移除 SQLite schema、SQLite 专用配置和运行时检查。
- 更新 Docker、应用配置、说明文档及 GitHub Actions 验证入口。

## 约束

- 不在本机执行 Maven、Flutter、Gradle、前端构建或测试命令。
- 实际编译和测试只能通过 GitHub Actions 执行。
- 使用 UTF-8 PowerShell 方式读取中文文件。
- 不创建承载大量无关职责的“超级文件”；按领域拆分文档、Repository 和基础设施代码。
- 完成后生成提交信息，提交并推送；允许临时跳过 GPG 签名。

## 验收标准

- 生产代码不再依赖 SQLite JDBC、DataSource、JdbcTemplate、MyBatis-Plus Mapper 或 SQL schema 初始化。
- 所有原业务实体均有 MongoDB 持久化路径，关键唯一性和查询性能约束通过索引表达。
- 原有控制器和前端 API 契约无需因数据库迁移而改变。
- 备份/恢复功能基于 MongoDB 数据工作。
- 配置可通过环境变量提供 MongoDB URI 和数据库名。
- GitHub Actions 中的编译/测试或容器构建验证通过后，才使用“完成”措辞。

## 产品验收与人工抽查

- 新环境连接 MongoDB 后可启动并自动创建必要索引。
- 账户、Cookie、商品、SKU、关键词回复、消息、订单、卡密、设置和操作日志可完成增删改查。
- 备份导出后可在空数据库中恢复。
- 重启应用后数据仍存在，且不再生成 SQLite 数据库文件。

## 非目标

- 不改动 Vue 页面交互与视觉设计。
- 不迁移仓库中的静态网页资源、文档图片和构建产物到 MongoDB。
- 不提供从既有 SQLite 文件在线自动搬迁历史数据的工具；本次聚焦应用存储后端替换。

## 推断与完成语言

- “数据存储全部换成 MongoDB”解释为所有运行期业务持久化；纯缓存、静态资源和临时文件不属于业务持久化。
- 若普通 MongoDB 无法直接提供现有 SimpleVectorStore 的向量检索语义，则优先使用 Spring AI MongoDB Atlas Vector Store，并明确其部署前置条件。
- 未取得 GitHub Actions 成功证据时，只能说明代码迁移已提交、CI 待验证或失败原因，不能声称完整迁移已验证通过。
