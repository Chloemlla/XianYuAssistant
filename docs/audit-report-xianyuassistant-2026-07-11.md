# Fuck My Shit Mountain Audit Report

**Project:** XianYuAssistant
**Audit mode:** full
**Date:** 2026-07-11
**Reviewer:** Codex（GPT-5）

---

## 1. Executive Summary

XianYuAssistant 已具备完整产品轮廓：账号接入、WebSocket 在线、消息处理、自动回复、自动发货、卡密、AI/RAG、备份恢复和 Docker 发布均已形成闭环；界面视觉统一，领域也开始拆分为 composable、策略类和备份 handler。但当前状态不适合被描述为“稳定公开发布”：最严重的问题不是单纯的页面难看，而是界面状态、后台调度和发布制品都存在“看起来成功，实际可能失败”的可信度缺口。

用户体验方面，登录/注册失败可完全静默，响应式断点会重建整页并丢失未保存输入，客服查看历史消息时又会被 1 秒轮询覆盖并强制滚到底。性能方面，定时任务将全账号扫描、同步网络调用、Playwright 和人工 `sleep` 串在调度线程中，每个 WebSocket 账号还独占 10 线程，并混用裸线程与高频前端轮询；账号数和订单量增长后，用户感知会从“偶尔慢”恶化为连接、发货、刷新、页面请求一起抖动。

最高风险是敏感日志：accessToken、Cookie 请求头、解密聊天和发送文本可进入 INFO 日志。发布链同样不可信：Docker 构建可能用仓库旧静态资源覆盖刚构建的前端，Playwright 浏览器未装入运行镜像，CI 在零测试下仍可绿色通过。建议先止血日志与注册安全，再处理调度/线程模型、备份真实性、Docker 制品和三条关键用户旅程；不建议先做大规模视觉重写。

### Score Dashboard

```text
Security        ███░░░░░░░  3.0  C   日志可直接暴露会话凭证与聊天内容，首次注册还存在管理员抢占窗口；覆盖 High。
Stability       ████░░░░░░  4.1  C   调度阻塞、备份虚假成功和多处静默兜底会让系统状态与用户认知分离；覆盖 High。
Performance     ████░░░░░░  3.8  C   每账号线程池、串行 sleep、裸线程和高频轮询构成系统性扩展瓶颈；覆盖 Medium。
Testing         ██░░░░░░░░  2.0  D   后端零测试、前端零测试，CI 不能证明核心链路正确；覆盖 High。
Maintainability ████░░░░░░  4.3  C   多个 1000—2400 行前端/后端巨型文件与重复状态模式放大改动风险；覆盖 Medium。
Design          ████░░░░░░  4.0  C   状态所有权、并发边界、失败语义和响应式布局边界均不清晰；覆盖 Medium。
Release         ███░░░░░░░  3.4  C   Docker 静态资源顺序、Playwright 缺失、渠道漂移与可变供应链标签阻塞可靠发布；覆盖 High。
─────────────────────────────────────
Overall         ███░░░░░░░  3.5  C
```

每个维度按 0.0—10.0 评分，越高越好。评分是基于证据的工程判断，不是机械扣分。

### Finding Statistics

| Severity | Count | Confirmed | Suspected |
|----------|-------|-----------|-----------|
| Critical | 1 | 1 | 0 |
| High | 9 | 9 | 0 |
| Medium | 10 | 9 | 1 |
| Low | 1 | 1 | 0 |
| Info | 0 | 0 | 0 |
| **Total** | **21** | **20** | **1** |

## 2. Project Map

- 后端：Spring Boot 3.5 / Java 21 单体，Controller → Service → 自研 Mongo Mapper / MongoTemplate。
- 数据：MongoDB 承载业务数据和向量数据；备份按领域 handler 导入导出。
- 外部边界：OkHttp 调闲鱼接口，Java-WebSocket 维持连接，Playwright 负责 Cookie/Token 浏览器兜底，Spring AI 对接模型与 RAG。
- 前端：Vue 3 / Vite，路由懒加载；主要页面以 `index.vue + useXxx.ts + components/` 组织，由 Spring 静态资源托管。
- 核心用户链路：首次注册/登录 → 添加闲鱼账号 → 维护 Cookie/Token → 启动连接 → 同步商品 → 配置自动回复/发货 → 消息人工介入 → 查询订单/日志 → 备份恢复。
- 发布：GitHub Actions 验证后构建多架构 Docker 并推送 GHCR；另有 install.sh、README JAR/Docker 指南和 VitePress 文档。
- 敏感资产：JWT、闲鱼 Cookie/token、聊天与买家信息、卡密、AI key、SMTP 密码、备份文件和日志。

覆盖说明：使用 `rg --files` 建立一方代码清单，检查了主要 Controller/Service/Mapper、调度与线程池、认证、配置、Docker/workflow/install、前端路由/布局/页面/composable、截图和文档。按仓库要求未运行 Maven、npm、Vite、Flutter、Gradle、容器构建或应用测试；未对真实 Mongo 索引、浏览器 accessibility tree、网络时延、模型超时和镜像运行行为做动态验证。生成 bundle、图片、lockfile 正文和 generated 文档索引仅按需抽查。

### Coverage Matrix

| Dimension | Coverage | Evidence inspected | Exclusions / limits |
|-----------|----------|--------------------|---------------------|
| Architecture | Medium | Controller/Service/Mapper、Vue 路由/布局、线程与状态所有权 | 未做运行时依赖图 |
| Security | High | AuthInterceptor、登录注册、JWT、日志、下载、备份、前端请求层 | 未做渗透与依赖 CVE 扫描 |
| Stability | High | 调度、重连、备份、异常处理、轮询、资源关闭 | 未做故障注入 |
| Performance | Medium | 线程池、sleep、全表查询、轮询、定时器、AI 调用 | 未做 profiler/压测/Mongo explain |
| Testing | High | 全仓测试清单、package scripts、GitHub workflow | 未执行测试 |
| Maintainability | Medium | 文件规模、重复模式、职责分布、文档 | 未做完整复杂度统计 |
| Design | Medium | SRP、fail-fast、状态所有权、边界契约、CQS | 静态判断为主 |
| Release | High | Dockerfile、workflow、README、install.sh、版本源 | 未实际拉取/运行镜像 |
| Documentation | High | README、技术参考、迁移需求与计划 | generated 索引未逐页复核 |
| Configuration | High | application.yaml、环境变量、默认值、版本 | 未验证生产环境覆盖值 |
| Observability | Medium | 日志内容、级别、错误反馈、健康信号 | 未接入实际日志平台 |
| Data-Integrity | Medium | 备份恢复、跨集合删除、进度状态 | 未验证 Mongo 事务拓扑 |
| Privacy | High | Cookie/token/聊天/卡密/key 的日志、备份和前端暴露 | 未做数据保留制度访谈 |
| Accessibility | Medium | 主要模板、弹窗、按钮、表单、响应式 CSS、截图 | 未运行 axe/读屏/键盘实测 |
| Supply-Chain | High | Actions、基础镜像、镜像源、安装脚本、lockfile | 未联网验证签名/CVE |
| Cost | Medium | AI 日志/调用、轮询、线程、外部请求频率 | 无生产账单与用量数据 |
| AI-Safety | Medium | AIService、动态配置、RAG、prompt 日志与预算 | 未执行 prompt injection/eval |
| Fallback | High | 空 catch、更新检查、错误转空态、备份吞错 | 未触发真实故障 |
| Testing-Authenticity | High | 测试文件、Surefire、前端脚本、workflow | 无测试可执行 |
| Type-Safety | Medium | TS 请求边界、`any`、动态 Map 备份导入 | 未运行 vue-tsc |
| Frontend-State | High | 核心 composable、轮询、布局、对话框、请求竞态 | 未运行浏览器 |
| Backend-API | Medium | 认证、返回码、参数处理、备份/日志/消息接口 | 未生成 OpenAPI/契约测试 |
| Dependency-Weight | Medium | pom/package、Playwright、Spring AI、重复 npm 依赖 | 未做依赖树/体积分析 |
| Code-Consistency | Medium | 错误处理、日志、弹窗、分页、响应式模式 | 未运行 lint |
| Comment-Coverage | Medium | 配置注释、关键类注释、过期技术文档 | 未统计全部公共 API 文档率 |

## 3. Top Risks

1. **Critical — 敏感凭证与聊天内容进入 INFO 日志：** 日志访问权等价于闲鱼会话与用户隐私访问权。
2. **High — 定时任务串行执行全账号网络/Playwright/sleep：** 慢账号会拖住其它保活、刷新和业务调度。
3. **High — API 发货扫描与执行耦合：** 单轮可持续数分钟，且多实例没有持久化 claim。
4. **High — 每账号独占 10 线程并混用裸线程：** 账号/订单增长时线程和无界队列线性膨胀。
5. **High — 响应式断点重建 RouterView：** 用户缩放窗口即可丢失未保存表单、弹窗和滚动状态。
6. **High — 消息历史被 1 秒轮询覆盖：** 客服无法稳定阅读历史，页面会强制跳到底部。
7. **High — 备份导入吞错却报告模块成功：** 恢复后的数据可能残缺，但用户被告知成功。
8. **High — Docker 用旧 static 覆盖新构建：** 发布镜像可能回退 UI 或引用不匹配资源。
9. **High — CI 零测试仍绿色：** 认证、Mongo、备份、WebSocket 和前端契约没有回归门禁。
10. **High — 首次注册可被公网抢占：** 新部署存在唯一管理员被先注册的窗口。

## 4. Detailed Findings

### Finding: F01 — INFO 日志泄露 accessToken、Cookie 请求头与完整聊天内容

- Severity: Critical
- Confidence: High
- Category: Security
- Status: Confirmed
- Affected area: WebSocket 注册、消息收发、日志与隐私边界
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/websocket/WebSocketInitializer.java:59-81`; `src/main/java/com/feijimiao/xianyuassistant/websocket/handler/SyncMessageHandler.java:112-123`; `src/main/java/com/feijimiao/xianyuassistant/service/impl/WebSocketServiceImpl.java:250-332,819-850`; `src/main/resources/application.yaml:63-64`
  - Function / Module: `sendRegistrationMessage`、`handle`、`connectWebSocket`、`sendMessage*`
  - Relevant behavior: 注册 JSON 含 token 并整体写入 INFO；连接 headers 含 Cookie 并整体记录；解密消息在配置判断前已无条件记录，发送文本也进入 INFO；原始消息开关默认开启。
- Problem: 日志同时成为凭证仓库和聊天副本，任何能读取容器日志、日志卷、下载包或运维平台的人都可能获得会话凭证和买卖双方内容。
- Why it matters: 这是直接的凭证与隐私泄露，不依赖复杂攻击链。
- Realistic failure scenario: 用户为排障分享日志压缩包，包内包含仍有效 token/Cookie 和聊天内容，第三方据此接管会话或识别买家信息。
- Minimal fix: 删除 payload/header/text 原文日志，仅保留 accountId、mid、长度、状态、耗时；统一日志脱敏过滤器；`print-raw-message` 默认 false。
- Better long-term fix: 建立敏感字段分类、结构化审计日志与受控调试采样，日志下载默认二次脱敏。
- Regression test suggestion: 在 workflow 用哨兵 token、Cookie、手机号和消息跑协议样本，断言所有 appender 输出都不含原文。
- Estimated effort: 2—4 小时

### Finding: F02 — 首次公开注册存在唯一管理员抢占窗口

- Severity: High
- Confidence: High
- Category: Security
- Status: Confirmed
- Affected area: 首次部署、注册与认证初始化
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/config/WebMvcConfig.java:27-30`; `src/main/java/com/feijimiao/xianyuassistant/controller/LoginController.java:23-79`; `src/main/java/com/feijimiao/xianyuassistant/service/impl/AuthServiceImpl.java:63-93`; `Dockerfile:55-62`
  - Function / Module: `/api/login/register`、`register`
  - Relevant behavior: `/api/login/**` 公开；空用户集合时任何请求都可创建首个账号，服务默认暴露端口。
- Problem: “数据库为空”被当成注册授权，没有部署者持有的一次性秘密或本机限制。
- Why it matters: 攻击者先注册后即可访问 Cookie、卡密、消息、备份等全部高敏数据。
- Realistic failure scenario: 新容器暴露公网后管理员尚未打开页面，扫描器先调用注册接口成为唯一管理员。
- Minimal fix: 使用一次性 bootstrap token、仅 loopback 初始化或显式 CLI 初始化；成功后永久关闭注册。
- Better long-term fix: 将安装初始化与运行期认证拆为两个明确状态，并在 readiness 中提示未初始化但不开放远程注册。
- Regression test suggestion: 空库无 bootstrap token 返回 403；正确 token 只允许成功一次，之后所有注册均拒绝。
- Estimated effort: 1 天

### Finding: F03 — Token/Cookie 保活把全账号网络、Playwright 与 sleep 串行放入定时任务

- Severity: High
- Confidence: High
- Category: Performance
- Status: Confirmed
- Affected area: TokenRefreshService、Spring Scheduler、账号连接稳定性
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/service/impl/TokenRefreshServiceImpl.java:400-466,486-544`
  - Function / Module: `scheduledCheckLoginStatus`、WebSocket token 定时检查
  - Relevant behavior: 每轮 `selectList(null)` 全量账号，逐账号同步检查/刷新，账号之间 sleep 5—15 秒，并可能进入 Playwright。
- Problem: 默认调度线程会被一个慢账号长期占用，任务周期随账号数线性增长并产生漂移。
- Why it matters: Cookie 过期、连接重连、邮件通知和其它定时业务可能一起延迟，用户看到多个账号同时离线或长时间“刷新中”。
- Realistic failure scenario: 50 个账号中一个外部请求卡 60 秒，其余账号至少再叠加 5N 秒间隔，下一轮在上一轮未完成时继续推迟。
- Minimal fix: 调度器只查询到期账号并提交到有界专用 executor；账号级互斥；调度体不得 sleep。
- Better long-term fix: 用持久化 nextRefreshAt/lease 驱动的任务队列，支持多实例、重试预算和可观测队列深度。
- Regression test suggestion: workflow 中模拟 50 账号且一个调用阻塞 60 秒，断言其它账号和其它 @Scheduled 仍在预算内执行。
- Estimated effort: 1—2 天

### Finding: F04 — API 自动发货把扫描、人工延迟与执行耦合在单个调度链

- Severity: High
- Confidence: High
- Category: Stability
- Status: Confirmed
- Affected area: 自动发货、订单幂等与调度延迟
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/service/ApiDeliveryScheduler.java:41-61,109-130`
  - Function / Module: 固定延迟扫描与发货执行
  - Relevant behavior: 每 25 秒串行遍历全部账号，发货前 sleep 20—30 秒、订单间 sleep 5—10 秒；`volatile running` 仅能防单 JVM 重入。
- Problem: 扫描频率只是配置表象，实际周期由账号和订单数量决定；多实例还可能重复领取同一订单。
- Why it matters: 发货延迟直接影响买家体验，重复发货会消耗卡密或发送多次消息。
- Realistic failure scenario: 10 个账号各 5 单时一轮持续数分钟，后续新订单无法及时发现；横向部署后两个实例同时发同一单。
- Minimal fix: 扫描与执行分离，使用有界 per-account worker；落库 claim/lease 和幂等键。
- Better long-term fix: 建立可恢复的订单状态机与对账任务，记录领取、发送、确认和补偿状态。
- Regression test suggestion: 多实例、10 账号各 5 单，断言无重复发货且扫描延迟有上界。
- Estimated effort: 2—4 天

### Finding: F05 — 每个 WebSocket 账号独占 10 线程，另有订单/二维码裸线程

- Severity: High
- Confidence: High
- Category: Performance
- Status: Confirmed
- Affected area: WebSocket、自动确认发货、二维码登录
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/websocket/XianyuWebSocketClient.java:35-50`; `src/main/java/com/feijimiao/xianyuassistant/service/impl/WebSocketServiceImpl.java:250-267`; `src/main/java/com/feijimiao/xianyuassistant/service/impl/AutoDeliveryServiceImpl.java:506-525`; `src/main/java/com/feijimiao/xianyuassistant/service/impl/QRLoginServiceImpl.java:324-327`
  - Function / Module: 客户端构造、自动确认、二维码轮询线程
  - Relevant behavior: 每账号 `newFixedThreadPool(10)`，固定池默认无界队列；自动确认和二维码流程直接 `new Thread(...).start()`。
- Problem: 并发模型按账号和订单线性创建线程，缺少全局容量、队列上限、公平性和拒绝策略。
- Why it matters: 100 账号即可接近 1000 线程，订单洪峰和二维码会话会进一步增加上下文切换、内存和 OOM 风险。
- Realistic failure scenario: 多账号消息突发同时触发自动处理，线程数与无界队列共同增长，页面 API 超时、心跳延迟并引发重连风暴。
- Minimal fix: 改为共享有界消息 executor；自动确认用 ScheduledExecutorService；二维码用共享调度器并限制并发会话。
- Better long-term fix: 按账号分区的有界事件循环，提供队列深度、拒绝数、处理延迟和背压策略。
- Regression test suggestion: 100 账号突发消息和 1000 次确认触发下，断言线程数/队列有固定上界并能观察拒绝。
- Estimated effort: 2—3 天

### Finding: F06 — 响应式断点切换会销毁并重建整页 RouterView

- Severity: High
- Confidence: High
- Category: Maintainability
- Status: Confirmed
- Affected area: AppLayout、所有含未保存状态的页面
- Evidence:
  - File: `vue-code/src/components/layout/AppLayout.vue:92-115,195-229`
  - Function / Module: `checkScreenSize` 与三套互斥 `<RouterView>`
  - Relevant behavior: resize 跨 768/1024 时切换三组 flag，桌面/平板/手机分别条件渲染独立 RouterView。
- Problem: 响应式布局通过重建业务组件树实现，而不是只改变外壳布局。
- Why it matters: 自动回复、设置、发货配置等未保存输入、弹窗、滚动和加载状态会瞬间丢失，并重复发请求。
- Realistic failure scenario: 用户编辑 AI key 或 5000 字知识资料时调整窗口/旋转平板，表单恢复初始值且没有离开确认。
- Minimal fix: 只保留一个 RouterView 和主内容树，使用 CSS media query 改布局；仅抽屉条件渲染。
- Better long-term fix: 将响应式能力集中为布局 primitive，业务页面不感知 desktop/tablet/mobile 三套实例。
- Regression test suggestion: 打开商品详情并输入未保存配置，跨两个断点后组件实例、输入、弹窗和滚动均保持。
- Estimated effort: 4—8 小时

### Finding: F07 — 消息历史会被 1 秒轮询覆盖并强制滚到底

- Severity: High
- Confidence: High
- Category: Stability
- Status: Confirmed
- Affected area: 客服消息上下文弹窗
- Evidence:
  - File: `vue-code/src/views/messages/components/ContextDialog.vue:69-98,134-170`
  - Function / Module: 加载更多、上下文轮询、`scrollToBottom`
  - Relevant behavior: 加载历史后，轮询仍请求 offset=0；发现差异即用最新列表整体替换并滚到底部。
- Problem: 历史分页与实时消息没有合并规则，轮询拥有破坏性写权限。
- Why it matters: 客服无法稳定核对争议记录，人工回复可能基于错误上下文。
- Realistic failure scenario: 用户向上加载 40 条历史，新消息到达后旧记录消失，视口跳到底，用户误把另一段对话当作当前上下文。
- Minimal fix: 轮询只按消息 ID 增量合并；保留历史；仅当用户接近底部时自动滚动，并提供“有新消息”按钮。
- Better long-term fix: 使用游标/事件流统一历史与实时消息，明确去重、排序和读取位置。
- Regression test suggestion: 加载 40+ 条后注入新消息，历史仍存在；阅读旧消息时视口不跳动。
- Estimated effort: 4—6 小时

### Finding: F08 — 备份导入逐条吞错却把模块计为成功

- Severity: High
- Confidence: High
- Category: Stability
- Status: Confirmed
- Affected area: 备份恢复、跨模块引用与数据完整性
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/service/impl/DataBackupServiceImpl.java:101-127`; `src/main/java/com/feijimiao/xianyuassistant/backup/handler/AccountBackupHandler.java:80-149`
  - Function / Module: `importData` 与各领域 handler
  - Relevant behavior: handler 内单条异常 catch 后继续且不抛出；上层只要 handler 返回就 `successCount++`。
- Problem: 返回结果把“部分导入”伪装为“模块成功”，也没有原子应用或完整失败明细。
- Why it matters: 自动发货、回复、Cookie 和商品配置可能引用缺失记录，用户却认为灾备恢复完成。
- Realistic failure scenario: 一条 Cookie 类型错误被吞掉，账号模块仍显示成功；恢复后连接失败且用户删除原备份。
- Minimal fix: handler 返回成功/失败/跳过明细；任一必需记录失败则模块失败；先做 schema/引用预校验。
- Better long-term fix: staging 导入、事务或可重入补偿流程，并提供恢复后对账报告。
- Regression test suggestion: 备份中注入一条坏账号/Cookie，断言模块失败、计数准确、数据库不出现未声明的半恢复。
- Estimated effort: 1—2 天

### Finding: F09 — Docker 构建可能用仓库旧 static 覆盖刚构建的前端

- Severity: High
- Confidence: High
- Category: Release
- Status: Confirmed
- Affected area: Docker 多阶段构建与前端制品
- Evidence:
  - File: `vue-code/vite.config.ts:29-34`; `Dockerfile:32-39`
  - Function / Module: frontend-build → backend-build 复制顺序
  - Relevant behavior: 先复制新构建产物到 `src/main/resources/static`，随后 `COPY src/ src/` 覆盖同路径中的 index 和同名资源。
- Problem: 最终 JAR 的前端来源取决于复制覆盖顺序，而不是当前 Vue 源码的唯一构建结果。
- Why it matters: 镜像可发布旧 UI、错误 hash 或与后端接口不匹配的页面。
- Realistic failure scenario: Vue 源码修复了关键交互，但 committed static 未更新，镜像仍显示旧页面或白屏。
- Minimal fix: 先 COPY `src/`，再用 frontend-build 产物覆盖 static；或不提交生成 static 并从单一制品目录打包。
- Better long-term fix: workflow 对镜像内 index/assets 做来源标识与孤儿资源校验。
- Regression test suggestion: 在 workflow 注入构建标识，检查镜像内 index 只包含当前标识且引用的资源均存在。
- Estimated effort: 2—4 小时

### Finding: F10 — CI 在零测试、前端跳过类型检查时仍可绿色发布

- Severity: High
- Confidence: High
- Category: Testing
- Status: Confirmed
- Affected area: GitHub Actions、Maven、Vue 生产构建
- Evidence:
  - File: `.github/workflows/build.yml:27-55`; `vue-code/package.json:11-16`; `Dockerfile:13-17`; `src/test`（不存在）
  - Function / Module: `backend-verify`、`build:spring`
  - Relevant behavior: `mvn test` 在零测试下成功；Docker 调用仅 `vite build` 的 `build:spring`，不运行 vue-tsc、lint 或任何前端测试。
- Problem: 绿色 CI 只证明命令退出 0，不能证明认证、Mongo、备份、WebSocket 或 UI 契约正确。
- Why it matters: 与用户最相关的高风险链路没有回归保护，发布速度越快，错误进入生产越快。
- Realistic failure scenario: DTO 字段改名、备份 mapper 破坏或前端访问不存在属性，workflow 仍发布镜像，用户点击后才发现。
- Minimal fix: 后端加入 context+真实 Mongo、认证生命周期、备份恢复集成测试；前端独立 type-check、只检查 lint、组件/请求竞态测试；零测试时失败。
- Better long-term fix: 建立关键旅程契约测试与镜像 smoke test，发布 job 只消费已验证制品。
- Regression test suggestion: 故意破坏 mapper 和 TS 属性访问，两个 workflow job 都必须失败。
- Estimated effort: 2—5 天

### Finding: F11 — 登录与首次注册失败对用户完全静默

- Severity: High
- Confidence: High
- Category: Maintainability
- Status: Confirmed
- Affected area: 登录/注册首屏用户旅程
- Evidence:
  - File: `vue-code/src/views/login/index.vue:40-83,108-210`
  - Function / Module: `handleLogin`、`handleRegister`
  - Relevant behavior: 空值、长度和密码不一致直接 return；非成功响应与 catch 仅 console.error；模板没有错误区域。
- Problem: 用户无法知道是字段错误、密码错误、网络失败还是服务未就绪。
- Why it matters: 这是产品的第一入口；静默失败会被理解为按钮失效或系统坏掉。
- Realistic failure scenario: 密码错误后按钮恢复原状，用户连续点击、刷新、重装，仍得不到可执行提示。
- Minimal fix: 字段级 error ref、表单级 `aria-live`，展示服务端 msg，首个错误自动聚焦。
- Better long-term fix: 统一表单校验和 API 错误模型，保留请求 ID 供排障。
- Regression test suggestion: 空账号、短密码、不一致、401、断网均显示明确错误且不会重复提交。
- Estimated effort: 3—5 小时

### Finding: F12 — 固定 JWT secret 与 30 天有效期放大令牌泄露影响

- Severity: Medium
- Confidence: High
- Category: Security
- Status: Confirmed
- Affected area: JWT 配置与会话生命周期
- Evidence:
  - File: `src/main/resources/application.yaml:15-18`; `src/main/java/com/feijimiao/xianyuassistant/service/impl/AuthServiceImpl.java:119-141,231-243`
  - Function / Module: JWT 默认配置、登录、修改密码
  - Relevant behavior: 仓库内有固定默认 secret（报告已脱敏为 `<redacted>`），token 默认 30 天；改密未见撤销全部旧 token。
- Problem: 默认部署共享同一签名秘密，且凭证泄露后窗口很长；虽然 DB token 白名单降低伪造风险，但不能消除已泄露 token 的持续有效性。
- Why it matters: 日志已经存在 token 泄露路径，改密码也不能可靠止损。
- Realistic failure scenario: 用户发现异常后改密码，攻击者继续使用旧 token 下载备份和查看凭证。
- Minimal fix: 启动时强制从 secret store/环境变量提供高熵 secret；改密时撤销该用户全部 token/cache；缩短有效期并支持刷新。
- Better long-term fix: 轮换 key id、短期 access token、服务端会话与设备管理页。
- Regression test suggestion: 缺少 secret 时生产配置启动失败；改密后旧 token 访问受保护接口必须 401。
- Estimated effort: 4—8 小时

### Finding: F13 — 备份/设置/浏览器控制台形成第二条敏感数据外泄链

- Severity: Medium
- Confidence: High
- Category: Security
- Status: Confirmed
- Affected area: 备份、系统设置、Axios 拦截器、浏览器调试
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/backup/handler/AccountBackupHandler.java:50-67`; `src/main/java/com/feijimiao/xianyuassistant/backup/handler/SystemSettingBackupHandler.java:17-47`; `vue-code/src/utils/request.ts:45-65`
  - Function / Module: 备份导出、设置读取、全局请求/响应日志
  - Relevant behavior: 备份包含 Cookie/token、AI key、SMTP 密码；前端把请求 data 与完整响应 data 打到 console。
- Problem: 敏感数据在正常功能和调试路径中被默认复制，缺少加密、遮罩和生产日志开关。
- Why it matters: 浏览器插件、远程协助、截图和普通备份文件都可能扩大泄露面。
- Realistic failure scenario: 用户向他人发送备份或开远程调试，对方直接看到仍有效凭证和卡密。
- Minimal fix: 设置接口只返回 masked/hasValue；生产移除 body console；含敏感模块的备份要求用户口令加密并明确告警。
- Better long-term fix: 细分可导出数据等级、密钥封装和最小权限备份。
- Regression test suggestion: 哨兵 secret 不得出现在设置响应、console 或未加密备份中；加密备份无口令不可读。
- Estimated effort: 1—2 天

### Finding: F14 — Toast 使用 innerHTML 拼接服务端消息，形成 DOM XSS 注入点

- Severity: Medium
- Confidence: High
- Category: Security
- Status: Confirmed
- Affected area: 全局错误提示
- Evidence:
  - File: `vue-code/src/utils/toast.ts:27-45`; `vue-code/src/utils/request.ts:84-100`
  - Function / Module: `show`、Axios 响应拦截器
  - Relevant behavior: `${message}` 直接进入 `el.innerHTML`；message 经常来自后端 `res.msg` 或错误对象。
- Problem: 任何可影响错误消息的外部内容都可能被浏览器当 HTML 解析。
- Why it matters: 前端 token 存在 localStorage，XSS 可直接读取并发送出去。
- Realistic failure scenario: 上游错误文本包含恶意标签并被后端透传，toast 渲染后执行事件处理器，窃取登录 token。
- Minimal fix: 图标可使用可信模板，但消息必须通过 `textContent` 单独插入。
- Better long-term fix: 建立禁止业务字符串进入 innerHTML 的 lint 规则与 CSP。
- Regression test suggestion: toast 输入 `<img src=x onerror=...>` 时只显示文本，DOM 不产生 img 且脚本不执行。
- Estimated effort: 30—60 分钟

### Finding: F15 — 列表请求缺少取消/序号保护，旧响应可覆盖新筛选状态

- Severity: Medium
- Confidence: High
- Category: Stability
- Status: Confirmed
- Affected area: 消息、商品、订单列表
- Evidence:
  - File: `vue-code/src/views/messages/useMessageManager.ts:113-164,218-259`; `vue-code/src/views/goods/useGoodsManager.ts:113-140,171-186`; `vue-code/src/views/orders/useOrderManager.ts:56-98,122-145`
  - Function / Module: 账号切换、筛选、分页加载
  - Relevant behavior: 请求完成后无条件写回列表，没有 AbortController 或 requestId 校验。
- Problem: UI 显示的筛选条件和列表数据可能来自不同请求时刻。
- Why it matters: 用户可能对错误账号的商品、消息或订单执行删除、同步、发货等操作。
- Realistic failure scenario: 慢网下先请求 A 账号再切 B，A 最后返回，标题是 B 但内容是 A。
- Minimal fix: 每类请求使用递增 requestId 或 AbortController，只提交最后一次响应；操作请求携带明确实体/账号校验。
- Better long-term fix: 使用统一 query state 层管理 key、缓存、取消、失效和 stale 状态。
- Regression test suggestion: 延迟 A 响应并快速切 B，最终只显示 B，A 的响应不得改变列表。
- Estimated effort: 0.5—1 天

### Finding: F16 — 错误态被清空成“暂无数据”，失败与真空不可区分

- Severity: Medium
- Confidence: High
- Category: Stability
- Status: Confirmed
- Affected area: 消息上下文、商品、订单等列表空态
- Evidence:
  - File: `vue-code/src/views/messages/useMessageManager.ts:155-159`; `vue-code/src/views/messages/components/ContextDialog.vue:99-103,329-332`; `vue-code/src/views/goods/useGoodsManager.ts:134-136`; `vue-code/src/views/orders/useOrderManager.ts:92-95`
  - Function / Module: 列表 catch 与空态模板
  - Relevant behavior: 请求失败后清空数据，对应模板只显示“暂无”而非错误与重试。
- Problem: 防御性兜底隐藏真实失败，并销毁最后一次成功数据。
- Why it matters: 用户可能误判没有消息、商品或订单，错过人工介入和发货。
- Realistic failure scenario: 短暂断网后消息列表变空，用户以为没有待处理咨询并离开页面。
- Minimal fix: 独立 error state；保留最后成功数据；显示错误横幅、重试和数据时间。
- Better long-term fix: 统一 idle/loading/success/empty/error/stale 六态组件。
- Regression test suggestion: 先成功后失败时保留旧数据并显示错误；首次失败显示重试而非空态。
- Estimated effort: 4—8 小时

### Finding: F17 — 弹窗、图标按钮和表单缺少基础键盘/读屏契约

- Severity: Medium
- Confidence: High
- Category: Testing
- Status: Confirmed
- Affected area: 消息、卡密、上传、登录、布局抽屉及多数业务弹窗
- Evidence:
  - File: `vue-code/src/views/messages/components/ContextDialog.vue:265-370`; `vue-code/src/views/kami-config/index.vue:636-770`; `vue-code/src/components/MultiImageUploader.vue:110-127`; `vue-code/src/views/login/index.vue:112-203`; `vue-code/src/components/layout/AppLayout.vue:142-185`
  - Function / Module: dialog、上传控件、密码可见按钮、菜单/关闭按钮
  - Relevant behavior: 无 `role=dialog`/`aria-modal`/焦点圈定/Escape；可点击 div 和纯图标按钮无名称；label 无 for；显示密码按钮 `tabindex=-1`。
- Problem: 视觉上可操作的界面没有等价的键盘与辅助技术行为。
- Why it matters: 键盘用户可能无法上传、关闭或识别按钮；弹窗打开后焦点仍能落到被遮挡背景。
- Realistic failure scenario: 用户打开卡密弹窗后按 Tab 操作到背景危险按钮，读屏也无法确认当前弹窗标题。
- Minimal fix: 抽公共 Dialog primitive；改语义 button/label；补名称、焦点管理、Escape 与关闭后焦点恢复。
- Better long-term fix: workflow 加 axe 与键盘旅程测试，设计系统提供可访问组件而非页面自制。
- Regression test suggestion: Tab 不离开弹窗、Esc 关闭并回到触发器；按 role/name 可定位上传、发送、关闭与显示密码按钮。
- Estimated effort: 1—2 天

### Finding: F18 — 高频轮询可重叠且后台标签页持续请求

- Severity: Medium
- Confidence: High
- Category: Performance
- Status: Confirmed
- Affected area: Dashboard、消息页、上下文弹窗
- Evidence:
  - File: `vue-code/src/views/dashboard/index.vue:148-157,243-290`; `vue-code/src/views/messages/index.vue:134-157`; `vue-code/src/views/messages/components/ContextDialog.vue:134-170`
  - Function / Module: 3 秒/5 秒/1 秒定时刷新
  - Relevant behavior: `setInterval` 不等待前次完成、无 in-flight guard、无 `document.visibilityState` 暂停；上下文还每秒序列化比较列表。
- Problem: API 时延超过轮询周期时请求重叠，多个后台标签页会持续制造无价值负载和渲染抖动。
- Why it matters: 后端本身已有调度与线程压力，前端轮询会放大卡顿并让用户看到旧响应覆盖新状态。
- Realistic failure scenario: 网络请求耗时 6 秒，3 秒轮询形成并发；用户开三个标签页后请求量翻倍且页面频繁重绘。
- Minimal fix: 请求完成后递归 setTimeout；in-flight guard；隐藏页暂停；上下文按消息 ID 增量比较。
- Better long-term fix: 对实时状态使用 SSE/WebSocket 事件，普通统计采用缓存和自适应刷新。
- Regression test suggestion: 慢请求时并发始终为 1；页面 hidden 后停止请求，visible 后恢复一次而非补发积压。
- Estimated effort: 4—8 小时

### Finding: F19 — 同步进度缓存永久增长且跨线程字段没有可见性保证

- Severity: Medium
- Confidence: High
- Category: Performance
- Status: Confirmed
- Affected area: 商品详情同步进度
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/service/impl/ItemDetailSyncServiceImpl.java:44-77,141-143,238-286`
  - Function / Module: `progressMap`、`SyncProgress`、异步同步与 HTTP 查询
  - Relevant behavior: 完成只清 accountSyncMap，不清 progressMap；普通 int/boolean 由异步线程写、请求线程读，无 volatile/锁/不可变快照。
- Problem: 任务 ID 持续累积，读取线程还可能长期看到旧进度或未完成状态。
- Why it matters: 长期运行会缓慢占内存，用户轮询进度时可能卡在错误状态。
- Realistic failure scenario: 连续执行上万次同步后 map 不回落；同步已完成但页面仍显示进行中并持续轮询。
- Minimal fix: 完成后 TTL 清理且设置容量上限；进度用 Atomic/volatile 或 immutable snapshot。
- Better long-term fix: 将任务状态持久化为有生命周期的 job 记录，支持取消、失败原因和重启恢复。
- Regression test suggestion: 连续 1 万任务后缓存回落；并发轮询最终必然看到 completed。
- Estimated effort: 4—8 小时

### Finding: F20 — 发布文档、版本源和实际制品渠道已经漂移

- Severity: Medium
- Confidence: High
- Category: Release
- Status: Confirmed
- Affected area: README、技术参考、安装脚本、版本与迁移文档
- Evidence:
  - File: `README.md:110-215,321-322,388-391`; `docs/technical-reference/01-architecture-and-stack.md:16-61`; `docs/technical-reference/04-data-and-configuration.md:3-89`; `.github/workflows/build.yml:63-114`; `install.sh:128-188`; `pom.xml:13`; `src/main/resources/application.yaml:4-5`
  - Function / Module: Docker/JAR 安装、Mongo 迁移后文档、版本检查
  - Relevant behavior: workflow 只发 GHCR，README 仍引用其它镜像/JAR/SQLite；技术参考仍以 SQLite/MyBatis/本地向量文件为主；版本同时为 2.0.3 与 1.1.8。
- Problem: 用户按照官方文档执行会走向不存在、过期或错误的制品和存储模型。
- Why it matters: 安装、升级、备份与故障判断都会失真，发布修复也无法可靠到达用户。
- Realistic failure scenario: 用户按 README 拉旧镜像或寻找不存在的 release JAR；迁移后仍只备份 `/app/dbdata`，实际 Mongo 数据未保护。
- Minimal fix: 选择唯一发布渠道并同步 README/install；重生成技术参考；单一版本源生成 Maven、前端、API 与镜像标签。
- Better long-term fix: 文档命令 smoke test、版本一致性检查和 release artifact/checksum 自动发布。
- Regression test suggestion: workflow 匿名执行文档中的精确安装/拉取命令，并比对 API、manifest、前端版本与 tag。
- Estimated effort: 1—2 天

### Finding: F21 — AI 调用缺少明确预算，且 prompt 进入高基数日志

- Severity: Low
- Confidence: Medium
- Category: Performance
- Status: Suspected
- Affected area: AIService、RAG、日志与外部 API 成本
- Evidence:
  - File: `src/main/java/com/feijimiao/xianyuassistant/service/impl/AIServiceImpl.java:86-145`
  - Function / Module: prompt 记录、向量检索、模型调用
  - Relevant behavior: INFO 记录完整 prompt；向量搜索与模型调用未见应用层并发、token、超时和成本预算，底层客户端可能存在默认 timeout。
- Problem: 用户内容扩大日志与隐私成本，模型/embedding 悬挂或滥用时缺少明确的应用级上限。
- Why it matters: AI 功能会与消息处理共享资源，成本和延迟异常可拖慢核心自动回复。
- Realistic failure scenario: 超长 prompt 和并发咨询同时触发检索与模型调用，日志暴涨、请求占用线程，账单与延迟缺少告警。
- Minimal fix: 不记录原 prompt，只记长度/模型/耗时/usage；增加字符/token、并发、超时和每请求预算。
- Better long-term fix: AI bulkhead、租户/账号配额、usage 指标、prompt injection 与降级 eval。
- Regression test suggestion: 模型/向量服务悬挂时在预算内失败；100 并发不耗尽通用线程；日志不含哨兵 prompt。
- Estimated effort: 1—2 天

## 5. Architecture Concerns

- Coverage: Medium
- Inspected evidence: Controller/Service/Mapper、WebSocket/调度、Vue 布局/路由/composable。
- Exclusions / limits: 未生成运行时依赖图。

主要问题为状态和并发所有权不清：响应式布局拥有业务组件生命周期，单一调度方法同时拥有扫描与执行，每账号客户端自行创建线程池。正面项是回复策略、发货策略和备份 handler 已体现按领域拆分的方向。

## 6. Security Concerns

- Coverage: High
- Inspected evidence: F01、F02、F12—F14，认证、JWT、日志、备份、前端请求层。
- Exclusions / limits: 未做动态渗透与 CVE 扫描。

必须先修 F01；F02 是新部署窗口风险；F12—F14 会放大凭证泄露后的影响。密码使用 BCrypt、受保护接口默认经过 token+DB 白名单校验是现有亮点。

## 7. Stability Concerns

- Coverage: High
- Inspected evidence: F03、F04、F07、F08、F15、F16、重连与异常处理。
- Exclusions / limits: 未做网络/数据库故障注入。

系统大量采用“继续运行”的兜底，但缺少显式失败状态，最典型的是备份吞错、列表失败转空和更新检查假阴性。

## 8. Performance Concerns

- Coverage: Medium
- Inspected evidence: F03—F05、F18、F19、全表查询、线程与定时器搜索。
- Exclusions / limits: 未压测、profile 或执行 Mongo explain。

瓶颈是容量模型而非单条慢代码：账号数会同时放大全表扫描、sleep、线程数、心跳任务、token 任务和前端轮询。优先建立共享有界 executor、到期查询和请求背压。

## 9. Testing Gaps

- Coverage: High
- Inspected evidence: F10、测试目录、workflow、package scripts。
- Exclusions / limits: 按仓库约束未执行测试。

当前没有真实回归信心。最小测试组合应覆盖认证生命周期、Mongo mapper、备份坏数据、消息合并、响应式状态保持、请求竞态和镜像静态资源来源。

## 10. Maintainability Concerns

- Coverage: Medium
- Inspected evidence: 大文件、重复弹窗/错误/轮询模式、技术文档。
- Exclusions / limits: 未运行复杂度工具。

`settings/index.vue`、`auto-reply/useAutoReply.ts`、`ItemServiceImpl`、`WebSocketServiceImpl` 等文件承担多种变更原因。建议按面板/生命周期拆协作者，避免再新增超级文件。

## 11. Design / Principles Concerns

- Coverage: Medium
- Inspected evidence: F03—F08、F15—F19，状态所有权与失败语义。
- Exclusions / limits: 原则判断基于静态证据。

主要违反 SRP、fail-fast、最小惊讶和显式边界：布局不应重建业务状态，handler 不应吞错后报告成功，调度器不应直接承担长耗时执行。

## 12. Release Concerns

- Coverage: High
- Inspected evidence: F09、F10、F20、Docker、workflow、install、版本。
- Exclusions / limits: 未实际运行镜像。

Docker 静态资源覆盖和 Playwright 缺失应作为发布阻断项；文档渠道与版本漂移需要在下一稳定版前收敛。

## 13. Documentation Analysis

- Coverage: High
- Inspected evidence: README、技术参考、迁移文档、workflow。
- Exclusions / limits: generated 索引仅抽查。

Mongo 迁移已经进入代码，但大量文档仍描述 SQLite/MyBatis/本地向量文件，属于会导致错误备份和部署决策的过期文档，而非小瑕疵。

## 14. Configuration Safety Analysis

- Coverage: High
- Inspected evidence: application.yaml、环境变量、版本与默认开关。
- Exclusions / limits: 未检查实际生产环境覆盖。

固定 JWT secret、30 天 token、原始消息默认开启和分裂版本源均应改为启动校验的显式配置。

## 15. Observability / Operability Analysis

- Coverage: Medium
- Inspected evidence: 日志、错误提示、调度和线程池可观察性。
- Exclusions / limits: 未接入生产日志/指标系统。

当前日志很多，但高价值信号少且敏感原文过多。应转向队列深度、调度延迟、重连次数、发货状态机、AI usage、备份失败明细和 requestId。

## 16. Data Integrity Analysis

- Coverage: Medium
- Inspected evidence: F04、F08、跨集合操作、进度状态。
- Exclusions / limits: 未验证 replica set 与事务管理器。

备份恢复和自动发货最需要持久化幂等/对账；仅靠 JVM 内 `running`、catch 后继续和内存进度不足以支撑故障恢复。

## 17. Privacy / Data Governance Analysis

- Coverage: High
- Inspected evidence: F01、F13、日志、备份、设置、Cookie/token/聊天/卡密。
- Exclusions / limits: 未检查组织层面的保留与删除政策。

项目处理大量高敏数据，但默认复制到日志、备份和浏览器控制台。应明确哪些数据可查看、可导出、需加密、需脱敏以及保留多久。

## 18. Accessibility / UX Correctness Analysis

- Coverage: Medium
- Inspected evidence: F06、F07、F11、F15—F18，主要模板与截图。
- Exclusions / limits: 未运行 axe、读屏或真实移动浏览器。

视觉风格统一，但交互正确性不足：状态会丢、历史会跳、失败会消失、弹窗没有焦点契约。先修状态与反馈，再谈视觉细节。

## 19. Supply Chain / Reproducibility Analysis

- Coverage: High
- Inspected evidence: Actions、基础镜像、镜像源、install.sh、lockfile。
- Exclusions / limits: 未联网验证 digest、签名和 CVE。

Actions 与基础镜像使用可变大版本标签，安装脚本无 checksum/签名；建议 pin SHA/digest，生成 SBOM/provenance，并对 JAR 做 SHA256 校验。

## 20. Cost / Resource Economics Analysis

- Coverage: Medium
- Inspected evidence: F03—F05、F18、F21，线程、轮询和 AI 调用。
- Exclusions / limits: 无生产账单与流量数据。

主要成本来自无界线程/队列、重复轮询、Playwright 和 AI。增加容量上限和 usage 指标通常比微优化业务代码更有效。

## 21. AI / LLM Safety Analysis

- Coverage: Medium
- Inspected evidence: AIService、RAG、动态配置、prompt 日志。
- Exclusions / limits: 未做 prompt injection、越权检索或模型 eval。

已限制 RAG topK，但缺少明确 token/并发/超时预算和安全 eval；用户 prompt 不应记录原文。

## 22. Fallback / Defensive Code Analysis

- Coverage: High
- Inspected evidence: F08、F16、更新检查、空 catch、静默轮询错误。
- Exclusions / limits: 未触发实际故障。

应删除“失败后假装成功/空/最新版”的兜底。能继续工作的降级必须带可见状态、最后成功时间和告警。

## 23. Testing Authenticity Analysis

- Coverage: High
- Inspected evidence: 测试文件清单、Maven/npm scripts、workflow。
- Exclusions / limits: 无测试可评估质量。

当前绿色状态不代表测试信心，属于“零测试绿色”。真实信心为 None，优先补关键链路而非追求覆盖率百分比。

## 24. Type Safety Analysis

- Coverage: Medium
- Inspected evidence: TS API 边界、`any`、动态备份 Map、前端生产脚本。
- Exclusions / limits: 未运行 vue-tsc。

生产构建跳过 vue-tsc 是首要问题；备份动态 Map 的强制转换也需要 schema 校验，避免类型错误在半导入后才暴露。

## 25. Frontend State Analysis

- Coverage: High
- Inspected evidence: F06、F07、F15、F16、F18，核心 composable 与布局。
- Exclusions / limits: 未运行浏览器。

页面局部状态本身不是问题，问题是缺少请求版本、增量合并、错误态和稳定组件生命周期。无需先引入大型全局状态库。

## 26. Backend API Analysis

- Coverage: Medium
- Inspected evidence: 认证、备份、日志下载、WebSocket、消息与设置接口。
- Exclusions / limits: 未执行契约测试。

API 统一返回对象便于前端处理，但 HTTP 200 承载 401、错误文本透传和备份成功语义失真会削弱契约。建议逐步使用真实 HTTP 状态与结构化错误码。

## 27. Dependency Weight Analysis

- Coverage: Medium
- Inspected evidence: pom.xml、package.json、Playwright/Spring AI、静态资源体积抽查。
- Exclusions / limits: 未生成依赖树与镜像层分析。

Playwright 是最大的运行时重量与兼容风险，却未真正装入镜像；前端同时依赖 `npm-run-all` 与 `npm-run-all2`，可删除重复项。

## 28. Code Consistency Analysis

- Coverage: Medium
- Inspected evidence: 错误处理、弹窗、分页、轮询、日志模式。
- Exclusions / limits: 未运行 lint。

同类页面在错误态、对话框语义、请求取消和分页禁用上重复实现且行为不一致。应抽取小型 primitive，而不是继续复制页面级实现。

## 29. Comment Coverage Analysis

- Coverage: Medium
- Inspected evidence: 配置注释、关键类注释、README/技术参考。
- Exclusions / limits: 未统计全部公共 API 文档率。

代码注释数量不低，但“参考 Python”“默认 SQLite”等历史注释/文档容易掩盖当前 Mongo 与真实行为。应优先修正误导性注释，而非增加注释数量。

---

## 30. Principles Compliance

### Principles Violated

| Principle | Violations | Severity | Affected Areas |
|-----------|------------|----------|----------------|
| Single Responsibility（1.1） | 6+ | Medium | AppLayout、settings、auto-reply、WebSocketService、ItemService、调度器 |
| Fail-Fast（4.1） | 5+ | High | 备份吞错、错误转空、更新检查、静默登录、配置默认值 |
| Explicit State Ownership（架构边界） | 4+ | High | RouterView 生命周期、消息历史/实时合并、同步进度、任务 claim |
| Bounded Resources / KISS | 5+ | High | 每账号线程池、裸线程、无界队列、轮询、全表扫描 |
| DRY（2.1） | 4+ | Medium | 弹窗、错误态、分页、响应式判断 |
| Least Surprise | 5+ | High | 备份“成功”、CI“通过”、更新“最新版”、空态、Docker 制品 |

### Principles Respected

- 路由页面采用动态 import，避免一次加载全部页面。
- 回复与发货使用策略对象，备份使用领域 handler，已有局部解耦基础。
- 多数 OkHttp 客户端设置 connect/read/write timeout。
- AsyncConfig 使用有界队列并配置关闭等待。
- 密码使用 BCrypt，认证默认覆盖 `/api/**` 与 `/ai/**`，token 还有 DB 有效性检查。
- Mongo 实体已有部分唯一/查询索引，前端主要列表使用分页。

---

## 31. Recommended Fix Order

### Fix Immediately

| Finding | Action | Outcome |
|---------|--------|---------|
| F01 | 删除 token/Cookie/聊天原文日志并轮换可能暴露凭证 | 立即缩小接管与隐私泄露面 |
| F02 | 首次注册增加 bootstrap 授权 | 防止新部署管理员被抢占 |
| F12 | 外置 JWT secret，改密撤销旧 token | 建立可用止损机制 |

### Fix Before Stable Release

| Finding | Action | Outcome |
|---------|--------|---------|
| F03—F05 | 重构为到期查询、共享有界 executor、持久化 claim | 消除账号增长后的全局卡顿与重复发货 |
| F08 | 备份返回真实明细并增加原子/对账策略 | 恢复结果可信 |
| F09 | 修正 Docker 复制顺序并验证镜像制品 | 确保发布的是当前前端 |
| F10 | 加后端集成测试、前端 type-check/lint/test | 让绿色 CI 有实际含义 |
| F06、F07、F11 | 修复状态丢失、历史覆盖和静默登录 | 打通三条最痛用户旅程 |
| F20 | 统一发布渠道、版本和 Mongo 文档 | 用户能正确安装、升级和备份 |

### Schedule Later

| Finding | Action | Outcome |
|---------|--------|---------|
| F13—F18 | 敏感数据遮罩、请求竞态、错误态、a11y、轮询治理 | 提升界面可信度和可用性 |
| F19 | 任务状态 TTL/持久化 | 防止长期运行泄漏与假进度 |
| F21 | AI 预算、usage 与安全 eval | 控制延迟、成本与滥用 |

### Ignore for Now

- 先不进行整体视觉重写；现有视觉语言可以保留。
- 先不引入大型全局状态库；小型 query/dialog primitive 足够解决当前主要问题。
- 先不为所有文件补注释；优先删除过期和误导性注释。

## 32. Quick Wins

| Quick win | Effort | Value |
|-----------|--------|-------|
| Toast 消息改用 `textContent` | 30—60 分钟 | 关闭直接 XSS 注入点 |
| `print-raw-message` 默认 false，删除 token/header/text INFO | 2—4 小时 | 最大安全止血 |
| 上传 interval 在 finally/unmount 清理 | 30—60 分钟 | 消除失败后定时器泄漏 |
| 登录页增加字段错误与 API 错误区 | 3—5 小时 | 第一入口可用性显著提升 |
| Docker 先 COPY src 再覆盖 static | 1—2 小时 | 修复制品来源错误 |
| 前端增加 `type-check` workflow job | 2—4 小时 | 阻止明显契约错误发布 |
| 轮询增加 in-flight 和 hidden 暂停 | 2—4 小时 | 立即降低请求风暴 |
| 文档全局替换并复核 SQLite/MyBatis 遗留 | 3—6 小时 | 避免错误部署/备份 |

## 33. Long-term Refactor Plan

1. **运行时容量层：** 建立共享有界 executor、按账号分区、持久化任务 lease、重试预算和统一指标；风险是迁移期间重复执行，需用幂等测试和灰度开关保护。
2. **前端交互基础层：** 提供单一 RouterView、Dialog、QueryState、ErrorState、Pagination 和 Polling primitive；风险是视觉回归，需先为登录、消息、自动回复和发货配置建立组件测试。
3. **数据恢复层：** 备份 schema 版本、预校验、staging、原子/补偿、恢复对账；风险是旧备份兼容，需保留样本集做向后兼容测试。
4. **可信发布层：** 单一版本源、已验证前后端制品、Playwright smoke、SBOM/provenance、文档命令 smoke；风险是 workflow 时间增加，可通过缓存和并行 job 控制。
5. **安全与隐私层：** 敏感字段分类、集中脱敏、加密备份、短会话和设备撤销；风险是排障信息减少，应以 requestId、长度、状态和受控采样替代原文。
