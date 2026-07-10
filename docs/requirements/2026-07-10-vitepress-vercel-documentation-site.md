# VitePress 技术文档站与 Vercel 部署需求

## 目标

使用当前最新稳定版 VitePress 1.6.4 包装既有全项目技术调研文档，提供经过品牌化和响应式美化的文档主页、导航、侧栏、搜索与阅读体验，并通过根目录 `vercel.json` 支持 Vercel 一键部署和加速构建。

## 交付物

- `docs/package.json` 与锁文件，形成和业务前端隔离的文档站依赖边界。
- `docs/.vitepress/` 下的站点配置、自定义主题和样式。
- `docs/index.md` 品牌化主页与 `docs/public/` 品牌资源。
- 根目录 `vercel.json`，包含框架、安装命令、构建命令、输出入口、区域和缓存响应头。
- GitHub workflow 内的 VitePress 构建验证，严格遵守本地禁止构建要求。

## 约束

- 不运行本地 VitePress、Vite、Vue、Maven、Flutter 或 Gradle 构建与测试。
- 不改动技术调研正文事实，不把站点实现写进单个超级文件。
- 文档站依赖不得混入 `vue-code` 的业务前端依赖。
- 所有实际构建验证仅由 GitHub Actions 执行。
- 完成后使用非 GPG 签名提交并推送 `main`。

## 验收标准

- VitePress 版本固定为调研时 npm registry 最新稳定版 1.6.4。
- 主页具备 Hero、关键指标、架构链路、内容地图、能力入口和部署说明。
- 技术调研专题与 19 个自动生成章节均可从侧栏访问。
- 本地搜索、深色模式、目录大纲、更新时间、代码行号和 GitHub 链接已配置。
- `vercel.json` 为合法 JSON，包含 install/build/output 入口信息。
- 静态检查通过，且未在本地执行构建测试。
