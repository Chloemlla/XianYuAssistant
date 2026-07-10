# Java 源码逐文件技术索引（第 2 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 主类型：UserContext
- 包：com.feijimiao.xianyuassistant.context
- 规模：43 行；文件大小 1069 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：无类级或成员级注解被提取。
- 显式方法：set(Long userId, String username)；getUserId()；getUsername()；clear()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/AccountController.java

- 主类型：AccountController
- 包：com.feijimiao.xianyuassistant.controller
- 规模：228 行；文件大小 8566 字节。
- 职责判断：Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。
- 注解：@Slf4j、@RestController、@RequestMapping("/api/account")、@CrossOrigin(origins = "*")、@Autowired、@PostMapping("/list")、@PostMapping("/add")、@PostMapping("/manualAdd")、@PostMapping("/update")、@PostMapping("/delete")、@PostMapping("/detail")。
- 显式方法：getAccountList()；addAccount(@RequestBody AccountReqDTO reqDTO)；manualAddAccount(@RequestBody ManualAddAccountReqDTO reqDTO)；extractUnbFromCookie(String cookie)；updateAccount(@RequestBody UpdateAccountReqDTO reqDTO)；deleteAccount(@RequestBody DeleteAccountReqDTO reqDTO)；getAccountDetail(@RequestBody GetAccountDetailReqDTO reqDTO)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.controller.dto.AccountReqDTO、com.feijimiao.xianyuassistant.controller.dto.AddAccountRespDTO、com.feijimiao.xianyuassistant.controller.dto.DeleteAccountReqDTO、com.feijimiao.xianyuassistant.controller.dto.DeleteAccountRespDTO、com.feijimiao.xianyuassistant.controller.dto.GetAccountDetailReqDTO、com.feijimiao.xianyuassistant.controller.dto.GetAccountDetailRespDTO、com.feijimiao.xianyuassistant.controller.dto.GetAccountListRespDTO、com.feijimiao.xianyuassistant.controller.dto.ManualAddAccountReqDTO、com.feijimiao.xianyuassistant.controller.dto.UpdateAccountReqDTO、com.feijimiao.xianyuassistant.controller.dto.UpdateAccountRespDTO、com.feijimiao.xianyuassistant.service.AccountService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.web.bind.annotation.*。
- Web 映射注解：RequestMapping、PostMapping。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/AIChatController.java

- 主类型：AIChatController
- 包：com.feijimiao.xianyuassistant.controller
- 规模：203 行；文件大小 8647 字节。
- 职责判断：Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。
- 注解：@RestController、@RequestMapping("/ai")、@Autowired、@PostMapping(path = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)、@PostMapping(path = "/chatTest", produces = MediaType.TEXT_EVENT_STREAM_VALUE)、@PostMapping("/status")、@PostMapping("/putNewData")、@PostMapping("/queryRAGData")、@PostMapping("/deleteRAGData")、@PostMapping("/saveFixedMaterial")、@PostMapping("/getFixedMaterial")、@PostMapping("/syncDetailToFixedMaterial")。
- 显式方法：chatWithAi(@RequestBody ChatWithAIReqDTO chatWithAIReqDTO)；chatTestWithAi(@RequestBody ChatTestReqDTO req)；getAIStatus()；putNewData(@RequestBody PutNewDataToRAGReqDTO putNewDataToRAGReqDTO)；queryRAGData(@RequestBody PutNewDataToRAGReqDTO req)；deleteRAGData(@RequestBody DeleteRAGDataReqDTO req)；saveFixedMaterial(@RequestBody FixedMaterialReqDTO req)；getFixedMaterial(@RequestBody FixedMaterialReqDTO req)；syncDetailToFixedMaterial(@RequestBody FixedMaterialReqDTO req)；getAccountId()；setAccountId(Long accountId)；getGoodsId()；setGoodsId(String goodsId)；getFixedMaterial()；setFixedMaterial(String fixedMaterial)；getMsg()；setMsg(String msg)；isEnabled()；setEnabled(boolean enabled)；isAvailable()；setAvailable(boolean available)；isApiKeyConfigured()；setApiKeyConfigured(boolean apiKeyConfigured)；getMessage()；setMessage(String message)；getBaseUrl()；setBaseUrl(String baseUrl)；getModel()；setModel(String model)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.config.rag.DynamicAIChatClientManager、com.feijimiao.xianyuassistant.controller.dto.ChatWithAIReqDTO、com.feijimiao.xianyuassistant.controller.dto.DeleteRAGDataReqDTO、com.feijimiao.xianyuassistant.controller.dto.PutNewDataToRAGReqDTO、com.feijimiao.xianyuassistant.service.AIService、com.feijimiao.xianyuassistant.service.GoodsInfoService、com.feijimiao.xianyuassistant.service.bo.RAGDataRespBO、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig。
- 主要外部依赖：org.springframework.beans.factory.annotation.Autowired、org.springframework.http.MediaType、org.springframework.web.bind.annotation.*、reactor.core.publisher.Flux。
- Web 映射注解：RequestMapping、PostMapping。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/AutoDeliveryConfigController.java

- 主类型：AutoDeliveryConfigController
- 包：com.feijimiao.xianyuassistant.controller
- 规模：82 行；文件大小 4149 字节。
- 职责判断：Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。
- 注解：@Slf4j、@RestController、@RequestMapping("/api/auto-delivery-config")、@CrossOrigin(origins = "*")、@Autowired、@PostMapping("/save")、@PostMapping("/get")、@PostMapping("/listByGoods")、@PostMapping("/list")、@PostMapping("/delete")、@RequestParam("xyGoodsId")。
- 显式方法：saveOrUpdateConfig(@Valid @RequestBody AutoDeliveryConfigReqDTO reqDTO)；getConfig(@Valid @RequestBody AutoDeliveryConfigQueryReqDTO reqDTO)；getConfigsByGoodsId(@RequestBody AutoDeliveryConfigQueryReqDTO reqDTO)；getConfigsByAccountId(@RequestParam("xianyuAccountId") Long xianyuAccountId)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigReqDTO、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigRespDTO、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigQueryReqDTO、com.feijimiao.xianyuassistant.service.AutoDeliveryConfigService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.web.bind.annotation.*、jakarta.validation.Valid。
- Web 映射注解：RequestMapping、PostMapping。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/AutoDeliveryController.java

- 主类型：AutoDeliveryController
- 包：com.feijimiao.xianyuassistant.controller
- 规模：53 行；文件大小 2090 字节。
- 职责判断：Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。
- 注解：@Slf4j、@RestController、@RequestMapping("/api/autoDelivery")、@CrossOrigin(origins = "*")、@Autowired、@PostMapping("/trigger")、@PostMapping("/manual")。
- 显式方法：triggerAutoDelivery(@Valid @RequestBody TriggerAutoDeliveryReqDTO reqDTO)；manualDelivery(@Valid @RequestBody ManualDeliveryReqDTO reqDTO)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.TriggerAutoDeliveryReqDTO、com.feijimiao.xianyuassistant.controller.dto.ManualDeliveryReqDTO、com.feijimiao.xianyuassistant.service.AutoDeliveryService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.web.bind.annotation.*、jakarta.validation.Valid。
- Web 映射注解：RequestMapping、PostMapping。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/DashboardController.java

- 主类型：DashboardController
- 包：com.feijimiao.xianyuassistant.controller
- 规模：73 行；文件大小 2844 字节。
- 职责判断：Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。
- 注解：@Slf4j、@RestController、@RequestMapping("/api/dashboard")、@CrossOrigin(origins = "*")、@Autowired、@PostMapping("/stats")。
- 显式方法：getDashboardStats()。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper、com.feijimiao.xianyuassistant.controller.dto.DashboardStatsRespDTO。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.web.bind.annotation.*。
- Web 映射注解：RequestMapping、PostMapping。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/DataBackupController.java

- 主类型：DataBackupController
- 包：com.feijimiao.xianyuassistant.controller
- 规模：164 行；文件大小 6706 字节。
- 职责判断：Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。
- 注解：@Slf4j、@RestController、@RequestMapping("/api/backup")、@CrossOrigin(origins = "*")、@Autowired、@PostMapping("/modules")、@PostMapping("/export")、@PostMapping("/import")、@GetMapping("/log-dates")、@GetMapping("/log-download")。
- 显式方法：getModules()；exportData(@RequestBody BackupExportReqDTO reqDTO)；importData(@RequestBody BackupImportReqDTO reqDTO)；getLogDates()；downloadLog(@RequestParam("date") String date)。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.*、com.feijimiao.xianyuassistant.service.DataBackupService、com.feijimiao.xianyuassistant.service.bo.*。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.core.io.FileSystemResource、org.springframework.core.io.Resource、org.springframework.http.HttpHeaders、org.springframework.http.MediaType、org.springframework.http.ResponseEntity、org.springframework.web.bind.annotation.*。
- Web 映射注解：RequestMapping、PostMapping、GetMapping。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/DataPanelController.java

- 主类型：DataPanelController
- 包：com.feijimiao.xianyuassistant.controller
- 规模：257 行；文件大小 11207 字节。
- 职责判断：Spring MVC 接入层，负责参数接收、鉴权边界调用和结果封装。
- 注解：@Slf4j、@RestController、@RequestMapping("/api/data-panel")、@CrossOrigin(origins = "*")、@Autowired、@PostMapping("/stats")、@PostMapping("/trend")、@GetMapping("/realtimeRevenue")、@lombok.Data、@PostMapping("/salesRevenue")。
- 显式方法：getDataPanelStats(@RequestBody(required = false) StatsReq req)；getDataPanelTrend()；getRealtimeRevenue()；getSalesRevenue(@RequestBody SalesRevenueReq req)；buildDailyData(LocalDate startDate, LocalDate endDate, List<String> labels, List<Double> values)；buildWeeklyData(LocalDate startDate, LocalDate endDate, List<String> labels, List<Double> values)；buildMonthlyData(LocalDate startDate, LocalDate endDate, List<String> labels, List<Double> values)；buildQuarterlyData(LocalDate startDate, LocalDate endDate, List<String> labels, List<Double> values)。
- 项目内依赖：com.feijimiao.xianyuassistant.cache.CacheService、com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.DataPanelStatsRespDTO、com.feijimiao.xianyuassistant.controller.dto.DataPanelTrendRespDTO、com.feijimiao.xianyuassistant.controller.dto.SalesRevenueRespDTO、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoReplyRecordMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.web.bind.annotation.*。
- Web 映射注解：RequestMapping、PostMapping、GetMapping。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AccountReqDTO.java

- 主类型：AccountReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：15 行；文件大小 405 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AddAccountRespDTO.java

- 主类型：AddAccountRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：12 行；文件大小 256 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AllItemsReqDTO.java

- 主类型：AllItemsReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：24 行；文件大小 413 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AllItemsRespDTO.java

- 主类型：AllItemsRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：35 行；文件大小 573 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AutoDeliveryConfigQueryReqDTO.java

- 主类型：AutoDeliveryConfigQueryReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：25 行；文件大小 502 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data、@NotNull(message = "闲鱼账号ID不能为空")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data、jakarta.validation.constraints.NotNull。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AutoDeliveryConfigReqDTO.java

- 主类型：AutoDeliveryConfigReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：60 行；文件大小 1320 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data、@NotNull(message = "闲鱼账号ID不能为空")、@NotNull(message = "闲鱼商品ID不能为空")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data、jakarta.validation.constraints.NotNull。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AutoDeliveryConfigRespDTO.java

- 主类型：AutoDeliveryConfigRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：73 行；文件大小 1401 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AutoDeliveryRecordDTO.java

- 主类型：AutoDeliveryRecordDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：63 行；文件大小 1083 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AutoDeliveryRecordReqDTO.java

- 主类型：AutoDeliveryRecordReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：35 行；文件大小 666 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/AutoDeliveryRecordRespDTO.java

- 主类型：AutoDeliveryRecordRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：31 行；文件大小 520 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/BackupExportReqDTO.java

- 主类型：BackupExportReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：10 行；文件大小 186 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/BackupExportRespDTO.java

- 主类型：BackupExportRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：8 行；文件大小 156 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/BackupImportReqDTO.java

- 主类型：BackupImportReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：11 行；文件大小 216 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/BackupImportRespDTO.java

- 主类型：BackupImportRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：12 行；文件大小 253 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/BackupModuleRespDTO.java

- 主类型：BackupModuleRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：11 行；文件大小 215 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/ChangePasswordReqDTO.java

- 主类型：ChangePasswordReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：15 行；文件大小 305 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/ChatWithAIReqDTO.java

- 主类型：ChatWithAIReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：20 行；文件大小 323 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/CheckUserExistsRespDTO.java

- 主类型：CheckUserExistsRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：13 行；文件大小 245 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/ConfirmShipmentReqDTO.java

- 主类型：ConfirmShipmentReqDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
- 规模：13 行；文件大小 265 字节。
- 职责判断：HTTP 接口的数据传输对象，定义请求或响应的序列化边界。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/controller/dto/CurrentUserRespDTO.java

- 主类型：CurrentUserRespDTO
- 包：com.feijimiao.xianyuassistant.controller.dto
