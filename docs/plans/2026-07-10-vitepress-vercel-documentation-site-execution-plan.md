# VitePress 技术文档站执行计划

## 内部等级

L。站点、主题、首页、部署和 CI 相互关联，采用单通道分阶段实现以保持视觉与配置口径一致。

## 阶段

1. 查询 npm registry，确认 VitePress 最新稳定版。
2. 创建独立文档包及 VitePress 配置。
3. 配置技术调研导航、分组侧栏、本地搜索和站点元数据。
4. 创建品牌主页、SVG 标识、主题入口和响应式样式。
5. 添加 Vercel 安装、构建、输出目录、区域、重写与缓存头配置。
6. 添加 GitHub Actions 文档构建 workflow。
7. 仅做 JSON、YAML、路径、链接和 Git 差异静态检查。
8. 提交并推送，实际构建由推送后的 GitHub workflow 执行。

## 可写边界

- `docs/.vitepress/`、`docs/public/`、`docs/index.md`。
- `docs/package.json`、`docs/package-lock.json`。
- 根目录 `vercel.json`。
- `.github/workflows/docs.yml`。
- 对应 requirements、plans 和 runtime 凭据。

## 核验与完成口径

本地只允许解析 JSON、读取 YAML、检查文件存在、Markdown 链接和 Git diff。不得用本地 VitePress build 作为完成证据；只有代码配置静态通过、提交推送成功且 GitHub workflow 已被配置后才可交付。

## 回滚与清理

所有站点文件均为新增文件，可按目录独立回滚。不得修改或删除现有技术调研正文。清理临时 npm 缓存与生成目录，不提交 `node_modules` 或 `.vitepress/cache`。
