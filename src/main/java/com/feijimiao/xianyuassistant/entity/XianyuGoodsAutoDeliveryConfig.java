package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * 商品自动发货配置实体
 */
@Data
@Document(collection = "xianyu_goods_auto_delivery_config")
@CompoundIndex(name = "idx_delivery_account_goods_sku", def = "{'xianyuAccountId': 1, 'xyGoodsId': 1, 'skuId': 1}")
public class XianyuGoodsAutoDeliveryConfig {
    
    /**
     * 主键ID
     */
    @Id
    private Long id;
    
    /**
     * 闲鱼账号ID
     */
    private Long xianyuAccountId;
    
    /**
     * 本地闲鱼商品ID
     */
    private Long xianyuGoodsId;
    
    /**
     * 闲鱼的商品ID
     */
    private String xyGoodsId;
    
    /**
     * 发货模式：1-自动发货，2-卡密发货，3-自定义发货
     */
    private Integer deliveryMode;

    private String skuId;

    private String skuName;

    private String autoDeliveryContent;

    /**
     * 卡密发货：绑定的卡密配置ID列表（逗号分隔）
     */
    private String kamiConfigIds;

    /**
     * 卡密发货文案模板，使用{kmKey}占位符替换卡密内容
     */
    private String kamiDeliveryTemplate;
    
    /**
     * 自动发货图片URL
     */
    private String autoDeliveryImageUrl;

    /**
     * 自动确认发货开关：0-关闭，1-开启
     */
    private Integer autoConfirmShipment;

    /**
     * 自动回复延时秒数（RAG回复延时）
     */
    private Integer ragDelaySeconds;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime = LocalDateTime.now();
}
