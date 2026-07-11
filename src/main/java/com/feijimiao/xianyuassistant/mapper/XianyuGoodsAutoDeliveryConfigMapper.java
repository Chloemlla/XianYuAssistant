package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoDeliveryConfig;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import com.feijimiao.xianyuassistant.persistence.MongoQueryWrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XianyuGoodsAutoDeliveryConfigMapper extends AbstractMongoMapper<XianyuGoodsAutoDeliveryConfig> {
    public XianyuGoodsAutoDeliveryConfigMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuGoodsAutoDeliveryConfig.class);
    }

    public XianyuGoodsAutoDeliveryConfig findByAccountIdAndGoodsIdAndSkuId(Long accountId, String goodsId, String skuId) {
        return selectOne(new MongoQueryWrapper<XianyuGoodsAutoDeliveryConfig>()
                .eq(XianyuGoodsAutoDeliveryConfig::getXianyuAccountId, accountId)
                .eq(XianyuGoodsAutoDeliveryConfig::getXyGoodsId, goodsId)
                .eq(XianyuGoodsAutoDeliveryConfig::getSkuId, skuId));
    }

    public XianyuGoodsAutoDeliveryConfig findByAccountIdAndGoodsIdNoSku(Long accountId, String goodsId) {
        return selectOne(new MongoQueryWrapper<XianyuGoodsAutoDeliveryConfig>()
                .eq(XianyuGoodsAutoDeliveryConfig::getXianyuAccountId, accountId)
                .eq(XianyuGoodsAutoDeliveryConfig::getXyGoodsId, goodsId)
                .isNull(XianyuGoodsAutoDeliveryConfig::getSkuId));
    }

    public List<XianyuGoodsAutoDeliveryConfig> findByAccountIdAndGoodsId(Long accountId, String goodsId) {
        return selectList(new MongoQueryWrapper<XianyuGoodsAutoDeliveryConfig>()
                .eq(XianyuGoodsAutoDeliveryConfig::getXianyuAccountId, accountId)
                .eq(XianyuGoodsAutoDeliveryConfig::getXyGoodsId, goodsId)
                .orderByAsc(XianyuGoodsAutoDeliveryConfig::getSkuId));
    }

    public List<XianyuGoodsAutoDeliveryConfig> findByAccountId(Long accountId) {
        return selectList(new MongoQueryWrapper<XianyuGoodsAutoDeliveryConfig>()
                .eq(XianyuGoodsAutoDeliveryConfig::getXianyuAccountId, accountId)
                .orderByDesc(XianyuGoodsAutoDeliveryConfig::getCreateTime));
    }

    public int deleteByAccountId(Long accountId) {
        return delete(new MongoQueryWrapper<XianyuGoodsAutoDeliveryConfig>()
                .eq(XianyuGoodsAutoDeliveryConfig::getXianyuAccountId, accountId));
    }
}
