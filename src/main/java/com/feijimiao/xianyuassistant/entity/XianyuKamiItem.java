package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "xianyu_kami_item")
@CompoundIndex(name = "idx_kami_config_status_order", def = "{'kamiConfigId': 1, 'status': 1, 'sortOrder': 1}")
public class XianyuKamiItem {

    @Id
    private Long id;

    private Long kamiConfigId;

    private String kamiContent;

    private Integer status;

    private String orderId;

    private LocalDateTime usedTime;

    private Integer sortOrder;

    private LocalDateTime createTime = LocalDateTime.now();
}
