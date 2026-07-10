# Java 源码逐文件技术索引（第 7 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/event/chatMessageEvent/lister/ChatMessageEventSaveListener.java

- 主类型：ChatMessageEventSaveListener
- 包：com.feijimiao.xianyuassistant.event.chatMessageEvent.lister
- 规模：85 行；文件大小 3688 字节。
- 职责判断：领域事件及监听器，用于拆分消息到达后的并行业务处理。
- 注解：@Slf4j、@Component、@Autowired、@Async、@EventListener。
- 显式方法：handleChatMessageReceived(ChatMessageReceivedEvent event)。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuChatMessage、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageData、com.feijimiao.xianyuassistant.event.chatMessageEvent.ChatMessageReceivedEvent、com.feijimiao.xianyuassistant.mapper.XianyuChatMessageMapper。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.event.EventListener、org.springframework.scheduling.annotation.Async、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/exception/BusinessException.java

- 主类型：BusinessException
- 包：com.feijimiao.xianyuassistant.exception
- 规模：38 行；文件大小 898 字节。
- 职责判断：业务异常类型或全局异常转换。
- 注解：无类级或成员级注解被提取。
- 显式方法：getCode()；setCode(Integer code)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/exception/CaptchaRequiredException.java

- 主类型：CaptchaRequiredException
- 包：com.feijimiao.xianyuassistant.exception
- 规模：18 行；文件大小 436 字节。
- 职责判断：业务异常类型或全局异常转换。
- 注解：无类级或成员级注解被提取。
- 显式方法：getCaptchaUrl()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/exception/CookieExpiredException.java

- 主类型：CookieExpiredException
- 包：com.feijimiao.xianyuassistant.exception
- 规模：11 行；文件大小 243 字节。
- 职责判断：业务异常类型或全局异常转换。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/exception/CookieNotFoundException.java

- 主类型：CookieNotFoundException
- 包：com.feijimiao.xianyuassistant.exception
- 规模：11 行；文件大小 248 字节。
- 职责判断：业务异常类型或全局异常转换。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/exception/GlobalExceptionHandler.java

- 主类型：GlobalExceptionHandler
- 包：com.feijimiao.xianyuassistant.exception
- 规模：49 行；文件大小 1556 字节。
- 职责判断：业务异常类型或全局异常转换。
- 注解：@RestControllerAdvice、@ExceptionHandler(BusinessException.class)、@ExceptionHandler(CaptchaRequiredException.class)、@ExceptionHandler(Exception.class)。
- 显式方法：handleBusinessException(BusinessException e)；handleCaptchaRequiredException(CaptchaRequiredException e)；handleException(Exception e)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：org.springframework.web.bind.annotation.ExceptionHandler、org.springframework.web.bind.annotation.RestControllerAdvice。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/exception/TokenInvalidException.java

- 主类型：TokenInvalidException
- 包：com.feijimiao.xianyuassistant.exception
- 规模：11 行；文件大小 250 字节。
- 职责判断：业务异常类型或全局异常转换。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/interceptor/AuthInterceptor.java

- 主类型：AuthInterceptor
- 包：com.feijimiao.xianyuassistant.interceptor
- 规模：95 行；文件大小 3554 字节。
- 职责判断：HTTP 请求拦截与身份上下文建立。
- 注解：@Slf4j、@Component、@Autowired、@Override。
- 显式方法：preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)；afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)；writeUnauthorized(HttpServletResponse response, String message)。
- 项目内依赖：com.feijimiao.xianyuassistant.annotation.NoAuth、com.feijimiao.xianyuassistant.common.ResultObject、com.feijimiao.xianyuassistant.service.AuthService、com.feijimiao.xianyuassistant.util.JwtUtil。
- 主要外部依赖：jakarta.servlet.http.HttpServletRequest、jakarta.servlet.http.HttpServletResponse、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component、org.springframework.web.method.HandlerMethod、org.springframework.web.servlet.HandlerInterceptor。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/SysLoginTokenMapper.java

- 主类型：SysLoginTokenMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：14 行；文件大小 372 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.SysLoginToken。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/SysUserMapper.java

- 主类型：SysUserMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：14 行；文件大小 354 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.SysUser。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuAccountMapper.java

- 主类型：XianyuAccountMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：12 行；文件大小 333 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuAccount。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuChatMessageMapper.java

- 主类型：XianyuChatMessageMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：135 行；文件大小 5545 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Insert、@Options(useGeneratedKeys = true, keyProperty = "id")、@Select、@Param("pnmId")、@Param("limit")、@Param("offset")、@Delete("DELETE FROM xianyu_chat_message WHERE xianyu_account_id = #{accountId}")、@Param("xyGoodsId")、@Param("senderUserId")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuChatMessage。
- 主要外部依赖：org.apache.ibatis.annotations.*。
- Web 映射注解：无。
- 持久化表线索：xianyu_chat_message。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuCookieMapper.java

- 主类型：XianyuCookieMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：12 行；文件大小 331 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuCookie。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuGoodsAutoDeliveryConfigMapper.java

- 主类型：XianyuGoodsAutoDeliveryConfigMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：53 行；文件大小 3919 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select、@Param("xyGoodsId")、@Param("skuId")、@Delete("DELETE FROM xianyu_goods_auto_delivery_config WHERE xianyu_account_id = #{xianyuAccountId}")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Delete、org.apache.ibatis.annotations.Mapper、org.apache.ibatis.annotations.Param、org.apache.ibatis.annotations.Select。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_auto_delivery_config。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuGoodsAutoReplyRecordMapper.java

- 主类型：XianyuGoodsAutoReplyRecordMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：72 行；文件大小 3572 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Insert("INSERT INTO xianyu_goods_auto_reply_record (xianyu_account_id, xianyu_goods_id, xy_goods_id, s_id, pnm_id, buyer_user_id, buyer_user_name, buyer_message, reply_content, reply_type, matched_keyword, trigger_context, state)、@Options(useGeneratedKeys = true, keyProperty = "id")、@Update("UPDATE xianyu_goods_auto_reply_record SET state = #{state}, reply_content = #{replyContent} WHERE id = #{id}")、@Update("UPDATE xianyu_goods_auto_reply_record SET trigger_context = #{triggerContext} WHERE id = #{id}")、@Select("SELECT * FROM xianyu_goods_auto_reply_record WHERE xianyu_account_id = #{accountId} ORDER BY create_time DESC")、@Select("SELECT * FROM xianyu_goods_auto_reply_record WHERE xianyu_account_id = #{accountId} AND s_id = #{sId} ORDER BY create_time DESC LIMIT 1")、@Delete("DELETE FROM xianyu_goods_auto_reply_record WHERE xianyu_account_id = #{accountId}")、@Select("SELECT * FROM xianyu_goods_auto_reply_record WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId} ORDER BY create_time DESC LIMIT #{limit} OFFSET #{offset}")、@Select("SELECT COUNT(*)。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoReplyRecord。
- 主要外部依赖：org.apache.ibatis.annotations.*。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_auto_reply_record。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuGoodsConfigMapper.java

- 主类型：XianyuGoodsConfigMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：52 行；文件大小 2575 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select("SELECT * FROM xianyu_goods_config WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId}")、@Select("SELECT * FROM xianyu_goods_config WHERE xianyu_account_id = #{accountId}")、@Insert("INSERT INTO xianyu_goods_config (xianyu_account_id, xianyu_goods_id, xy_goods_id, xianyu_auto_delivery_on, xianyu_auto_reply_on, xianyu_auto_reply_context_on, xianyu_keyword_reply_on, human_intervention_on, human_intervention_minutes, fixed_material)、@Options(useGeneratedKeys = true, keyProperty = "id")、@Update、@Update("UPDATE xianyu_goods_config SET fixed_material = #{fixedMaterial} WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId}")、@Delete("DELETE FROM xianyu_goods_config WHERE xianyu_account_id = #{accountId}")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig。
- 主要外部依赖：org.apache.ibatis.annotations.*。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_config。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuGoodsInfoMapper.java

- 主类型：XianyuGoodsInfoMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：12 行；文件大小 345 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuGoodsOrderMapper.java

- 主类型：XianyuGoodsOrderMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：209 行；文件大小 12738 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Insert("INSERT INTO xianyu_goods_order (xianyu_account_id, xianyu_goods_id, xy_goods_id, pnm_id, order_id, buyer_user_id, buyer_user_name, sid, content, state, fail_reason, confirm_state, goods_title, sku_name, order_create_time, pay_success_time, consign_time, total_price, buy_num)、@Options(useGeneratedKeys = true, keyProperty = "id")、@Select("SELECT * FROM xianyu_goods_order WHERE xianyu_account_id = #{accountId} ORDER BY create_time DESC")、@Delete("DELETE FROM xianyu_goods_order WHERE xianyu_account_id = #{accountId}")、@Select、@Results、@Result(property = "id", column = "id")、@Result(property = "xianyuAccountId", column = "xianyu_account_id")、@Result(property = "xianyuGoodsId", column = "xianyu_goods_id")、@Result(property = "xyGoodsId", column = "xy_goods_id")、@Result(property = "pnmId", column = "pnm_id")、@Result(property = "orderId", column = "order_id")、@Result(property = "buyerUserId", column = "buyer_user_id")、@Result(property = "buyerUserName", column = "buyer_user_name")、@Result(property = "sid", column = "sid")、@Result(property = "content", column = "content")、@Result(property = "state", column = "state")、@Result(property = "failReason", column = "fail_reason")、@Result(property = "confirmState", column = "confirm_state")、@Result(property = "createTime", column = "create_time")、@Result(property = "goodsTitle", column = "goods_title")、@Result(property = "skuName", column = "sku_name")、@Result(property = "orderCreateTime", column = "order_create_time")、@Result(property = "paySuccessTime", column = "pay_success_time")、@Result(property = "consignTime", column = "consign_time")、@Result(property = "totalPrice", column = "total_price")、@Result(property = "buyNum", column = "buy_num")、@Param("accountId")、@Param("xyGoodsId")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder。
- 主要外部依赖：org.apache.ibatis.annotations.*。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_order、xianyu_goods。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuGoodsSkuMapper.java

- 主类型：XianyuGoodsSkuMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：9 行；文件大小 303 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSku。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuGoodsSkuPropertyMapper.java

- 主类型：XianyuGoodsSkuPropertyMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：9 行；文件大小 327 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuGoodsSkuProperty。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuHumanInterventionRecordMapper.java

- 主类型：XianyuHumanInterventionRecordMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：21 行；文件大小 940 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Insert("INSERT INTO xianyu_human_intervention_record (xianyu_account_id, xy_goods_id, s_id, end_time)、@Options(useGeneratedKeys = true, keyProperty = "id")、@Select("SELECT * FROM xianyu_human_intervention_record WHERE s_id = #{sId} AND end_time &gt; datetime('now', 'localtime')、@Delete("DELETE FROM xianyu_human_intervention_record WHERE end_time &lt; datetime('now', 'localtime')。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuHumanInterventionRecord。
- 主要外部依赖：org.apache.ibatis.annotations.*。
- Web 映射注解：无。
- 持久化表线索：xianyu_human_intervention_record。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuKamiConfigMapper.java

- 主类型：XianyuKamiConfigMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：16 行；文件大小 641 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select("SELECT * FROM xianyu_kami_config WHERE xianyu_account_id = #{xianyuAccountId} ORDER BY create_time DESC")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuKamiConfig。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper、org.apache.ibatis.annotations.Param、org.apache.ibatis.annotations.Select。
- Web 映射注解：无。
- 持久化表线索：xianyu_kami_config。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuKamiItemMapper.java

- 主类型：XianyuKamiItemMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：59 行；文件大小 3144 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select("SELECT * FROM xianyu_kami_item WHERE kami_config_id = #{kamiConfigId} AND status = 0 ORDER BY sort_order ASC LIMIT 1")、@Select("SELECT * FROM xianyu_kami_item WHERE kami_config_id = #{kamiConfigId} AND status = 0 ORDER BY RANDOM()、@Select("SELECT * FROM xianyu_kami_item WHERE kami_config_id = #{kamiConfigId} ORDER BY sort_order ASC")、@Select、@Param("kamiConfigId")、@Param("status")、@Param("keyword")、@Select("SELECT COUNT(*)、@Update("UPDATE xianyu_kami_item SET status = 1, order_id = #{orderId}, used_time = datetime('now', 'localtime')、@Update("UPDATE xianyu_kami_item SET status = 0, order_id = NULL, used_time = NULL WHERE id = #{id} AND status = 1")、@Select("SELECT * FROM xianyu_kami_item WHERE kami_config_id = #{kamiConfigId} AND status = #{status} ORDER BY sort_order ASC")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuKamiItem。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper、org.apache.ibatis.annotations.Param、org.apache.ibatis.annotations.Select、org.apache.ibatis.annotations.Update。
- Web 映射注解：无。
- 持久化表线索：xianyu_kami_item。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuKamiUsageRecordMapper.java

- 主类型：XianyuKamiUsageRecordMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：9 行；文件大小 324 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuKamiUsageRecord。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Mapper。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuKeywordReplyContentMapper.java

- 主类型：XianyuKeywordReplyContentMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：17 行；文件大小 667 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select("SELECT * FROM xianyu_keyword_reply_content WHERE rule_id = #{ruleId}")、@Delete("DELETE FROM xianyu_keyword_reply_content WHERE rule_id = #{ruleId}")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuKeywordReplyContent。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.*。
- Web 映射注解：无。
- 持久化表线索：xianyu_keyword_reply_content。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuKeywordReplyRuleMapper.java

- 主类型：XianyuKeywordReplyRuleMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：29 行；文件大小 2028 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select("SELECT * FROM xianyu_keyword_reply_rule WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId}")、@Select("SELECT * FROM xianyu_keyword_reply_rule WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId} AND keyword = #{keyword} AND is_fallback = 0")、@Select("SELECT * FROM xianyu_keyword_reply_rule WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId} AND is_fallback = 1")、@Select("SELECT * FROM xianyu_keyword_reply_rule WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId} AND match_mode = 2 AND keyword = #{message} AND is_fallback = 0")、@Select("SELECT * FROM xianyu_keyword_reply_rule WHERE xianyu_account_id = #{accountId} AND xy_goods_id = #{xyGoodsId} AND match_mode = 1 AND #{message} LIKE '%' || keyword || '%' AND is_fallback = 0")、@Delete("DELETE FROM xianyu_keyword_reply_rule WHERE id = #{id}")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuKeywordReplyRule。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.*。
- Web 映射注解：无。
- 持久化表线索：xianyu_keyword_reply_rule。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/mapper/XianyuOperationLogMapper.java

- 主类型：XianyuOperationLogMapper
- 包：com.feijimiao.xianyuassistant.mapper
- 规模：73 行；文件大小 2849 字节。
- 职责判断：MyBatis-Plus 数据访问接口。
- 注解：@Mapper、@Select、@Param("accountId")、@Param("operationType")、@Param("operationModule")、@Param("operationStatus")、@Param("pageSize")、@Param("offset")、@Delete("DELETE FROM xianyu_operation_log WHERE xianyu_account_id = #{accountId}")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：com.feijimiao.xianyuassistant.entity.XianyuOperationLog。
- 主要外部依赖：com.baomidou.mybatisplus.core.mapper.BaseMapper、org.apache.ibatis.annotations.Delete、org.apache.ibatis.annotations.Mapper、org.apache.ibatis.annotations.Param、org.apache.ibatis.annotations.Select。
- Web 映射注解：无。
- 持久化表线索：xianyu_operation_log。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

