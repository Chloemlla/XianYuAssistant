package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "xianyu_goods_sku_property")
@CompoundIndex(name = "uk_sku_property", def = "{'xyGoodsId': 1, 'propertyId': 1, 'valueId': 1}", unique = true)
public class XianyuGoodsSkuProperty {

    @Id
    private String id;

    private String xyGoodsId;

    private Integer propertyId;

    private String propertyText;

    private Integer propertySortOrder;

    private Integer valueId;

    private String valueText;

    private Integer valueSortOrder;

    private Long xianyuAccountId;

    private String createdTime;

    private String updatedTime;
}
