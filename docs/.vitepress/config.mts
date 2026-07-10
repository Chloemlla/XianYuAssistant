import { defineConfig } from 'vitepress'

const javaIndex = Array.from({ length: 12 }, (_, index) => ({
  text: `Java 源码索引 ${String(index + 1).padStart(2, '0')}`,
  link: `/technical-reference/generated/01-java-source-index-${String(index + 1).padStart(2, '0')}`,
}))

const frontendIndex = Array.from({ length: 5 }, (_, index) => ({
  text: `前端源码索引 ${String(index + 1).padStart(2, '0')}`,
  link: `/technical-reference/generated/02-frontend-source-index-${String(index + 1).padStart(2, '0')}`,
}))

const resourceIndex = Array.from({ length: 2 }, (_, index) => ({
  text: `资源工程索引 ${String(index + 1).padStart(2, '0')}`,
  link: `/technical-reference/generated/03-resource-index-${String(index + 1).padStart(2, '0')}`,
}))

const productionHost = process.env.VERCEL_PROJECT_PRODUCTION_URL
const siteUrl = productionHost ? `https://${productionHost}` : 'https://xianyu-assistant.vercel.app'

export default defineConfig({
  lang: 'zh-CN',
  title: 'XianYuAssistant 技术中心',
  description: 'XianYuAssistant 全项目架构、业务链路、数据模型与逐文件技术参考',
  cleanUrls: true,
  lastUpdated: true,
  sitemap: { hostname: siteUrl },
  head: [
    ['link', { rel: 'icon', type: 'image/svg+xml', href: '/brand-mark.svg' }],
    ['meta', { name: 'theme-color', content: '#635bff' }],
    ['meta', { property: 'og:type', content: 'website' }],
    ['meta', { property: 'og:title', content: 'XianYuAssistant 技术中心' }],
    ['meta', { property: 'og:description', content: '从架构总览到 463 个源码文件的完整技术地图' }],
  ],
  markdown: {
    lineNumbers: true,
    theme: { light: 'github-light', dark: 'github-dark' },
  },
  themeConfig: {
    logo: '/brand-mark.svg',
    siteTitle: 'XianYuAssistant',
    nav: [
      { text: '首页', link: '/' },
      { text: '技术总览', link: '/technical-reference/' },
      {
        text: '核心专题',
        items: [
          { text: '系统架构', link: '/technical-reference/01-architecture-and-stack' },
          { text: '后端与 API', link: '/technical-reference/02-backend-and-api' },
          { text: '核心业务链路', link: '/technical-reference/03-core-workflows' },
          { text: '数据与配置', link: '/technical-reference/04-data-and-configuration' },
          { text: '前端部署与风险', link: '/technical-reference/05-frontend-deployment-and-risks' },
        ],
      },
      { text: '逐文件索引', link: '/technical-reference/generated/' },
    ],
    sidebar: {
      '/technical-reference/': [
        {
          text: '技术参考',
          items: [
            { text: '阅读入口', link: '/technical-reference/' },
            { text: '系统架构与技术栈', link: '/technical-reference/01-architecture-and-stack' },
            { text: '后端分层与 HTTP API', link: '/technical-reference/02-backend-and-api' },
            { text: '核心业务链路', link: '/technical-reference/03-core-workflows' },
            { text: '数据模型与配置', link: '/technical-reference/04-data-and-configuration' },
            { text: '前端、部署与风险', link: '/technical-reference/05-frontend-deployment-and-risks' },
          ],
        },
        { text: 'Java 源码地图', collapsed: true, items: javaIndex },
        { text: '前端源码地图', collapsed: true, items: frontendIndex },
        { text: '配置与资源地图', collapsed: true, items: resourceIndex },
      ],
    },
    outline: { level: [2, 3], label: '本页目录' },
    docFooter: { prev: '上一篇', next: '下一篇' },
    lastUpdated: { text: '最后更新于', formatOptions: { dateStyle: 'medium', timeStyle: 'short' } },
    returnToTopLabel: '返回顶部',
    sidebarMenuLabel: '文档导航',
    darkModeSwitchLabel: '外观',
    lightModeSwitchTitle: '切换至浅色模式',
    darkModeSwitchTitle: '切换至深色模式',
    search: {
      provider: 'local',
      options: {
        translations: {
          button: { buttonText: '搜索技术文档', buttonAriaLabel: '搜索技术文档' },
          modal: {
            noResultsText: '没有找到相关内容',
            resetButtonTitle: '清除查询',
            footer: { selectText: '选择', navigateText: '切换', closeText: '关闭' },
          },
        },
      },
    },
    socialLinks: [
      { icon: 'github', link: 'https://github.com/Chloemlla/XianYuAssistant' },
    ],
    editLink: {
      pattern: 'https://github.com/Chloemlla/XianYuAssistant/edit/main/docs/:path',
      text: '在 GitHub 上改进此页',
    },
    footer: {
      message: '为维护者构建的 XianYuAssistant 全项目技术地图',
      copyright: '基于仓库源码静态调研生成',
    },
  },
})
