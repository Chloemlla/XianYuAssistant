# Java 源码逐文件技术索引（第 8 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuOrderMapper.java

- 主类型：XianyuOrderMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：60 行；文件大小 2444 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select、@Param("xianyuAccountId")、@Param("xyGoodsId")、@Param("orderStatus")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.controller.vo.OrderVO、com.feijimiao.xianyuassistant.entity.XianyuOrder。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、com.baomidou.mybatisplus.extension.plugins.pagination.Page、org.apache.ibatis.annotations.Mapper、org.apache.ibatis.annotations.Param、org.apache.ibatis.annotations.Select。
- Web 映射注解：无。
- 持久化表线索：xianyu_order、xianyu_account、xianyu_goods_auto_delivery_record。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuSysSettingMapper.java

- 主类型：XianyuSysSettingMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：14 行；文件大小 381 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuSysSetting。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/AccountService.java

- 主类型：AccountService
- 包：com.feijimiao.xianyuassistant.service
- 规模：149 行；文件大小 4048 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/AIService.java

- 主类型：AIService
- 包：com.feijimiao.xianyuassistant.service
- 规模：52 行；文件大小 1711 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.service.bo.RAGDataRespBO、com.feijimiao.xianyuassistant.service.bo.RAGReplyResult。
- 主要外部依赖：org.antlr.v4.runtime.TokenStream、reactor.core.publisher.Flux。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/ApiDeliveryScheduler.java

- 主类型：ApiDeliveryScheduler
- 包：com.feijimiao.xianyuassistant.service
- 规模：137 行；文件大小 5839 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：@Slf4j、@Service、@Autowired、@Scheduled(fixedDelay = 25000, initialDelay = 60000)、@SuppressWarnings("unchecked")。
- 显式方法：scheduledApiDelivery()；pollAndDeliver(Long accountId)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.scheduling.annotation.Scheduled、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/AuthService.java

- 主类型：AuthService
- 包：com.feijimiao.xianyuassistant.service
- 规模：62 行；文件大小 1272 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.service.bo.*。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/AutoDeliveryConfigService.java

- 主类型：AutoDeliveryConfigService
- 包：com.feijimiao.xianyuassistant.service
- 规模：21 行；文件大小 937 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigReqDTO、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigRespDTO、com.feijimiao.xianyuassistant.controller.dto.AutoDeliveryConfigQueryReqDTO。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/AutoDeliveryService.java

- 主类型：AutoDeliveryService
- 包：com.feijimiao.xianyuassistant.service
- 规模：86 行；文件大小 2926 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.controller.dto.TriggerAutoDeliveryReqDTO、com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/AutoReplyDelayService.java

- 主类型：AutoReplyDelayService
- 包：com.feijimiao.xianyuassistant.service
- 规模：47 行；文件大小 1263 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/AutoReplyService.java

- 主类型：AutoReplyService
- 包：com.feijimiao.xianyuassistant.service
- 规模：37 行；文件大小 904 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/BackupExportReqBO.java

- 主类型：BackupExportReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：10 行；文件大小 181 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/BackupExportRespBO.java

- 主类型：BackupExportRespBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：8 行；文件大小 151 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/BackupImportReqBO.java

- 主类型：BackupImportReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：9 行；文件大小 195 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/BackupImportRespBO.java

- 主类型：BackupImportRespBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：10 行；文件大小 232 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/BackupModuleRespBO.java

- 主类型：BackupModuleRespBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：9 行；文件大小 184 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/ChangePasswordReqBO.java

- 主类型：ChangePasswordReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：15 行；文件大小 288 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/CheckUserExistsRespBO.java

- 主类型：CheckUserExistsRespBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：13 行；文件大小 239 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/GetSettingReqBO.java

- 主类型：GetSettingReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：13 行；文件大小 224 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/GetSettingRespBO.java

- 主类型：GetSettingRespBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：15 行；文件大小 292 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/LoginReqBO.java

- 主类型：LoginReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：16 行；文件大小 295 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/LoginRespBO.java

- 主类型：LoginRespBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：14 行；文件大小 239 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/RAGDataRespBO.java

- 主类型：RAGDataRespBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：21 行；文件大小 357 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/RAGReplyResult.java

- 主类型：RAGReplyResult
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：32 行；文件大小 692 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/RegisterReqBO.java

- 主类型：RegisterReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：14 行；文件大小 244 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/SaveSettingReqBO.java

- 主类型：SaveSettingReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：15 行；文件大小 292 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/bo/TriggerAutoDeliveryReqBO.java

- 主类型：TriggerAutoDeliveryReqBO
- 包：com.feijimiao.xianyuassistant.service.bo
- 规模：24 行；文件大小 384 字节。
- 职责判断：服务层业务对象，承载跨方法业务数据。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/ChatMessageService.java

- 主类型：ChatMessageService
- 包：com.feijimiao.xianyuassistant.service
- 规模：51 行；文件大小 1610 字节。
- 职责判断：业务服务契约或核心领域服务。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.entity.XianyuChatMessage、com.feijimiao.xianyuassistant.controller.dto.MsgContextReqDTO、com.feijimiao.xianyuassistant.controller.dto.MsgListReqDTO、com.feijimiao.xianyuassistant.controller.dto.MsgListRespDTO。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/service/CookieRefreshService.java

