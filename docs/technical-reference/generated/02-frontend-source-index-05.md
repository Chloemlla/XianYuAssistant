# 前端源码逐文件技术索引（第 5 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 规模：330 行；文件大小 9352 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、@/api/account、@/utils、@/types、@/api/goods。
- 导出符号：useGoodsManager。
- 后端路径：无直接请求 URL。
- 使用的业务组件：number、string、GoodsItemWithConfig、SyncProgressResponse、typeof。
- Composition API：computed、onUnmounted、reactive、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/kami-config/index.vue

- 规模：1507 行；文件大小 43299 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/utils/toast、@/utils/confirm、@/api/account、@/types、@/components/icons/IconChevronDown.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、number、template、div、header、h1、button、span、option、h2、table、thead、tr、th、tbody、td、Teleport、Transition、label、input、textarea、style。
- Composition API：computed、onMounted、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/login/index.vue

- 规模：468 行；文件大小 11059 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/auth、@/utils/request。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、div、h2、label、button、span、style。
- Composition API：onMounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/messages/components/ContextDialog.vue

- 规模：870 行；文件大小 19326 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/message、@/api/image、@/utils/toast、@/components/icons/IconUser.vue、@/components/icons/IconEmpty.vue、@/components/icons/IconSend.vue、@/components/icons/IconImage.vue、@/components/icons/IconClose.vue、@/components/MultiImageUploader.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、HTMLElement、typeof、template、Teleport、Transition、div、span、button、IconClose、IconUser、IconImage、IconSend、style。
- Composition API：computed、onMounted、onUnmounted、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/messages/components/GoodsSidebar.vue

- 规模：277 行；文件大小 5697 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：@/api/goods、@/components/icons/IconImage.vue、@/components/icons/IconEmpty.vue、@/components/icons/IconRefresh.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、template、div、span、IconImage、style。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/messages/components/MessageList.vue

- 规模：579 行；文件大小 14004 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/message、@/components/icons/IconEmpty.vue、@/components/icons/IconMessage.vue、@/components/icons/IconUser.vue、./ContextDialog.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、template、div、span、IconUser、IconMessage、table、thead、tr、th、tbody、td、button、style。
- Composition API：onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/messages/index.vue

- 规模：724 行；文件大小 20750 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、./useMessageManager、@/components/icons/IconMessage.vue、@/components/icons/IconRefresh.vue、@/components/icons/IconChevronDown.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconChevronRight.vue、@/components/icons/IconImage.vue、./components/GoodsSidebar.vue、./components/MessageList.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、HTMLElement、typeof、template、div、IconMessage、h1、option、span、IconChevronDown、IconRefresh、IconImage、svg、IconChevronLeft、IconChevronRight、button、style。
- Composition API：onMounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/messages/messages.css

- 规模：549 行；文件大小 13197 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/messages/useMessageManager.ts

- 规模：305 行；文件大小 9189 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/account、@/api/message、@/api/goods、@/utils、@/types。
- 导出符号：useMessageManager。
- 后端路径：无直接请求 URL。
- 使用的业务组件：number、HTMLElement、GoodsItemWithConfig。
- Composition API：computed、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/operation-log/index.vue

- 规模：427 行；文件大小 15870 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、./useOperationLog、@/components/icons/IconLog.vue、@/components/icons/IconChevronDown.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconChevronRight.vue、@/components/icons/IconClock.vue、@/components/icons/IconRefresh.vue、@/components/icons/IconEmpty.vue、@/components/icons/IconInfo.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、div、IconLog、h1、option、span、IconChevronDown、button、IconRefresh、IconEmpty、IconChevronLeft、IconInfo、table、thead、tr、th、tbody、td、IconClock、IconChevronRight、Transition、h3、svg、line、pre、style。
- Composition API：onMounted。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/operation-log/operation-log.css

- 规模：1277 行；文件大小 26181 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/operation-log/useOperationLog.ts

- 规模：360 行；文件大小 9612 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/account、@/api/operation-log、@/types、@/utils。
- 导出符号：useOperationLog。
- 后端路径：无直接请求 URL。
- 使用的业务组件：number、string、Account、OperationLog。
- Composition API：computed、onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/orders/components/OrderTable.vue

- 规模：1133 行；文件大小 31763 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/utils、@/api/order、../useOrderManager、@/components/icons/IconEmpty.vue、@/components/icons/IconCopy.vue、@/components/icons/IconTruck.vue、@/components/icons/IconUser.vue、@/components/icons/IconClock.vue、@/components/icons/IconShoppingBag.vue、@/components/icons/IconImage.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、Props、Emits、any、typeof、template、div、span、IconShoppingBag、IconUser、IconClock、button、IconCopy、IconEye、IconTruck、table、thead、tr、th、tbody、td、Transition、h3、pre、style。
- Composition API：onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/orders/index.vue

- 规模：420 行；文件大小 14012 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、./useOrderManager、@/components/icons/IconClipboard.vue、@/components/icons/IconSearch.vue、@/components/icons/IconRefresh.vue、@/components/icons/IconFilter.vue、@/components/icons/IconChevronDown.vue、@/components/icons/IconChevronLeft.vue、@/components/icons/IconChevronRight.vue、@/components/icons/IconPackage.vue、./components/OrderTable.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、any、template、div、IconClipboard、h1、option、span、IconChevronDown、button、IconSearch、IconRefresh、IconFilter、IconPackage、img、svg、IconChevronLeft、IconChevronRight、Transition、h3、label、style。
- Composition API：computed、onMounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/orders/orders.css

- 规模：1023 行；文件大小 22936 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/orders/useOrderManager.ts

- 规模：261 行；文件大小 6997 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/order、@/api/account、@/api/goods、@/types、@/utils。
- 导出符号：DeliveryRecordItem、useOrderManager。
- 后端路径：无直接请求 URL。
- 使用的业务组件：HTMLElement、string、DeliveryRecordQueryReq、DeliveryRecordItem。
- Composition API：computed、reactive、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/pending-orders/index.vue

- 规模：222 行；文件大小 11918 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、@/api/account、@/api/order。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、number、string、typeof、template、div、h1、select、option、span、button、svg、label、input、style。
- Composition API：computed、onMounted、onUnmounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/qrlogin/index.vue

- 规模：16 行；文件大小 242 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、div、h1、script、style。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/views/settings/index.vue

- 规模：2415 行；文件大小 73318 字节。
- 职责判断：业务页面、页面组合逻辑或页面私有组件。
- 模块依赖：vue、vue-router、@/api/system、@/api/auth、@/api/setting、@/api/ai、@/api/backup、@/utils/toast、@/utils/confirm、@/utils/request、@/components/icons/IconUser.vue、@/components/icons/IconRobot.vue、@/components/icons/IconChat.vue、@/components/icons/IconMail.vue、@/components/icons/IconBackup.vue、@/components/icons/IconInfo.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、HTMLInputElement、template、div、span、label、button、strong、input、table、thead、tr、th、tbody、td、select、option、img、code、pre、ul、li、style。
- Composition API：onMounted、ref。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

