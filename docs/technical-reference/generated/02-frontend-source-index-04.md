# 前端源码逐文件技术索引（第 4 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 使用的业务组件：script、Props、Emits、template、teleport、div、h2、input、button、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/accounts/components/DeleteConfirmDialog.vue

- 规模：220 行；文件大小 4290 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/account、@/utils。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、teleport、div、h2、ul、li、button、style。
- Composition API：ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/accounts/components/ManualAddDialog.vue

- 规模：236 行；文件大小 4668 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/account、@/utils。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、teleport、div、h2、button、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/accounts/components/QRLoginDialog.vue

- 规模：507 行；文件大小 10457 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/qrlogin、@/api/account、@/utils、@/types。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、transition、div、button、img、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/accounts/index.vue

- 规模：98 行；文件大小 2828 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：./useAccountManager、./components/AccountTable.vue、./components/AddAccountDialog.vue、./components/ManualAddDialog.vue、./components/QRLoginDialog.vue、./components/DeleteConfirmDialog.vue、@/components/icons/IconQrCode.vue、@/components/icons/IconPlus.vue、@/components/icons/IconSync.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、div、header、h1、button、IconQrCode、span、IconPlus、IconSync、section、footer、ManualAddDialog、QRLoginDialog、style。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/accounts/useAccountManager.ts

- 规模：105 行；文件大小 2755 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/account、@/utils、@/types。
- 导出符号：useAccountManager。
- 后端路径：无直接请求 URL。
- 使用的业务组件：Account、number。
- Composition API：reactive、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/auto-delivery/auto-delivery.css

- 规模：1852 行；文件大小 35608 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/auto-delivery/index.vue

- 规模：770 行；文件大小 31094 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、./useAutoDelivery、@/components/icons/IconTruck.vue、@/components/icons/IconChevronDown.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconChevronRight.vue、@/components/icons/IconText.vue、@/components/icons/IconRobot.vue、@/components/icons/IconSend.vue、@/components/icons/IconImage.vue、@/components/icons/IconSparkle.vue、@/components/icons/IconCheck.vue、@/components/icons/IconClock.vue、@/components/icons/IconPackage.vue、@/components/icons/IconCopy.vue、@/components/icons/IconChat.vue、../goods/components/GoodsDetail.vue、@/components/MultiImageUploader.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、div、IconTruck、h1、option、span、IconChevronDown、button、IconSparkle、IconPackage、img、svg、IconChevronLeft、IconImage、IconRobot、IconChat、label、IconText、IconCheck、Transition、h3、code、pre、table、thead、tbody、tr、style。
- Composition API：computed、onMounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/auto-delivery/useAutoDelivery.ts

- 规模：796 行；文件大小 24364 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、@/api/account、@/api/goods、@/utils、@/api/websocket、@/utils/toast、@/types。
- 导出符号：useAutoDelivery。
- 后端路径：无直接请求 URL。
- 使用的业务组件：number、GoodsItemWithConfig、AutoDeliveryConfig、string、HTMLElement。
- Composition API：computed、onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/auto-reply/auto-reply.css

- 规模：3268 行；文件大小 63450 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/auto-reply/index.vue

- 规模：1167 行；文件大小 52996 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、./useAutoReply、@/components/icons/IconChat.vue、@/components/icons/IconChevronDown.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconRobot.vue、@/components/icons/IconSend.vue、@/components/icons/IconImage.vue、@/components/icons/IconSparkle.vue、@/components/icons/IconCheck.vue、@/components/icons/IconPackage.vue、@/components/icons/IconClipboard.vue、@/components/icons/IconSearch.vue、../goods/components/GoodsDetailDialog.vue、@/components/ImageUploader.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、div、IconChat、h1、option、span、IconChevronDown、button、IconSparkle、IconPackage、img、svg、IconChevronLeft、IconImage、label、ImageUploader、textarea、Teleport、input、IconClipboard、IconRobot、IconCheck、IconSearch、table、thead、tr、th、tbody、td。
- Composition API：computed、onMounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/auto-reply/useAutoReply.ts

- 规模：1373 行；文件大小 44245 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、@/api/account、@/api/goods、@/api/ai、@/utils、@/utils/toast、@/types、@/api/keywordReply。
- 导出符号：ChatMessage、useAutoReply。
- 后端路径：无直接请求 URL。
- 使用的业务组件：number、GoodsItemWithConfig、HTMLElement、string、AutoReplyRecord、KeywordReplyRule。
- Composition API：computed、onMounted、onUnmounted、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/CaptchaGuideDialog.vue

- 规模：291 行；文件大小 6166 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、Teleport、Transition、div、h2、button、span、style。
- Composition API：onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/ConnectionCard.vue

- 规模：613 行；文件大小 14404 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/types、@/components/icons/IconClock.vue、@/components/icons/IconArrowRight.vue、@/components/icons/IconEmpty.vue、@/components/icons/IconCookie.vue、@/components/icons/IconWs.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、div、span、IconArrowRight、IconCookie、IconWs、style。
- Composition API：onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/ConnectionDetail.vue

- 规模：687 行；文件大小 18403 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/utils/confirm、@/utils/toast、@/api/websocket、@/api/operation-log、@/utils、./CredentialModal.vue、./ManualUpdateCookieModal.vue、./QRUpdateDialog.vue、./CaptchaGuideDialog.vue、@/components/icons/IconKey.vue、@/components/icons/IconPlay.vue、@/components/icons/IconStop.vue、@/components/icons/IconRefresh.vue、@/components/icons/IconLog.vue、@/components/icons/IconCheck.vue、@/components/icons/IconAlert.vue、@/components/icons/IconLink.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、ConnectionStatus、template、div、component、span、button、IconKey、IconStop、IconPlay、IconRefresh、IconLog、style。
- Composition API：computed、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/ConnectionDetailDialog.vue

- 规模：1058 行；文件大小 27520 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/utils/confirm、@/utils/toast、@/api/websocket、@/utils、./ManualUpdateCookieDialog.vue、./ManualUpdateTokenDialog.vue、./QRUpdateDialog.vue、./CaptchaGuideDialog.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、ConnectionStatus、template、Teleport、Transition、div、h2、button、span、h3、style。
- Composition API：computed、onMounted、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/CredentialModal.vue

- 规模：598 行；文件大小 13702 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/components/icons/IconCookie.vue、@/components/icons/IconKey.vue、@/components/icons/IconQrCode.vue、@/components/icons/IconClose.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、Transition、div、h2、button、IconClose、IconQrCode、span、IconCookie、IconKey、style。
- Composition API：computed。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/ManualUpdateCookieDialog.vue

- 规模：358 行；文件大小 7660 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/websocket、@/utils。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、Teleport、Transition、div、h2、button、img、label、textarea、span、code、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/ManualUpdateCookieModal.vue

- 规模：528 行；文件大小 10837 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/websocket、@/utils、@/components/icons/IconClose.vue、@/components/icons/IconHelp.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、Transition、div、h2、button、IconHelp、span、IconClose、img、label、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/ManualUpdateTokenDialog.vue

- 规模：295 行；文件大小 6375 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/websocket、@/utils。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、Teleport、Transition、div、h2、button、label、input、textarea、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/MobileCredentialModal.vue

- 规模：486 行；文件大小 11816 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/components/icons/IconCookie.vue、@/components/icons/IconKey.vue、@/components/icons/IconQrCode.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconRefresh.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、Transition、div、button、IconChevronLeft、span、h2、IconRefresh、IconQrCode、IconCookie、IconKey、style。
- Composition API：computed。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/QRUpdateDialog.vue

- 规模：365 行；文件大小 8365 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/qrlogin、@/api/websocket、@/utils、@/types。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、Teleport、Transition、div、h2、button、img、span、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/components/RefreshCookieDialog.vue

- 规模：370 行；文件大小 8561 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/qrlogin、@/api/websocket、@/utils、@/types、@/utils/confirm、@/utils/toast。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、Teleport、Transition、div、h2、button、img、span、style。
- Composition API：ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/connection.css

- 规模：357 行；文件大小 7530 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/ConnectionDetail.vue

- 规模：916 行；文件大小 25371 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、@/api/websocket、@/api/operation-log、@/api/account、@/utils、@/utils/confirm、@/utils/toast、./components/ConnectionDetail.vue、./components/ManualUpdateCookieModal.vue、./components/QRUpdateDialog.vue、./components/CaptchaGuideDialog.vue、@/components/icons/IconCookie.vue、@/components/icons/IconKey.vue、@/components/icons/IconPlay.vue、@/components/icons/IconStop.vue、@/components/icons/IconQrCode.vue、@/components/icons/IconRefresh.vue、@/components/icons/IconLog.vue、@/components/icons/IconCheck.vue、@/components/icons/IconAlert.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconHelp.vue、@/components/icons/IconCopy.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、ConnectionStatus、template、DesktopDetail、div、header、button、IconChevronLeft、span、h1、IconRefresh、IconKey、IconStop、IconPlay、IconQrCode、Transition、IconCopy、style。
- Composition API：computed、onMounted、onUnmounted、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/index.vue

- 规模：212 行；文件大小 4832 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、./useConnectionManager、./components/ConnectionCard.vue、./components/ConnectionDetail.vue、@/components/icons/IconLink.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、div、header、h1、section、span、style。
- Composition API：computed、onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/connection/useConnectionManager.ts

- 规模：294 行；文件大小 8822 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/utils/confirm、@/api/account、@/api/websocket、@/utils、@/types。
- 导出符号：useConnectionManager。
- 后端路径：无直接请求 URL。
- 使用的业务组件：number、ConnectionStatus。
- Composition API：onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/dashboard/dashboard.css

- 规模：623 行；文件大小 15292 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/dashboard/index.vue

- 规模：1020 行；文件大小 49791 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、./useDashboard、@/api/data-panel、@/components/icons/IconAccount.vue、@/components/icons/IconPackage.vue、@/components/icons/IconFire.vue、@/components/icons/IconLink.vue、@/components/icons/IconRobot.vue、@/components/icons/IconChat.vue、@/components/icons/IconChart.vue、@/components/icons/IconRefresh.vue、@/components/icons/IconLog.vue、@/components/icons/IconRocket.vue、@/components/icons/IconHelp.vue、@/components/icons/IconInfo.vue、@/components/icons/IconArrowRight.vue、@/components/icons/IconChevronDown.vue、@/components/icons/IconUsers.vue、@/components/icons/IconSend.vue、@/components/icons/IconShield.vue、@/components/icons/IconSparkle.vue、@/components/icons/IconCheck.vue、@/components/icons/IconAlert.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、number、DataPanelStats、DataPanelTrend、typeof、SalesRevenueData、SalesQuickRange、ChartTooltip、template、div、IconRocket、span、IconChart、section、component、h2、h3、ul、li、button、IconArrowRight、h1、IconFire、IconHelp、svg、text、line、path、circle、style。
- Composition API：computed、onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/dashboard/useDashboard.ts

- 规模：36 行；文件大小 828 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/dashboard。
- 导出符号：useDashboard。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：reactive、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/goods/components/GoodsDetail.vue

- 规模：1482 行；文件大小 40198 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、@/api/goods、@/api/auto-delivery-config、@/utils、@/components/icons/IconImage.vue、@/components/icons/IconSend.vue、@/components/icons/IconRobot.vue、@/components/icons/IconSparkle.vue、@/components/icons/IconTrash.vue、@/components/icons/IconCheck.vue、@/components/icons/IconClock.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconChevronRight.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、GoodsItemWithConfig、template、Transition、div、button、IconChevronLeft、span、img、IconChevronRight、IconSend、IconSparkle、IconRobot、IconClock、IconTrash、svg、path、IconImage、Teleport、style。
- Composition API：computed、onMounted、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/goods/components/GoodsDetailDialog.vue

- 规模：650 行；文件大小 16902 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、@/api/goods、@/utils。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、GoodsItemWithConfig、template、Teleport、Transition、div、h2、button、img、h3、span、style。
- Composition API：computed、onMounted、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/goods/components/GoodsTable.vue

- 规模：976 行；文件大小 22930 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/utils、@/api/goods、@/components/icons/IconEmpty.vue、@/components/icons/IconTrash.vue、@/components/icons/IconSend.vue、@/components/icons/IconRobot.vue、@/components/icons/IconImage.vue、@/components/icons/IconCheck.vue、@/components/icons/IconSparkle.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、div、IconImage、span、IconSparkle、IconTrash、table、thead、tr、th、tbody、td、button、IconCheck、style。
- Composition API：onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/goods/goods.css

- 规模：697 行；文件大小 15649 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/goods/index.vue

- 规模：397 行；文件大小 11843 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、./useGoodsManager、@/components/icons/IconShoppingBag.vue、@/components/icons/IconRefresh.vue、@/components/icons/IconFilter.vue、@/components/icons/IconChevronDown.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconChevronRight.vue、./components/GoodsTable.vue、./components/GoodsDetail.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、HTMLElement、template、div、IconShoppingBag、h1、option、span、IconChevronDown、IconRefresh、IconChevronLeft、IconChevronRight、Transition、h3、style。
- Composition API：computed、onMounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/goods/useGoodsManager.ts

