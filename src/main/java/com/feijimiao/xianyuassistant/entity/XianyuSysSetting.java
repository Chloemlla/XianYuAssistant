package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 系统配置实体类
 * @author IAMLZY
 * @date 2026/4/22
 */
@Data
@Document(collection = "xianyu_sys_setting")
public class XianyuSysSetting {

    @Id
    private Long id;

    /** 配置键 */
    @Indexed(unique = true)
    private String settingKey;

    /** 配置值 */
    private String settingValue;

    /** 配置描述 */
    private String settingDesc;

    /** 创建时间 */
    private String createdTime;

    /** 更新时间 */
    private String updatedTime;
}
