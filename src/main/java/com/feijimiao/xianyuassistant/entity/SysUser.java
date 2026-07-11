package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 系统用户实体类
 * @author IAMLZY
 * @date 2026/4/22
 */
@Data
@Document(collection = "sys_user")
public class SysUser {

    @Id
    private Long id;

    /** 用户名 */
    @Indexed(unique = true)
    private String username;

    /** 密码（BCrypt加密） */
    private String password;

    /** 状态 1:正常 0:禁用 */
    private Integer status;

    /** 最后登录时间 */
    private String lastLoginTime;

    /** 最后登录IP */
    private String lastLoginIp;

    /** 创建时间 */
    private String createdTime;

    /** 更新时间 */
    private String updatedTime;
}
