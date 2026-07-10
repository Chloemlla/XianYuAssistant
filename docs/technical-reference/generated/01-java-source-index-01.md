# Java 源码逐文件技术索引（第 1 部分）

> 本章由静态文档生成器从当前受版本控制源码提取；它描述代码事实，不代表运行时验证结果。

## src/main/java/com/feijimiao/xianyuassistant/annotation/NoAuth.java

- 主类型：未显式声明
- 包：com.feijimiao.xianyuassistant.annotation
- 规模：19 行；文件大小 516 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：@Target({ElementType.METHOD, ElementType.TYPE})、@Retention(RetentionPolicy.RUNTIME)、@Documented。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/backup/DataBackupHandler.java

- 主类型：DataBackupHandler
- 包：com.feijimiao.xianyuassistant.backup
- 规模：18 行；文件大小 422 字节。
- 职责判断：数据导入导出及模块化备份处理器。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/backup/handler/AccountBackupHandler.java

- 主类型：AccountBackupHandler
- 包：com.feijimiao.xianyuassistant.backup.handler
- 规模：153 行；文件大小 6810 字节。
- 职责判断：数据导入导出及模块化备份处理器。
- 注解：@Slf4j、@Component、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getModuleKey()；getModuleName()；exportData()；importData(Map<String, Object> data, Map<String, Object> context)。
- 项目内依赖：com.feijimiao.xianyuassistant.backup.DataBackupHandler、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuCookie、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuCookieMapper。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/backup/handler/AutoDeliveryBackupHandler.java

- 主类型：AutoDeliveryBackupHandler
- 包：com.feijimiao.xianyuassistant.backup.handler
- 规模：124 行；文件大小 5737 字节。
- 职责判断：数据导入导出及模块化备份处理器。
- 注解：@Slf4j、@Component、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getModuleKey()；getModuleName()；exportData()；importData(Map<String, Object> data, Map<String, Object> context)。
- 项目内依赖：com.feijimiao.xianyuassistant.backup.DataBackupHandler、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsAutoDeliveryConfigMapper。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/backup/handler/AutoReplyBackupHandler.java

- 主类型：AutoReplyBackupHandler
- 包：com.feijimiao.xianyuassistant.backup.handler
- 规模：105 行；文件大小 4702 字节。
- 职责判断：数据导入导出及模块化备份处理器。
- 注解：@Slf4j、@Component、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getModuleKey()；getModuleName()；exportData()；importData(Map<String, Object> data, Map<String, Object> context)。
- 项目内依赖：com.feijimiao.xianyuassistant.backup.DataBackupHandler。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.jdbc.core.JdbcTemplate、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：xianyu_goods_config、xianyu_account。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/backup/handler/GoodsBackupHandler.java

- 主类型：GoodsBackupHandler
- 包：com.feijimiao.xianyuassistant.backup.handler
- 规模：118 行；文件大小 4746 字节。
- 职责判断：数据导入导出及模块化备份处理器。
- 注解：@Slf4j、@Component、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getModuleKey()；getModuleName()；exportData()；importData(Map<String, Object> data, Map<String, Object> context)。
- 项目内依赖：com.feijimiao.xianyuassistant.backup.DataBackupHandler、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuGoodsInfoMapper。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/backup/handler/KamiBackupHandler.java

- 主类型：KamiBackupHandler
- 包：com.feijimiao.xianyuassistant.backup.handler
- 规模：181 行；文件大小 8181 字节。
- 职责判断：数据导入导出及模块化备份处理器。
- 注解：@Slf4j、@Component、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getModuleKey()；getModuleName()；exportData()；importData(Map<String, Object> data, Map<String, Object> context)。
- 项目内依赖：com.feijimiao.xianyuassistant.backup.DataBackupHandler、com.feijimiao.xianyuassistant.entity.XianyuAccount、com.feijimiao.xianyuassistant.entity.XianyuKamiConfig、com.feijimiao.xianyuassistant.entity.XianyuKamiItem、com.feijimiao.xianyuassistant.mapper.XianyuAccountMapper、com.feijimiao.xianyuassistant.mapper.XianyuKamiConfigMapper、com.feijimiao.xianyuassistant.mapper.XianyuKamiItemMapper。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/backup/handler/SystemSettingBackupHandler.java

- 主类型：SystemSettingBackupHandler
- 包：com.feijimiao.xianyuassistant.backup.handler
- 规模：86 行；文件大小 3467 字节。
- 职责判断：数据导入导出及模块化备份处理器。
- 注解：@Slf4j、@Component、@Autowired、@Override、@SuppressWarnings("unchecked")。
- 显式方法：getModuleKey()；getModuleName()；exportData()；importData(Map<String, Object> data, Map<String, Object> context)。
- 项目内依赖：com.feijimiao.xianyuassistant.backup.DataBackupHandler、com.feijimiao.xianyuassistant.entity.XianyuSysSetting、com.feijimiao.xianyuassistant.mapper.XianyuSysSettingMapper。
- 主要外部依赖：com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper、lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/cache/CacheService.java

- 主类型：CacheService
- 包：com.feijimiao.xianyuassistant.cache
- 规模：58 行；文件大小 1220 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/cache/LocalMapCacheServiceImpl.java

- 主类型：LocalMapCacheServiceImpl
- 包：com.feijimiao.xianyuassistant.cache
- 规模：143 行；文件大小 3963 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：@Slf4j、@Service、@Override、@SuppressWarnings("unchecked")。
- 显式方法：put(String key, Object value)；put(String key, Object value, long timeout, TimeUnit unit)；get(String key, Class<T> clazz)；get(String key)；remove(String key)；containsKey(String key)；increment(String key)；expire(String key, long timeout, TimeUnit unit)；getExpire(String key)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.stereotype.Service。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/common/ResultObject.java

- 主类型：ResultObject<T>
- 包：com.feijimiao.xianyuassistant.common
- 规模：135 行；文件大小 3206 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：@Override。
- 显式方法：success(T data)；success(T data, String message)；failed(String message)；failed(Integer code, String message)；validateFailed(String message)；unauthorized(T data)；forbidden(T data)；getCode()；setCode(Integer code)；getMsg()；setMsg(String msg)；getData()；setData(T data)；toString()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/AsyncConfig.java

- 主类型：AsyncConfig
- 包：com.feijimiao.xianyuassistant.config
- 规模：50 行；文件大小 1498 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Configuration、@EnableAsync、@Bean(name = "taskExecutor")。
- 显式方法：taskExecutor()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：org.springframework.context.annotation.Bean、org.springframework.context.annotation.Configuration、org.springframework.scheduling.annotation.EnableAsync、org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/CustomLocalDateTimeTypeHandler.java

- 主类型：CustomLocalDateTimeTypeHandler
- 包：com.feijimiao.xianyuassistant.config
- 规模：36 行；文件大小 1379 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Override。
- 显式方法：setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType)；getNullableResult(ResultSet rs, String columnName)；getNullableResult(ResultSet rs, int columnIndex)；getNullableResult(CallableStatement cs, int columnIndex)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：org.apache.ibatis.type.BaseTypeHandler、org.apache.ibatis.type.JdbcType。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/DatabaseConfig.java

- 主类型：DatabaseConfig
- 包：com.feijimiao.xianyuassistant.config
- 规模：219 行；文件大小 7959 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Slf4j、@Configuration、@Value("${spring.datasource.url:jdbc:sqlite:xianyu_assistant.db}")、@Bean。
- 显式方法：dataSource()；initDatabase(DataSource dataSource)；splitSqlStatements(String sql)；removeComments(String sql)；verifyTables(DataSource dataSource)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Value、org.springframework.context.annotation.Bean、org.springframework.context.annotation.Configuration、org.springframework.core.io.ClassPathResource、org.springframework.jdbc.datasource.DriverManagerDataSource、org.springframework.util.FileCopyUtils。
- Web 映射注解：无。
- 持久化表线索：sqlite_master。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/DatabaseInitListener.java

- 主类型：DatabaseInitListener
- 包：com.feijimiao.xianyuassistant.config
- 规模：398 行；文件大小 15371 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Slf4j、@Component、@Autowired、@Override。
- 显式方法：onApplicationEvent(ApplicationReadyEvent event)；checkAndCreateTables(Statement stmt, SqlSchemaParser.SchemaDefinition schema)；checkAndAddColumns(Statement stmt, SqlSchemaParser.SchemaDefinition schema)；checkAndCreateIndexes(Statement stmt, SqlSchemaParser.SchemaDefinition schema)；checkAndCreateTriggers(Statement stmt, SqlSchemaParser.SchemaDefinition schema)；verifyDatabase(Statement stmt)；tableExists(Statement stmt, String tableName)；getTableColumns(Statement stmt, String tableName)；printAccessUrl()；getAvailableIpAddresses()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.beans.factory.annotation.Autowired、org.springframework.boot.context.event.ApplicationReadyEvent、org.springframework.context.ApplicationListener、org.springframework.core.env.Environment、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：sqlite_master。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/JacksonConfig.java

- 主类型：JacksonConfig
- 包：com.feijimiao.xianyuassistant.config
- 规模：26 行；文件大小 1160 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Configuration、@Bean。
- 显式方法：jacksonCustomizer()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.fasterxml.jackson.databind.ser.std.ToStringSerializer、com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer、com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer、org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer、org.springframework.context.annotation.Bean、org.springframework.context.annotation.Configuration。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/MybatisConfig.java

- 主类型：MybatisConfig
- 包：com.feijimiao.xianyuassistant.config
- 规模：33 行；文件大小 1091 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Configuration、@Autowired、@PostConstruct。
- 显式方法：registerTypeHandlers()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：jakarta.annotation.PostConstruct、org.apache.ibatis.session.SqlSessionFactory、org.apache.ibatis.type.BaseTypeHandler、org.apache.ibatis.type.JdbcType、org.apache.ibatis.type.TypeHandlerRegistry、org.springframework.beans.factory.annotation.Autowired、org.springframework.context.annotation.Configuration。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/MybatisPlusConfig.java

- 主类型：MybatisPlusConfig
- 包：com.feijimiao.xianyuassistant.config
- 规模：24 行；文件大小 782 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Configuration、@Bean。
- 显式方法：mybatisPlusInterceptor()。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：com.baomidou.mybatisplus.annotation.DbType、com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor、com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor、org.springframework.context.annotation.Bean、org.springframework.context.annotation.Configuration。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/PlaywrightManager.java

- 主类型：PlaywrightManager
- 包：com.feijimiao.xianyuassistant.config
- 规模：211 行；文件大小 7781 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Slf4j、@Component、@PostConstruct、@PreDestroy。
- 显式方法：getJarDirectory()；init()；createContext()；ensureBrowserReady()；doInit()；rebuild()；closeQuietly()；destroy()；isInitialized()；cleanTempFiles()；deleteDirectory(File directory)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：jakarta.annotation.PostConstruct、jakarta.annotation.PreDestroy、lombok.extern.slf4j.Slf4j、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/rag/AIConfig.java

- 主类型：AIConfig
- 包：com.feijimiao.xianyuassistant.config.rag
- 规模：18 行；文件大小 582 字节。
- 职责判断：AI 对话客户端和向量存储的动态配置。
- 注解：@Configuration。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：org.springframework.context.annotation.Configuration。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/rag/DynamicAIChatClientManager.java

- 主类型：DynamicAIChatClientManager
- 包：com.feijimiao.xianyuassistant.config.rag
- 规模：254 行；文件大小 9380 字节。
- 职责判断：AI 对话客户端和向量存储的动态配置。
- 注解：@Slf4j、@Component、@Autowired、@Lazy、@Value("${ai.enabled:false}")。
- 显式方法：getChatClient()；isAvailable()；getStatusInfo()；forceRebuild()；buildChatClient(String apiKey, String baseUrl, String model)；getSettingValue(String key)；safeEquals(String a, String b)；isEnabled()；setEnabled(boolean enabled)；setAvailable(boolean available)；isApiKeyConfigured()；setApiKeyConfigured(boolean apiKeyConfigured)；getMessage()；setMessage(String message)；getBaseUrl()；setBaseUrl(String baseUrl)；getModel()；setModel(String model)。
- 项目内依赖：com.feijimiao.xianyuassistant.service.SysSettingService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.ai.chat.client.ChatClient、org.springframework.ai.model.SimpleApiKey、org.springframework.ai.openai.OpenAiChatModel、org.springframework.ai.openai.OpenAiChatOptions、org.springframework.ai.openai.api.OpenAiApi、org.springframework.beans.factory.annotation.Autowired、org.springframework.beans.factory.annotation.Value、org.springframework.context.annotation.Lazy、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/rag/DynamicVectorStoreManager.java

- 主类型：DynamicVectorStoreManager
- 包：com.feijimiao.xianyuassistant.config.rag
- 规模：242 行；文件大小 9458 字节。
- 职责判断：AI 对话客户端和向量存储的动态配置。
- 注解：@Slf4j、@Component、@Value("${ai.vectorstore.simple.file-path:dbdata/vectorstore.json}")、@Autowired。
- 显式方法：getVectorStore()；forceRebuild()；saveToFile()；buildVectorStore(String apiKey, String baseUrl, String model)；getSettingValue(String key)；safeEquals(String a, String b)。
- 项目内依赖：com.feijimiao.xianyuassistant.service.SysSettingService。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.ai.document.MetadataMode、org.springframework.ai.model.SimpleApiKey、org.springframework.ai.openai.OpenAiEmbeddingModel、org.springframework.ai.openai.OpenAiEmbeddingOptions、org.springframework.ai.openai.api.OpenAiApi、org.springframework.ai.vectorstore.SimpleVectorStore、org.springframework.ai.vectorstore.VectorStore、org.springframework.beans.factory.annotation.Autowired、org.springframework.beans.factory.annotation.Value、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/rag/SimpleVectorStoreConfig.java

- 主类型：SimpleVectorStoreConfig
- 包：com.feijimiao.xianyuassistant.config.rag
- 规模：23 行；文件大小 729 字节。
- 职责判断：AI 对话客户端和向量存储的动态配置。
- 注解：@Slf4j、@Configuration、@ConditionalOnProperty(name = "ai.enabled", havingValue = "true")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.boot.autoconfigure.condition.ConditionalOnProperty、org.springframework.context.annotation.Configuration。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/SqlSchemaParser.java

- 主类型：SqlSchemaParser
- 包：com.feijimiao.xianyuassistant.config
- 规模：362 行；文件大小 12930 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Slf4j、@Component。
- 显式方法：parseSchemaFile(String schemaFilePath)；removeComments(String sql)；parseTables(String sqlContent)；parseColumns(String tableBody)；parseColumn(String columnDef)；splitByComma(String str)；parseIndexes(String sqlContent)；parseTriggers(String sqlContent)；getTables()；setTables(Map<String, TableDefinition> tables)；getIndexes()；setIndexes(Map<String, IndexDefinition> indexes)；getTriggers()；setTriggers(Map<String, TriggerDefinition> triggers)；getName()；setName(String name)；getCreateSql()；setCreateSql(String createSql)；getColumns()；setColumns(List<ColumnDefinition> columns)；getType()；setType(String type)；getConstraints()；setConstraints(String constraints)；getDefinition()；setDefinition(String definition)；getTableName()；setTableName(String tableName)；setColumns(List<String> columns)；isUnique()；setUnique(boolean unique)。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.extern.slf4j.Slf4j、org.springframework.core.io.ClassPathResource、org.springframework.stereotype.Component。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/WebMvcConfig.java

- 主类型：WebMvcConfig
- 包：com.feijimiao.xianyuassistant.config
- 规模：58 行；文件大小 2559 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Configuration、@Autowired、@Override。
- 显式方法：addInterceptors(InterceptorRegistry registry)；addResourceHandlers(ResourceHandlerRegistry registry)；getResource(String resourcePath, Resource location)。
- 项目内依赖：com.feijimiao.xianyuassistant.interceptor.AuthInterceptor。
- 主要外部依赖：org.springframework.beans.factory.annotation.Autowired、org.springframework.context.annotation.Configuration、org.springframework.core.io.ClassPathResource、org.springframework.core.io.Resource、org.springframework.web.servlet.config.annotation.InterceptorRegistry、org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry、org.springframework.web.servlet.config.annotation.WebMvcConfigurer、org.springframework.web.servlet.resource.PathResourceResolver。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/config/WebSocketConfig.java

- 主类型：WebSocketConfig
- 包：com.feijimiao.xianyuassistant.config
- 规模：102 行；文件大小 2597 字节。
- 职责判断：Spring 容器、数据库、序列化、异步或 Web 基础设施配置。
- 注解：@Data、@Configuration、@ConfigurationProperties(prefix = "websocket")。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：lombok.Data、org.springframework.boot.context.properties.ConfigurationProperties、org.springframework.context.annotation.Configuration。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/constants/OperationConstants.java

- 主类型：OperationConstants
- 包：com.feijimiao.xianyuassistant.constants
- 规模：96 行；文件大小 3163 字节。
- 职责判断：项目基础类型；具体职责由声明、注解和依赖共同确定。
- 注解：无类级或成员级注解被提取。
- 显式方法：未提取到常规方法签名，可能是标记接口、纯字段对象或 Lombok 数据类型。
- 项目内依赖：无显式项目内 import。
- 主要外部依赖：仅 JDK 类型或无显式外部 import。
- Web 映射注解：无。
- 持久化表线索：无直接 SQL 或表注解线索。
- 维护提示：修改该文件时应同步检查其构造器注入对象、调用方、DTO/实体字段和异常返回约定。

## src/main/java/com/feijimiao/xianyuassistant/context/UserContext.java

