package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * 闲鱼Cookie实体类
 */
@Data
@Document(collection = "xianyu_cookie")
public class XianyuCookie {
    
    /**
     * 主键ID
     */
    @Id
    private Long id;
    
    /**
     * 关联的闲鱼账号ID
     */
    @Indexed(unique = true)
    private Long xianyuAccountId;
    
    /**
     * 完整的Cookie字符串
     */
    private String cookieText;
    
    /**
     * _m_h5_tk token（用于API签名）
     */
    private String mH5Tk;
    
    /**
     * Cookie状态 1:有效 2:过期 3:失效
     */
    @Indexed
    private Integer cookieStatus;
    
    /**
     * 过期时间（SQLite存储为TEXT）
     */
    private String expireTime;
    
    /**
     * 创建时间（SQLite存储为TEXT）
     */
    private String createdTime;
    
    /**
     * 更新时间（SQLite存储为TEXT）
     */
    private String updatedTime;
    
    /**
     * WebSocket accessToken
     */
    private String websocketToken;
    
    /**
     * Token过期时间戳（毫秒）
     */
    @Indexed
    private Long tokenExpireTime;

    @Indexed
    private Long nextCredentialMaintenanceAt;

    @Indexed
    private Long credentialMaintenanceLeaseUntil;

    @Indexed
    private Long websocketTokenLeaseUntil;
}
