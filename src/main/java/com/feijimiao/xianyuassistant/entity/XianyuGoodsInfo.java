package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 闲鱼商品信息实体类
 */
@Data
@Document(collection = "xianyu_goods")
public class XianyuGoodsInfo {
    
    /**
     * 主键ID（雪花ID）
     */
    @Id
    private Long id;
    
    /**
     * 闲鱼商品ID
     */
    @Indexed(unique = true)
    private String xyGoodId;
    
    /**
     * 商品标题
     */
    private String title;
    
    /**
     * 封面图片URL
     */
    private String coverPic;
    
    /**
     * 商品详情图片（JSON数组）
     */
    private String infoPic;
    
    /**
     * 商品详情信息（预留字段）
     */
    private String detailInfo;
    
    /**
     * 商品详情页URL
     */
    private String detailUrl;
    
    /**
     * 关联的闲鱼账号ID
     */
    private Long xianyuAccountId;
    
    /**
     * 商品价格
     */
    private String soldPrice;
    
    private Integer skuCount;
    
    private Integer status;
    
    /**
     * 创建时间（SQLite存储为TEXT）
     */
    private String createdTime;
    
    /**
     * 更新时间（SQLite存储为TEXT）
     */
    private String updatedTime;
}
