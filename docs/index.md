---
layout: home

hero:
  name: XianYuAssistant
  text: 全项目技术中心
  tagline: 从系统架构到每一个源码文件，一站式掌握闲鱼自动化助手的设计、数据、链路与维护边界。
  image:
    src: /brand-mark.svg
    alt: XianYuAssistant 技术中心
  actions:
    - theme: brand
      text: 开始阅读
      link: /technical-reference/
    - theme: alt
      text: 探索源码地图
      link: /technical-reference/generated/

features:
  - icon: 🧭
    title: 架构全景
    details: Spring Boot、Vue、SQLite、WebSocket 与 Spring AI 的组件关系和运行边界。
  - icon: ⚡
    title: 核心链路
    details: 账号接入、长连接、消息事件、自动回复、自动发货和备份恢复完整串联。
  - icon: 🧬
    title: 源码级索引
    details: 覆盖 306 个 Java 文件与 157 个前端文件，快速定位类型、方法、依赖和接口。
---

<div class="tech-home">
  <section class="tech-section">
    <p class="tech-eyebrow">Repository intelligence</p>
    <h2>一个可检索、可导航、可持续维护的技术知识面</h2>
    <p class="tech-lead">文档基于仓库源码、配置、SQL 与部署脚本静态调研，既提供适合快速上手的专题讲解，也保留逐文件级别的工程事实。</p>
    <div class="metric-grid">
      <div class="metric-card"><span class="metric-value">5,824</span><span class="metric-label">技术文档行数</span></div>
      <div class="metric-card"><span class="metric-value">306</span><span class="metric-label">Java 源文件</span></div>
      <div class="metric-card"><span class="metric-value">157</span><span class="metric-label">前端源文件</span></div>
      <div class="metric-card"><span class="metric-value">26</span><span class="metric-label">分章节文档</span></div>
    </div>
  </section>

  <section class="tech-section">
    <p class="tech-eyebrow">System flow</p>
    <h2>从管理端操作到闲鱼实时业务</h2>
    <p class="tech-lead">系统不是单纯的 CRUD 后台，而是同时承载登录态、长连接、异步事件、自动决策和本地持久化的有状态自动化服务。</p>
    <div class="architecture-flow">
      <div class="flow-node"><span class="flow-index">01 / UI</span><strong>Vue 管理端</strong><span>配置、监控、人工补偿与数据查看</span></div>
      <div class="flow-node"><span class="flow-index">02 / API</span><strong>Spring MVC</strong><span>认证、DTO 边界与统一异常响应</span></div>
      <div class="flow-node"><span class="flow-index">03 / DOMAIN</span><strong>策略与事件</strong><span>回复、发货、延迟和人工接管编排</span></div>
      <div class="flow-node"><span class="flow-index">04 / STATE</span><strong>SQLite + Vector</strong><span>业务数据、配置、记录与本地知识库</span></div>
      <div class="flow-node"><span class="flow-index">05 / REMOTE</span><strong>闲鱼 + AI</strong><span>HTTP、WebSocket、二维码与模型接口</span></div>
    </div>
  </section>

  <section class="tech-section">
    <p class="tech-eyebrow">Knowledge map</p>
    <h2>按你正在解决的问题进入</h2>
    <div class="topic-grid">
      <a class="topic-card" href="/technical-reference/01-architecture-and-stack"><span class="topic-icon">◈</span><strong>理解整体架构</strong><p>技术选型、代码规模、组件边界与关键设计模式。</p></a>
      <a class="topic-card" href="/technical-reference/02-backend-and-api"><span class="topic-icon">⌘</span><strong>查找后端接口</strong><p>控制器域、服务分工、DTO、异常与持久化层。</p></a>
      <a class="topic-card" href="/technical-reference/03-core-workflows"><span class="topic-icon">↯</span><strong>追踪业务链路</strong><p>WebSocket、消息事件、自动回复、发货和商品同步。</p></a>
      <a class="topic-card" href="/technical-reference/04-data-and-configuration"><span class="topic-icon">◫</span><strong>掌握数据模型</strong><p>18 个业务表、唯一约束、配置项和数据演进风险。</p></a>
      <a class="topic-card" href="/technical-reference/05-frontend-deployment-and-risks"><span class="topic-icon">△</span><strong>部署与排查</strong><p>前端组织、容器、运维观察点和安全风险清单。</p></a>
      <a class="topic-card" href="/technical-reference/generated/"><span class="topic-icon">⌕</span><strong>定位具体文件</strong><p>按 Java、Vue、TypeScript、配置和资源逐文件检索。</p></a>
    </div>
  </section>

  <div class="home-note">
    <div><strong>文档与业务应用相互隔离</strong><p>VitePress 使用独立依赖和部署入口，不影响现有 Vue 管理端与 Spring Boot 构建。</p></div>
    <a class="VPButton medium brand" href="/technical-reference/">进入技术参考 →</a>
  </div>
</div>
