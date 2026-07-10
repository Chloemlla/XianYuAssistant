param(
    [string]$RepositoryRoot = (Resolve-Path (Join-Path $PSScriptRoot '..\..')).Path
)

$ErrorActionPreference = 'Stop'
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
$OutputEncoding = [System.Text.Encoding]::UTF8

$outputRoot = Join-Path $RepositoryRoot 'docs\technical-reference\generated'
if (Test-Path $outputRoot) {
    $resolvedOutput = (Resolve-Path $outputRoot).Path
    $expectedOutput = Join-Path $RepositoryRoot 'docs\technical-reference\generated'
    if ($resolvedOutput -ne $expectedOutput) {
        throw "Refusing to clean unexpected path: $resolvedOutput"
    }
    Remove-Item -LiteralPath $resolvedOutput -Recurse -Force
}
New-Item -ItemType Directory -Path $outputRoot -Force | Out-Null

$utf8NoBom = [System.Text.UTF8Encoding]::new($false)
$generatedFiles = [System.Collections.Generic.List[string]]::new()

function Convert-ToRelativePath([string]$Path) {
    return [IO.Path]::GetRelativePath($RepositoryRoot, $Path).Replace('\', '/')
}

function Get-FirstMatch([string[]]$Lines, [string]$Pattern, [string]$Fallback = '未显式声明') {
    foreach ($line in $Lines) {
        if ($line -match $Pattern) { return $Matches[1].Trim() }
    }
    return $Fallback
}

function Get-UniqueMatches([string[]]$Lines, [string]$Pattern, [int]$Limit = 20) {
    $values = [System.Collections.Generic.List[string]]::new()
    foreach ($line in $Lines) {
        if ($line -match $Pattern) {
            $value = $Matches[1].Trim()
            if ($value -and -not $values.Contains($value)) { $values.Add($value) }
            if ($values.Count -ge $Limit) { break }
        }
    }
    return $values
}

function Get-Responsibility([string]$RelativePath, [string]$Name) {
    $map = [ordered]@{
        '/controller/dto/' = 'HTTP 接口的数据传输对象，定义请求或响应的序列化边界。'
        '/controller/' = 'Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。'
        '/service/impl/' = '业务服务实现层，编排持久化、远端调用、缓存或消息链路。'
        '/service/delivery/' = '自动发货策略与上下文，隔离不同交付模式。'
        '/service/reply/' = '自动回复策略链，处理关键词、RAG、延迟和兜底逻辑。'
        '/service/bo/' = '服务层业务对象，承载跨方法业务数据。'
        '/service/' = '业务服务契约或核心领域服务。'
        '/entity/' = 'MyBatis-Plus 持久化实体或领域上下文对象。'
        '/mapper/' = 'MyBatis-Plus 数据访问接口。'
        '/websocket/' = '闲鱼长连接、消息解析、连接状态或事件分发组件。'
        '/event/' = '领域事件及监听器，用于拆分消息到达后的并行业务处理。'
        '/backup/' = '数据导入导出及模块化备份处理器。'
        '/config/rag/' = 'AI 对话客户端和向量存储的动态配置。'
        '/config/' = 'Spring 容器、数据库、序列化、异步或 Web 基础设施配置。'
        '/utils/' = '远端协议、签名、Cookie、JSON、邮件等通用技术工具。'
        '/exception/' = '业务异常类型或全局异常转换。'
        '/interceptor/' = 'HTTP 请求拦截与身份上下文建立。'
    }
    foreach ($key in $map.Keys) {
        if ($RelativePath.Contains($key)) { return $map[$key] }
    }
    if ($Name.EndsWith('Application')) { return 'Spring Boot 应用启动入口。' }
    return '项目基础类型；具体职责由声明、注解和依赖共同确定。'
}

function Write-SplitDocument([string]$Prefix, [string]$Title, [System.Collections.Generic.List[string]]$Body, [int]$MaxBodyLines = 380) {
    $part = 1
    for ($offset = 0; $offset -lt $Body.Count; $offset += $MaxBodyLines) {
        $end = [Math]::Min($offset + $MaxBodyLines - 1, $Body.Count - 1)
        $chunk = if ($offset -eq $end) { @($Body[$offset]) } else { @($Body[$offset..$end]) }
        $name = '{0}-{1:d2}.md' -f $Prefix, $part
        $path = Join-Path $outputRoot $name
        $content = [System.Collections.Generic.List[string]]::new()
        $content.Add("# $Title（第 $part 部分）")
        $content.Add('')
        $content.Add('> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。')
        $content.Add('')
        foreach ($line in $chunk) { $content.Add($line) }
        [IO.File]::WriteAllLines($path, $content, $utf8NoBom)
        $generatedFiles.Add($name)
        $part++
    }
}

$javaBody = [System.Collections.Generic.List[string]]::new()
$javaFiles = Get-ChildItem (Join-Path $RepositoryRoot 'src\main\java') -Recurse -Filter '*.java' | Sort-Object FullName
foreach ($file in $javaFiles) {
    $lines = [IO.File]::ReadAllLines($file.FullName, [Text.Encoding]::UTF8)
    $relative = Convert-ToRelativePath $file.FullName
    $package = Get-FirstMatch $lines '^\s*package\s+([^;]+);'
    $declaration = Get-FirstMatch $lines '^\s*(?:public\s+)?(?:abstract\s+|final\s+)?(?:class|interface|enum|record)\s+([^\s\{]+)'
    $annotations = Get-UniqueMatches $lines '^\s*(@[A-Za-z0-9_$.]+(?:\([^)]*\))?)' 30
    $methods = Get-UniqueMatches $lines '^\s*(?:public|protected|private)\s+(?:static\s+)?(?:final\s+)?(?:<[^>]+>\s+)?[^=;]+?\s+([A-Za-z_$][A-Za-z0-9_$]*\s*\([^;]*\))\s*(?:throws\s+[^\{]+)?\{' 40
    $internalImports = Get-UniqueMatches $lines '^\s*import\s+(com\.feijimiao\.xianyuassistant\.[^;]+);' 25
    $externalImports = Get-UniqueMatches $lines '^\s*import\s+((?:org|com\.baomidou|com\.fasterxml|cn\.hutool|jakarta|okhttp3|lombok|reactor)\.[^;]+);' 15
    $mappings = Get-UniqueMatches $lines '^\s*@(RequestMapping|GetMapping|PostMapping|PutMapping|DeleteMapping|PatchMapping)(.*)$' 30
    $tables = Get-UniqueMatches $lines '(?:@TableName\(|\bFROM\s+|\bJOIN\s+|\bUPDATE\s+|\bINTO\s+)["'']?([a-zA-Z][a-zA-Z0-9_]+)' 20

    $javaBody.Add("## `$relative`")
    $javaBody.Add('')
    $javaBody.Add("- 主类型：`$declaration`")
    $javaBody.Add("- 包：`$package`")
    $javaBody.Add("- 规模：$($lines.Count) 行；文件大小 $($file.Length) 字节。")
    $javaBody.Add("- 职责判断：$(Get-Responsibility $relative $file.BaseName)")
    $javaBody.Add("- 注解：$(if ($annotations.Count) { ($annotations | ForEach-Object { "``$_``" }) -join '、' } else { '无类级或成员级注解被提取' })。")
    $javaBody.Add("- 显式方法：$(if ($methods.Count) { ($methods | ForEach-Object { "``$_``" }) -join '；' } else { '未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型' })。")
    $javaBody.Add("- 项目内依赖：$(if ($internalImports.Count) { ($internalImports | ForEach-Object { "``$_``" }) -join '、' } else { '无显式项目内 import' })。")
    $javaBody.Add("- 主要外部依赖：$(if ($externalImports.Count) { ($externalImports | ForEach-Object { "``$_``" }) -join '、' } else { '仅 JDK 类型或无显式外部 import' })。")
    $javaBody.Add("- Web 映射注解：$(if ($mappings.Count) { ($mappings | ForEach-Object { "``@$_``" }) -join '、' } else { '无' })。")
    $javaBody.Add("- 持久化表线索：$(if ($tables.Count) { ($tables | ForEach-Object { "``$_``" }) -join '、' } else { '无直接 SQL 或表注解线索' })。")
    $javaBody.Add('- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。')
    $javaBody.Add('')
}
Write-SplitDocument '01-java-source-index' 'Java 源码逐文件技术索引' $javaBody

$frontendBody = [System.Collections.Generic.List[string]]::new()
$frontendFiles = Get-ChildItem (Join-Path $RepositoryRoot 'vue-code\src') -Recurse -File |
    Where-Object { $_.Extension -in '.vue', '.ts', '.css', '.svg' } | Sort-Object FullName
foreach ($file in $frontendFiles) {
    $lines = [IO.File]::ReadAllLines($file.FullName, [Text.Encoding]::UTF8)
    $relative = Convert-ToRelativePath $file.FullName
    $imports = Get-UniqueMatches $lines '^\s*import\s+.*?from\s+[''"]([^''"]+)[''"]' 30
    $exports = Get-UniqueMatches $lines '^\s*export\s+(?:default\s+)?(?:async\s+)?(?:function|const|interface|type|class)\s+([A-Za-z_$][A-Za-z0-9_$]*)' 30
    $urls = Get-UniqueMatches $lines '(?:url\s*:\s*|fetch\()[''"]([^''"]+)[''"]' 30
    $components = Get-UniqueMatches $lines '<([A-Z][A-Za-z0-9]+)(?:\s|/|>)' 30
    $reactivity = Get-UniqueMatches $lines '\b(ref|reactive|computed|watch|watchEffect|onMounted|onUnmounted)\s*\(' 20

    $role = if ($relative.Contains('/api/')) { '前端 API 契约与请求封装。' }
        elseif ($relative.Contains('/views/')) { '业务页面、页面组合逻辑或页面私有组件。' }
        elseif ($relative.Contains('/components/')) { '可复用界面组件或布局组件。' }
        elseif ($relative.Contains('/router/')) { 'Vue Router 路由表与导航守卫。' }
        elseif ($relative.Contains('/utils/')) { '前端请求、格式化或通用工具。' }
        elseif ($relative.Contains('/assets/')) { '全局样式或静态视觉资源。' }
        else { 'Vue 应用入口或基础模块。' }

    $frontendBody.Add("## `$relative`")
    $frontendBody.Add('')
    $frontendBody.Add("- 规模：$($lines.Count) 行；文件大小 $($file.Length) 字节。")
    $frontendBody.Add("- 职责判断：$role")
    $frontendBody.Add("- 模块依赖：$(if ($imports.Count) { ($imports | ForEach-Object { "``$_``" }) -join '、' } else { '未提取到 ES module import' })。")
    $frontendBody.Add("- 导出符号：$(if ($exports.Count) { ($exports | ForEach-Object { "``$_``" }) -join '、' } else { '无命名导出或由 Vue SFC 模板隐式提供' })。")
    $frontendBody.Add("- 后端路径：$(if ($urls.Count) { ($urls | ForEach-Object { "``$_``" }) -join '、' } else { '无直接请求 URL' })。")
    $frontendBody.Add("- 使用的业务组件：$(if ($components.Count) { ($components | ForEach-Object { "``$_``" }) -join '、' } else { '未提取到 PascalCase 子组件标签' })。")
    $frontendBody.Add("- Composition API：$(if ($reactivity.Count) { ($reactivity | Sort-Object -Unique | ForEach-Object { "``$_``" }) -join '、' } else { '未提取到常见响应式 API 调用' })。")
    $frontendBody.Add('- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。')
    $frontendBody.Add('')
}
Write-SplitDocument '02-frontend-source-index' '前端源码逐文件技术索引' $frontendBody

$resourceBody = [System.Collections.Generic.List[string]]::new()
$resourceFiles = @()
$resourceFiles += Get-ChildItem (Join-Path $RepositoryRoot 'src\main\resources') -Recurse -File
$resourceFiles += Get-ChildItem $RepositoryRoot -File | Where-Object { $_.Name -in @('pom.xml', 'Dockerfile', 'install.sh', '.dockerignore', '.gitignore', '.gitattributes', 'mvnw', 'mvnw.cmd', 'package-lock.json') }
$resourceFiles += Get-ChildItem (Join-Path $RepositoryRoot 'vue-code') -File | Where-Object { $_.Name -in @('package.json', 'package-lock.json', 'vite.config.ts', 'tsconfig.json', 'tsconfig.app.json', 'tsconfig.node.json', 'index.html', 'eslint.config.ts') }
foreach ($file in ($resourceFiles | Sort-Object FullName -Unique)) {
    $relative = Convert-ToRelativePath $file.FullName
    $isText = $file.Extension -in '.xml', '.yml', '.yaml', '.properties', '.sql', '.json', '.ts', '.html', '.sh', '.cmd', '.txt', '.md', '.gitignore', '.gitattributes', '.dockerignore' -or $file.Name -in @('Dockerfile', 'mvnw')
    $lineCount = if ($isText) { [IO.File]::ReadAllLines($file.FullName, [Text.Encoding]::UTF8).Count } else { 0 }
    $resourceBody.Add("## `$relative`")
    $resourceBody.Add('')
    $resourceBody.Add("- 类型：`$($file.Extension)`；大小：$($file.Length) 字节；文本行数：$lineCount。")
    $resourceBody.Add("- 角色：$(if ($relative.Contains('resources')) { '后端运行资源、数据库初始化、日志、静态文件或应用配置。' } elseif ($relative.StartsWith('vue-code/')) { '前端工程、TypeScript 或 Vite 配置。' } else { '仓库级构建、容器、安装或版本控制配置。' })")
    $resourceBody.Add('- 维护提示：配置变更应核对默认值、环境变量覆盖、容器挂载路径和敏感信息处理。')
    $resourceBody.Add('')
}
Write-SplitDocument '03-resource-index' '配置、资源与工程文件索引' $resourceBody

$readme = [System.Collections.Generic.List[string]]::new()
$readme.Add('# 自动生成章节目录')
$readme.Add('')
$readme.Add("生成时间：$([DateTimeOffset]::Now.ToString('yyyy-MM-dd HH:mm:ss zzz'))")
$readme.Add('')
$readme.Add("Java 文件：$($javaFiles.Count) 个。")
$readme.Add('')
$readme.Add("前端源码文件：$($frontendFiles.Count) 个。")
$readme.Add('')
$readme.Add("资源与工程文件：$($resourceFiles.Count) 个。")
$readme.Add('')
$readme.Add('## 章节')
$readme.Add('')
foreach ($name in $generatedFiles) { $readme.Add("- [$name](./$name)") }
[IO.File]::WriteAllLines((Join-Path $outputRoot 'README.md'), $readme, $utf8NoBom)

Write-Output "Generated $($generatedFiles.Count) chapter files under $outputRoot"
