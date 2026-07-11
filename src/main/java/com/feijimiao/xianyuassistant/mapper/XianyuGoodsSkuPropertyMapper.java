package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuGoodsSkuProperty;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class XianyuGoodsSkuPropertyMapper extends AbstractMongoMapper<XianyuGoodsSkuProperty> {
    public XianyuGoodsSkuPropertyMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuGoodsSkuProperty.class);
    }
}
