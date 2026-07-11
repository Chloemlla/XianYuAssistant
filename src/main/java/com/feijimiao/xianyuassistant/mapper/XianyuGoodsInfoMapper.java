package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuGoodsInfo;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import com.feijimiao.xianyuassistant.persistence.MongoQueryWrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XianyuGoodsInfoMapper extends AbstractMongoMapper<XianyuGoodsInfo> {
    public XianyuGoodsInfoMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuGoodsInfo.class);
    }

    public List<XianyuGoodsInfo> selectPage(MongoQueryWrapper<XianyuGoodsInfo> wrapper, int offset, int pageSize) {
        Query query = wrapper.toQuery().skip(Math.max(offset, 0)).limit(Math.max(pageSize, 0));
        return mongoTemplate.find(query, entityType);
    }
}
