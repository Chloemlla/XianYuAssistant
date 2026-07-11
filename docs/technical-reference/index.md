# XianYuAssistant 全项目技术参考

## 阅读说明

本文档集基于 2026-07-10 工作区中受版本控制的源码进行静态调研，目标是给维护者提供从系统全貌到逐文件细节的统一入口。

本次没有运行 Maven、Vue、Flutter、Gradle 或任何构建测试；所有结论均来自源码、配置、SQL、依赖清单和部署脚本的静态证据。

文档采用“索引 + 专题章节 + 自动生成逐文件索引”的形式，避免单个超级文件。

## 专题章节

- [系统架构与技术栈](./01-architecture-and-stack.md)
- [后端分层与 HTTP 接口](./02-backend-and-api.md)
- [核心业务链路](./03-core-workflows.md)
- [数据模型、配置与持久化](./04-data-and-configuration.md)
- [前端、部署、运维与风险](./05-frontend-deployment-and-risks.md)
- [自动生成索引状态](./generated/)（迁移前快照已退役）

## 自动生成索引状态

迁移前生成的逐文件索引包含已删除的 SQLite/MyBatis-Plus 实现，不能作为当前架构证据，已从发布文档退役。专题章节已按 MongoDB、Atlas Vector Search、GHCR 与 2.0.3 发布契约更新。

## 维护方式

源码结构变化后，应先升级 `scripts/documentation/Generate-TechnicalReference.ps1` 以识别当前 MongoDB 持久化层，再重建 `generated/`。

该脚本只做静态读取和 Markdown 输出，不调用任何构建系统。

专题章节包含人工判断，生成器不会覆盖，应在架构或业务语义变化时同步维护。
