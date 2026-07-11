package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 商品订单实体类
 */
@Data
@Document(collection = "xianyu_goods_order")
@CompoundIndexes({
        @CompoundIndex(name = "uk_goods_order_account_pnm", def = "{'xianyuAccountId': 1, 'pnmId': 1}", unique = true),
        @CompoundIndex(name = "idx_goods_order_account_created", def = "{'xianyuAccountId': 1, 'createTime': -1}"),
        @CompoundIndex(name = "idx_goods_order_account_order", def = "{'xianyuAccountId': 1, 'orderId': 1}")
        ,@CompoundIndex(name = "idx_goods_order_delivery_claim", def = "{'deliveryClaimExpiresAt': 1, 'state': 1}")
})
public class XianyuGoodsOrder {
    @Id
    private Long id;
    
    private Long xianyuAccountId;
    
    private Long xianyuGoodsId;
    
    private String xyGoodsId;
    
    private String pnmId;
    
    private String orderId;
    
    private String buyerUserId;
    
    private String buyerUserName;
    
    private String sid;
    
    private String content;
    
    private Integer state;
    
    private String failReason;
    
    private Integer confirmState;
    
    private String createTime;
    
    private String goodsTitle;

    private String skuName;

    private String orderCreateTime;

    private String paySuccessTime;

    private String consignTime;

    private String totalPrice;

    private Integer buyNum;

    private String deliveryClaimToken;

    private Long deliveryClaimExpiresAt;
}
