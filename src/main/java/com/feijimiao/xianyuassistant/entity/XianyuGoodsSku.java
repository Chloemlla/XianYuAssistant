package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "xianyu_goods_sku")
@CompoundIndex(name = "uk_goods_sku", def = "{'xyGoodsId': 1, 'skuId': 1}", unique = true)
public class XianyuGoodsSku {

    @Id
    private String id;

    private String xyGoodsId;

    private String skuId;

    private Integer price;

    private Integer quantity;

    private String propertyText;

    private Integer propertyId;

    private Integer valueId;

    private String valueText;

    private Integer propertySortOrder;

    private Integer valueSortOrder;

    private String features;

    private Long xianyuAccountId;

    private String createdTime;

    private String updatedTime;
}
