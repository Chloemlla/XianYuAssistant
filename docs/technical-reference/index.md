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
- [自动生成的逐文件技术索引](./generated/)

## 自动生成索引覆盖

- Java 源文件：306 个。
- Vue 单文件组件：106 个。
- TypeScript 文件：37 个。
- 前端 CSS/SVG、后端资源与根工程文件：按可维护文本资源纳入。
- Java 索引记录包、主类型、行数、职责、注解、方法、项目内依赖、外部依赖、Web 映射和表线索。
- 前端索引记录模块职责、依赖、导出符号、后端 URL、组件组合和 Composition API。
- 资源索引记录文件类型、大小、文本行数、运行角色和维护注意事项。

## 维护方式

源码结构变化后，可运行 `scripts/documentation/Generate-TechnicalReference.ps1` 重建 `generated/`。

该脚本只做静态读取和 Markdown 输出，不调用任何构建系统。

专题章节包含人工判断，生成器不会覆盖，应在架构或业务语义变化时同步维护。
