# Java 源码逐文件技术索引（第 6 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/SysLoginToken.java

- 主类型：SysLoginToken
- 包：com.feijimiao.xianyuassistant.entity
- 规模：40 行；文件大小 829 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("sys_login_token")、@TableId(type = IdType.AUTO)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：sys_login_token。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/SysUser.java

- 主类型：SysUser
- 包：com.feijimiao.xianyuassistant.entity
- 规模：40 行；文件大小 864 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("sys_user")、@TableId(type = IdType.AUTO)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：sys_user。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuAccount.java

- 主类型：XianyuAccount
- 包：com.feijimiao.xianyuassistant.entity
- 规模：54 行；文件大小 1150 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_account")、@TableId(type = IdType.AUTO)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_account。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuChatMessage.java

- 主类型：XianyuChatMessage
- 包：com.feijimiao.xianyuassistant.entity
- 规模：42 行；文件大小 1742 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuCookie.java

- 主类型：XianyuCookie
- 包：com.feijimiao.xianyuassistant.entity
- 规模：67 行；文件大小 1317 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_cookie")、@TableId(type = IdType.AUTO)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_cookie。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuGoodsAutoDeliveryConfig.java

- 主类型：XianyuGoodsAutoDeliveryConfig
- 包：com.feijimiao.xianyuassistant.entity
- 规模：83 行；文件大小 1779 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_goods_auto_delivery_config")、@TableId(type = IdType.AUTO)、@TableField(fill = FieldFill.INSERT)、@TableField(fill = FieldFill.INSERT_UPDATE)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.*、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_auto_delivery_config。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuGoodsAutoReplyRecord.java

- 主类型：XianyuGoodsAutoReplyRecord
- 包：com.feijimiao.xianyuassistant.entity
- 规模：85 行；文件大小 1527 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuGoodsConfig.java

- 主类型：XianyuGoodsConfig
- 包：com.feijimiao.xianyuassistant.entity
- 规模：70 行；文件大小 1456 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuGoodsInfo.java

- 主类型：XianyuGoodsInfo
- 包：com.feijimiao.xianyuassistant.entity
- 规模：74 行；文件大小 1411 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_goods")、@TableId(type = IdType.ASSIGN_ID)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuGoodsOrder.java

- 主类型：XianyuGoodsOrder
- 包：com.feijimiao.xianyuassistant.entity
- 规模：52 行；文件大小 907 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuGoodsSku.java

- 主类型：XianyuGoodsSku
- 包：com.feijimiao.xianyuassistant.entity
- 规模：42 行；文件大小 851 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_goods_sku")、@TableId(type = IdType.ASSIGN_ID)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_sku。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuGoodsSkuProperty.java

- 主类型：XianyuGoodsSkuProperty
- 包：com.feijimiao.xianyuassistant.entity
- 规模：34 行；文件大小 744 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_goods_sku_property")、@TableId(type = IdType.ASSIGN_ID)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_sku_property。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuHumanInterventionRecord.java

- 主类型：XianyuHumanInterventionRecord
- 包：com.feijimiao.xianyuassistant.entity
- 规模：19 行；文件大小 315 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuKamiConfig.java

- 主类型：XianyuKamiConfig
- 包：com.feijimiao.xianyuassistant.entity
- 规模：36 行；文件大小 803 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_kami_config")、@TableId(type = IdType.AUTO)、@TableField(fill = FieldFill.INSERT)、@TableField(fill = FieldFill.INSERT_UPDATE)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.*、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_kami_config。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuKamiItem.java

- 主类型：XianyuKamiItem
- 包：com.feijimiao.xianyuassistant.entity
- 规模：29 行；文件大小 594 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_kami_item")、@TableId(type = IdType.AUTO)、@TableField(fill = FieldFill.INSERT)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.*、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_kami_item。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuKamiUsageRecord.java

- 主类型：XianyuKamiUsageRecord
- 包：com.feijimiao.xianyuassistant.entity
- 规模：33 行；文件大小 679 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_kami_usage_record")、@TableId(type = IdType.AUTO)、@TableField(fill = FieldFill.INSERT)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.*、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_kami_usage_record。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuKeywordReplyContent.java

- 主类型：XianyuKeywordReplyContent
- 包：com.feijimiao.xianyuassistant.entity
- 规模：16 行；文件大小 510 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@JsonSerialize(using = ToStringSerializer.class)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.fasterxml.jackson.databind.annotation.JsonSerialize、com.fasterxml.jackson.databind.ser.std.ToStringSerializer、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuKeywordReplyRule.java

- 主类型：XianyuKeywordReplyRule
- 包：com.feijimiao.xianyuassistant.entity
- 规模：18 行；文件大小 575 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@JsonSerialize(using = ToStringSerializer.class)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.fasterxml.jackson.databind.annotation.JsonSerialize、com.fasterxml.jackson.databind.ser.std.ToStringSerializer、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuOperationLog.java

- 主类型：XianyuOperationLog
- 包：com.feijimiao.xianyuassistant.entity
- 规模：87 行；文件大小 1604 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_operation_log")、@TableId(type = IdType.AUTO)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_operation_log。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuOrder.java

- 主类型：XianyuOrder
- 包：com.feijimiao.xianyuassistant.entity
- 规模：51 行；文件大小 2096 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/entity/XianyuSysSetting.java

- 主类型：XianyuSysSetting
- 包：com.feijimiao.xianyuassistant.entity
- 规模：34 行；文件大小 736 字节。
- 职责判断：MyBatis-Plus 持久化实体或领域上下文对象。
- 注解：@Data、@TableName("xianyu_sys_setting")、@TableId(type = IdType.AUTO)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.IdType、com.baomidou.mybatisplus.annotation.TableId、com.baomidou.mybatisplus.annotation.TableName、lombok.Data。
- Web 映射注解：无。
- 持久化表线索：xianyu_sys_setting。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/enums/OrderStatusEnum.java

- 主类型：OrderStatusEnum
- 包：com.feijimiao.xianyuassistant.enums
- 规模：89 行；文件大小 1951 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：@Getter。
- 显式方法：getByCode(Integer code)；getDescriptionByCode(Integer code)；isValidCode(Integer code)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Getter。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/event/chatMessageEvent/ChatMessageData.java

- 主类型：ChatMessageData
- 包：com.feijimiao.xianyuassistant.event.chatMessageEvent
- 规模：91 行；文件大小 1570 字节。
- 职责判断：领域事件及监听器，用于拆分消息到达后的并行业务处理。
- 注解：@Data。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/event/chatMessageEvent/ChatMessageReceivedEvent.java

- 主类型：ChatMessageReceivedEvent
- 包：com.feijimiao.xianyuassistant.event.chatMessageEvent
- 规模：43 行；文件大小 1397 字节。
- 职责判断：领域事件及监听器，用于拆分消息到达后的并行业务处理。
- 注解：@Getter。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Getter、org.springframework.context.ApplicationEvent。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/event/chatMessageEvent/lister/ChatMessageEventAutoDeliveryListener.java

- 主类型：ChatMessageEventAutoDeliveryListener
- 包：com.feijimiao.xianyuassistant.event.chatMessageEvent.lister
- 规模：151 行；文件大小 6765 字节。
- 职责判断：领域事件及监听器，用于拆分消息到达后的并行业务处理。
- 注解：@Slf4j、@Component、@Autowired、@Async、@EventListener。
- 显式方法：handleChatMessageReceived(ChatMessageReceivedEvent event)；isPaymentMessage(ChatMessageData message)；resolveXianyuGoodsId(Long accountId, String xyGoodsId)；createOrderRecord(Long accountId, Long xianyuGoodsId, ChatMessageData message)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageReceivedEvent、com.feijimiao.xianyuassistant.mapper.XianyuGoodsOrderMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper、com.feijimiao.xianyuassistant.service.AutoDeliveryService、com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig、com.feijimiao.xianyuassistant.mapper.XianyuGoodsConfigMapper。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.QueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.event.EventListener、org.springframework.scheduling.annotation.Async、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/event/chatMessageEvent/lister/ChatMessageEventAutoReplyListener.java

- 主类型：ChatMessageEventAutoReplyListener
- 包：com.feijimiao.xianyuassistant.event.chatMessageEvent.lister
- 规模：134 行；文件大小 6412 字节。
- 职责判断：领域事件及监听器，用于拆分消息到达后的并行业务处理。
- 注解：@Slf4j、@Component、@Autowired、@Order(10)、@Async、@EventListener。
- 显式方法：handleChatMessageReceived(ChatMessageReceivedEvent event)。
- 项目内依赖：com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageReceivedEvent、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.AutoReplyDelayService、com.feijimiao.xianyuassistant.service.AutoReplyService、com.feijimiao.xianyuassistant.service.reply.HumanTakeoverManager。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.event.EventListener、org.springframework.core.annotation.Order、org.springframework.scheduling.annotation.Async、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/event/chatMessageEvent/lister/ChatMessageEventHumanInterventionListener.java

- 主类型：ChatMessageEventHumanInterventionListener
- 包：com.feijimiao.xianyuassistant.event.chatMessageEvent.lister
- 规模：95 行；文件大小 4039 字节。
- 职责判断：领域事件及监听器，用于拆分消息到达后的并行业务处理。
- 注解：@Slf4j、@Component、@Autowired、@Order(1)、@EventListener。
- 显式方法：handleChatMessageReceived(ChatMessageReceivedEvent event)。
- 项目内依赖：com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageReceivedEvent、com.feijimiao.xianyuassistant.service.AccountService、com.feijimiao.xianyuassistant.service.AutoReplyDelayService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.event.EventListener、org.springframework.core.annotation.Order、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
