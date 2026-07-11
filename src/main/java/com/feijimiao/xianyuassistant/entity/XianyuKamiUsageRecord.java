package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "xianyu_kami_usage_record")
@CompoundIndex(name = "uk_kami_usage_item_order", def = "{'kamiItemId': 1, 'orderId': 1}", unique = true)
public class XianyuKamiUsageRecord {

    @Id
    private Long id;

    private Long kamiConfigId;

    private Long kamiItemId;

    private Long xianyuAccountId;

    private String xyGoodsId;

    private String orderId;

    private String buyerUserId;

    private String buyerUserName;

    private String kamiContent;

    private LocalDateTime createTime = LocalDateTime.now();
}
