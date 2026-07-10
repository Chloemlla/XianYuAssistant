# 技术文档生成器

`Generate-TechnicalReference.ps1` 只读取仓库源码并重建 `docs/technical-reference/generated/` 下的逐文件技术索引。

它不是构建或测试脚本，不调用 Maven、Gradle、Flutter、npm 或 Vite。运行前会设置 UTF-8 输出编码。
