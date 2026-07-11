package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sys_bootstrap_state")
public class SysBootstrapState {
    @Id
    private String id;
    private String owner;
    private String status;
    private String updatedTime;
}
