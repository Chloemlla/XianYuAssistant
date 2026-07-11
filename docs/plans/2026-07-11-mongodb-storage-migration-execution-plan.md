# MongoDB 全量数据存储迁移执行计划

## 内部等级

XL。原因是迁移横跨依赖、配置、21 个持久化模型、服务查询、备份恢复、文件存储、文档和 CI。

## Wave 1：存储面审计与设计

- 盘点实体、Mapper 自定义方法、查询包装器、JDBC/SQL、备份恢复、本地文件持久化和 Docker 配置。
- 确定文档 ID、引用关系、唯一索引、复合索引、分页与事务策略。
- 所有代理只输出局部审计结果，不修改 canonical requirement/plan。

## Wave 2：基础设施与模型

- 引入 Spring Data MongoDB、必要的 GridFS/向量存储支持，移除 SQLite/MyBatis-Plus。
- 更新应用和容器配置。
- 将实体转换为 MongoDB 文档并声明索引。
- 新建按领域拆分的 Mongo Repository，不创建超级 Repository。

## Wave 3：业务查询迁移

- 分领域迁移账户/认证/设置、商品/SKU/自动发货、消息/订单/日志、关键词/卡密等调用。
- 将 QueryWrapper、UpdateWrapper、自定义 SQL、批处理和统计替换为 Spring Data Repository 或 MongoTemplate。
- 保持控制器和服务接口契约。

## Wave 4：辅助存储迁移

- 将备份恢复改为 MongoDB Repository/MongoTemplate。
- 将本地业务文件持久化迁移为 GridFS；静态和临时文件保留文件系统语义。
- 处理 AI 向量存储的 MongoDB 实现和部署配置。

## Wave 5：静态审计与 CI 验证

- 本地仅执行只读文本检查、git diff 和结构审计，不执行构建/测试。
- 更新 GitHub Actions，使实际 Maven/容器验证在远端工作流中运行。
- 提交并推送，监控对应 Actions；修复失败后再次提交推送，直到通过或遇到外部阻塞。

## 所有权边界

- 根代理：需求、计划、跨模块设计、整合、Git/CI、最终验收。
- 审计代理：分别负责实体/查询、备份/文件/向量、Docker/配置/文档的只读审计。
- 后续实现代理仅修改分配的领域文件，禁止修改需求与计划真相源。

## 验证命令

- 本地允许：`rg` 静态残留审计、`git diff --check`、`git status`。
- GitHub Actions：Maven test/package 和 Docker build；所有实际构建测试均在 workflow 内执行。

## 回滚规则

- 若领域迁移导致 API 语义无法保持，回滚该领域局部提交或改为 MongoTemplate 定制查询，不恢复 SQLite 双写。
- 不执行破坏用户已有工作区改动的 reset/checkout。

## 阶段清理

- 每个 Wave 写入 phase receipt。
- 删除临时审计文件，仅保留需求、计划、验证和清理凭证。
- 审计残留进程；本任务不启动 Node、Flutter、Gradle 或本地构建进程。
