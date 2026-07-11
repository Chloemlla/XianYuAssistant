# 前端、部署、运维与风险

## 前端路由

公开入口是 `/login`。根路径重定向到 `/dashboard`。

主要业务路由包括 dashboard、accounts、connection、connection/:id、goods、orders、messages、auto-delivery、pending-orders、kami-config、auto-reply、operation-log、settings 和 qrlogin。

路由守卫与 request 工具共同处理登录态。Token 与用户名由前端保存并注入请求头，遇到未授权响应时应清理状态并返回登录页。

## 页面组织

复杂页面采用 `index.vue + useXxx.ts + components/` 拆分。

账号、商品、消息、订单、连接、自动回复、自动发货和操作日志均有独立 composable 管理查询条件、分页、弹窗和异步状态。

连接页面组件较多，覆盖凭证录入、Cookie 更新、Token 更新、二维码更新、刷新和详情状态，说明凭证异常恢复是主要运营场景。

自动发货和自动回复页面承担大量配置逻辑，修改时应优先继续拆分组合式函数和小组件，避免形成超级文件。

## 请求层

`utils/request.ts` 创建 Axios 实例，baseURL 为 `/api`，统一注入认证信息并处理响应。

api 目录按后端领域拆分，与控制器路径基本一一对应。

AI 接口使用 fetch，因为后端路径为 `/ai` 而不是 `/api/ai`，聊天接口还需要消费 SSE 文本流。

备份日志下载也使用 fetch，以便处理文件响应和 Content-Disposition。

上传组件封装图片文件选择、预览和后端上传；消息上下文同时支持文本和图片发送。

## 状态与交互

大部分业务状态局部保存在 composable 的 ref/reactive 中，而不是 Pinia。这样降低全局耦合，但跨页面缓存和状态恢复能力有限。

列表页通常需要同时维护账号筛选、商品筛选、分页、加载态和错误提示。请求竞态时应避免旧响应覆盖新筛选结果。

商品同步通过 syncId 轮询；组件卸载时应停止定时器，避免后台继续请求。

连接状态也需要轮询或刷新；对话框关闭后应清理二维码轮询、倒计时和临时敏感数据。

## 构建与静态资源

前端 package 版本为 2.0.3，要求 Node `^20.19.0 || >=22.12.0`。

Vite 构建产物通常由后端静态资源或容器交付流程承载，具体输出路径应以 vite.config.ts 和 Dockerfile 为准。

Maven、前端 manifest、应用版本与 Docker 构建参数统一为 2.0.3，Java 目标版本为 21。CI 会拒绝版本漂移。

本次遵循仓库约束，未在本地运行任何构建或测试；实际构建验证应放入 GitHub workflow。

## 容器与安装

Dockerfile 负责组装运行镜像；install.sh 提供 Linux 环境安装辅助。

业务数据和向量文档位于 MongoDB，应用容器只挂载 `/app/logs`。数据库备份必须使用 MongoDB/Atlas 的备份能力。

服务端口 12400 需要由容器端口映射或反向代理暴露。

发布镜像基于与 Java Playwright 1.40.0 匹配的官方运行镜像，内置 Chromium 与系统库。当前 GHCR 制品明确支持 `linux/amd64`。

反向代理必须支持 Web/SSE 长响应，AI 聊天若被代理缓冲会失去流式效果。

## 运维观察点

- WebSocket 在线账号数、重连次数、心跳超时和 Token 刷新失败。
- Cookie 过期、滑块验证码和二维码登录失败。
- 自动回复成功率、延迟队列长度、重复拦截和 AI 降级次数。
- 自动发货成功率、确认发货失败、待发货积压和卡密库存。
- MongoDB 连接池、查询延迟、索引创建、备份成功率和恢复演练。
- AI 请求延迟、Atlas Vector Search 状态或配置热更新失败。
- 邮件通知发送失败和操作日志异步线程异常。

## 安全与隐私

认证密钥应外置；密码必须只保存强摘要；登录 Token 应具备过期、注销和服务端撤销能力。

Cookie、闲鱼 Token、AI Key、卡密和买家数据属于高敏感信息。备份下载与日志下载接口必须保持鉴权并限制路径参数。

图片 URL 转存接口应防范 SSRF，包括内网地址、重定向、超大响应、非图片内容和超时。

上传接口应限制 MIME、扩展名、文件大小、存储文件名和可执行内容。

SSE 与普通 API 都应避免把服务端异常堆栈或秘密写回浏览器。

前端本地存储令牌会受 XSS 影响；所有富文本、买家消息和远端商品内容在渲染时必须保持转义。

## 维护风险清单

- 发布版本统一为 2.0.3；修改版本时必须同时通过 release-contract workflow。
- JWT secret 与首次注册 bootstrap token 必须由部署环境提供。
- 原始消息日志默认关闭，凭证和聊天正文不得进入普通日志。
- WebSocketServiceImpl 体量和职责较大，连接、心跳、刷新、重连、发送、通知集中在同一实现中。
- 调度机制混用 Spring Scheduler 和显式线程池，需防止重复任务和关闭泄漏。
- 多副本共享 MongoDB 时仍需保证调度 lease、WebSocket 账号归属和发货 claim 的一致性。
- 远端闲鱼接口属于非稳定依赖，签名、字段、验证码和风控变化会直接影响核心能力。
- 备份恢复跨多个有关联模块，应持续验证旧版本备份兼容性。

## 推荐的 GitHub workflow 验证矩阵

后续 CI 可分别执行后端编译/测试、前端类型检查/构建、Docker 构建和文档链接/行数检查。

后端集成测试在 GitHub Actions 中连接 MongoDB 8.0 service，验证索引、认证生命周期、claim 和备份恢复。

涉及 WebSocket 和闲鱼 HTTP 的测试应优先使用协议样本或 mock server，避免 CI 依赖真实账号。

涉及 AI 的测试应 mock OpenAI 兼容接口，并覆盖 API Key 缺失时的降级路径。
