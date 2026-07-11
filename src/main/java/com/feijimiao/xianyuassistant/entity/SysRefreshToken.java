package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sys_refresh_token")
public class SysRefreshToken {
    @Id
    private Long id;
    @Indexed
    private Long userId;
    @Indexed(unique = true)
    private String tokenHash;
    @Indexed
    private String expireTime;
    private String createdTime;
}
