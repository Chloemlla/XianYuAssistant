# 前端源码逐文件技术索引（第 1 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

## vue-code/src/api/account.ts

- 规模：51 行；文件大小 965 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：getAccountList、addAccount、updateAccount、deleteAccount、manualAddAccount。
- 后端路径：/account/list、/account/add、/account/update、/account/delete、/account/manualAdd。
- 使用的业务组件：Account。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/ai.ts

- 规模：127 行；文件大小 3233 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：ChatWithAIReq、PutNewDataReq、RAGDataItem、chatWithAI、chatTestWithAI、putNewDataToRAG、queryRAGData、deleteRAGData、AIStatus、getAIStatus、saveFixedMaterial、getFixedMaterial、syncDetailToFixedMaterial。
- 后端路径：/ai/chat、/ai/chatTest、/ai/putNewData、/ai/queryRAGData、/ai/deleteRAGData、/ai/status、/ai/saveFixedMaterial、/ai/getFixedMaterial、/ai/syncDetailToFixedMaterial。
- 使用的业务组件：Response。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/auth.ts

- 规模：35 行；文件大小 772 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：checkUserExists、login、register、logout。
- 后端路径：/login/checkUserExists、/login/login、/login/register、/login/logout。
- 使用的业务组件：null。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/auto-delivery-config.ts

- 规模：128 行；文件大小 2995 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：AutoDeliveryConfig、SaveAutoDeliveryConfigReq、GetAutoDeliveryConfigReq、saveOrUpdateAutoDeliveryConfig、getAutoDeliveryConfig、getAutoDeliveryConfigsByGoodsId、getAutoDeliveryConfigsByAccountId、deleteAutoDeliveryConfig、GoodsSku、GoodsSkuProperty、GoodsSkuDetail、getGoodsSkuList、getGoodsSkuDetail。
- 后端路径：/auto-delivery-config/save、/auto-delivery-config/get、/auto-delivery-config/listByGoods、/auto-delivery-config/list、/auto-delivery-config/delete、/goods-sku/list、/goods-sku/detail。
- 使用的业务组件：AutoDeliveryConfig、GoodsSkuDetail。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/auto-delivery-record.ts

- 规模：72 行；文件大小 1558 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：AutoDeliveryRecord、AutoDeliveryRecordReq、AutoDeliveryRecordResp、getAutoDeliveryRecords、ConfirmShipmentReq、confirmShipment、TriggerAutoDeliveryReq、triggerAutoDelivery。
- 后端路径：/items/autoDeliveryRecords、/order/confirmShipment、/autoDelivery/trigger。
- 使用的业务组件：AutoDeliveryRecordResp、string。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/backup.ts

- 规模：57 行；文件大小 1247 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：BackupModule、BackupExportResult、BackupImportResult、getBackupModules、exportBackup、importBackup、getLogDates、downloadLog。
- 后端路径：/backup/modules、/backup/export、/backup/import、/backup/log-dates。
- 使用的业务组件：BackupExportResult、BackupImportResult、Blob。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/dashboard.ts

- 规模：20 行；文件大小 380 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：DashboardStats、getDashboardStats。
- 后端路径：/dashboard/stats。
- 使用的业务组件：DashboardStats。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/data-panel.ts

- 规模：52 行；文件大小 1117 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：DataPanelStats、DataPanelTrend、SalesRevenueData、getDataPanelStats、getDataPanelTrend、getRealtimeRevenue、getSalesRevenue。
- 后端路径：/data-panel/stats、/data-panel/trend、/data-panel/realtimeRevenue、/data-panel/salesRevenue。
- 使用的业务组件：DataPanelStats、DataPanelTrend、number、SalesRevenueData。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/goods.ts

- 规模：253 行；文件大小 5219 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：GoodsItem、GoodsItemWithConfig、GoodsListResponse、GoodsDetailResponse、RefreshItemsResponse、SyncProgressResponse、getGoodsList、refreshGoods、getGoodsDetail、updateAutoDeliveryStatus、updateAutoConfirmShipment、updateAutoReplyStatus、deleteItem、syncSingleItem、AutoReplyConfigResponse、getAutoReplyConfig、updateAutoReplyConfig、AutoReplyRecord、AutoReplyRecordListResponse、getAutoReplyRecords、getSyncProgress、checkSyncing。
- 后端路径：/items/list、/items/refresh、/items/detail、/items/updateAutoDeliveryStatus、/items/updateAutoConfirmShipment、/items/updateAutoReplyStatus、/items/delete、/items/syncSingle、/items/getRagAutoReplyConfig、/items/updateRagAutoReplyConfig、/items/autoReplyRecords。
- 使用的业务组件：GoodsListResponse、RefreshItemsResponse、GoodsDetailResponse、AutoReplyConfigResponse、AutoReplyRecordListResponse、SyncProgressResponse、boolean。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/image.ts

- 规模：44 行；文件大小 1019 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：uploadImage、uploadImageFromUrl、sendImageMessage。
- 后端路径：/image/upload、/image/uploadFromUrl、/websocket/sendImageMessage。
- 使用的业务组件：string。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/kami-config.ts

- 规模：131 行；文件大小 2789 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：KamiConfig、KamiItem、SaveKamiConfigReq、QueryKamiItemsReq、saveKamiConfig、getKamiConfigsByAccountId、getKamiConfigById、deleteKamiConfig、addKamiItem、batchImportKamiItems、getKamiItemsByConfigId、queryKamiItems、deleteKamiItem、resetKamiItem、exportKamiItems。
- 后端路径：/kami-config/save、/kami-config/list、/kami-config/detail、/kami-config/delete、/kami-config/item/add、/kami-config/item/batchImport、/kami-config/item/list、/kami-config/item/query、/kami-config/item/delete、/kami-config/item/reset、/kami-config/item/export。
- 使用的业务组件：KamiConfig、KamiItem、number。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/keywordReply.ts

- 规模：54 行；文件大小 2072 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：KeywordReplyContent、KeywordReplyRule、getKeywordReplyRules、addKeywordRule、deleteKeywordRule、updateKeyword、updateKeywordRuleMatchMode、ensureFallbackRule、addKeywordContent、updateKeywordContent、deleteKeywordContent。
- 后端路径：/keyword-reply/rules、/keyword-reply/addRule、/keyword-reply/deleteRule、/keyword-reply/updateKeyword、/keyword-reply/updateMatchMode、/keyword-reply/ensureFallbackRule、/keyword-reply/addContent、/keyword-reply/updateContent、/keyword-reply/deleteContent。
- 使用的业务组件：KeywordReplyRule、KeywordReplyContent。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/message.ts

- 规模：75 行；文件大小 1552 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：ChatMessage、MessageListResponse、getMessageList、getContextMessages、sendMessage。
- 后端路径：/msg/list、/msg/context、/websocket/sendMessage。
- 使用的业务组件：MessageListResponse、string。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/operation-log.ts

- 规模：57 行；文件大小 1203 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：OperationLog、QueryLogsRequest、QueryLogsResponse、queryOperationLogs、deleteOldLogs。
- 后端路径：/operation-log/query、/operation-log/deleteOld。
- 使用的业务组件：QueryLogsResponse、number。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/order.ts

- 规模：94 行；文件大小 2136 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：DeliveryRecordQueryReq、DeliveryRecordVO、DeliveryRecordPageResult、queryDeliveryRecordList、confirmShipment、getOrderDetail、manualDelivery、getPendingOrders、deliverPendingOrders、consignDummyDelivery。
- 后端路径：/items/autoDeliveryRecords、/order/confirmShipment、/order/detail、/autoDelivery/manual、/order/pendingOrders、/order/deliverPendingOrders、/order/consignDummyDelivery。
- 使用的业务组件：DeliveryRecordPageResult、string、number。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/qrlogin.ts

- 规模：34 行；文件大小 756 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：generateQRCode、getQRCodeStatus、getQRCodeCookies、cleanupQRSessions。
- 后端路径：/qrlogin/generate、/qrlogin/cleanup。
- 使用的业务组件：QRLoginSession。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/setting.ts

- 规模：52 行；文件大小 1013 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：SysSetting、getSetting、getAllSettings、saveSetting、deleteSetting、testEmail。
- 后端路径：/setting/get、/setting/list、/setting/save、/setting/delete、/setting/testEmail。
- 使用的业务组件：SysSetting、null、string。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/system.ts

- 规模：41 行；文件大小 886 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request。
- 导出符号：getCurrentUser、changePassword、getVersion、checkUpdate。
- 后端路径：/system/currentUser、/system/changePassword、/system/version、/system/checkUpdate。
- 使用的业务组件：null、string。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/api/websocket.ts

- 规模：103 行；文件大小 2751 字节。
- 职责判断：前端 API 契约与请求封装。
- 模块依赖：@/utils/request、@/types。
- 导出符号：WebSocketStatus、getConnectionStatus、startConnection、stopConnection、updateCookie、SendMessageRequest、sendMessage、clearCaptchaWait、RefreshTokenResponse、refreshToken、updateToken。
- 后端路径：/websocket/status、/websocket/start、/websocket/stop、/websocket/updateCookie、/websocket/sendMessage、/websocket/clearCaptchaWait、/websocket/refreshToken、/websocket/updateToken。
- 使用的业务组件：WebSocketStatus、any、RefreshTokenResponse、string。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/App.vue

- 规模：33 行；文件大小 728 字节。
- 职责判断：Vue 应用入口或基础模块。
- 模块依赖：vue、vue-router、@/components/layout/AppLayout.vue、@/components/layout/LoginLayout.vue。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、LoginLayout、AppLayout、style。
- Composition API：computed、ref、watch。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/assets/base.css

- 规模：94 行；文件大小 2137 字节。
- 职责判断：全局样式或静态视觉资源。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/assets/logo.svg

- 规模：1 行；文件大小 276 字节。
- 职责判断：全局样式或静态视觉资源。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：svg。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/assets/main.css

- 规模：31 行；文件大小 558 字节。
- 职责判断：全局样式或静态视觉资源。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/assets/theme.css

- 规模：95 行；文件大小 2426 字节。
- 职责判断：全局样式或静态视觉资源。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：未提取到 PascalCase 子组件标签。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/HelloWorld.vue

- 规模：41 行；文件大小 687 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：script、template、div、h1、h3、style。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconAccount.vue

- 规模：6 行；文件大小 276 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、circle、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconAlert.vue

- 规模：7 行；文件大小 354 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconArrowRight.vue

- 规模：6 行；文件大小 252 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconBackup.vue

- 规模：7 行；文件大小 341 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path、polyline、line。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconChart.vue

- 规模：6 行；文件大小 258 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconChat.vue

- 规模：5 行；文件大小 397 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconCheck.vue

- 规模：5 行；文件大小 228 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconChevronDown.vue

- 规模：5 行；文件大小 225 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconChevronLeft.vue

- 规模：5 行；文件大小 228 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
- 后端路径：无直接请求 URL。
- 使用的业务组件：template、svg、path。
- Composition API：未提取到常见响应式 API 调用。
- 维护提示：修改时应同步核对类型定义、请求响应结构、加载/错误状态和路由入口。

## vue-code/src/components/icons/IconChevronRight.vue

- 规模：5 行；文件大小 226 字节。
- 职责判断：可复用界面组件或布局组件。
- 模块依赖：未提取到 ES module import。
- 导出符号：无命名导出或由 Vue SFC 模板隐式提供。
