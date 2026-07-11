package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 登录Token实体类
 * @author IAMLZY
 * @date 2026/4/22
 */
@Data
@Document(collection = "sys_login_token")
public class SysLoginToken {

    @Id
    private Long id;

    /** 关联用户ID */
    @Indexed
    private Long userId;

    /** JWT Token */
    @Indexed
    private String token;

    /** 设备标识 */
    private String deviceId;

    /** 登录IP */
    private String loginIp;

    /** 过期时间 */
    @Indexed
    private String expireTime;

    /** 创建时间 */
    private String createdTime;

    /** 更新时间 */
    private String updatedTime;
}
