package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuGoodsConfig;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import com.feijimiao.xianyuassistant.persistence.MongoQueryWrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XianyuGoodsConfigMapper extends AbstractMongoMapper<XianyuGoodsConfig> {
    public XianyuGoodsConfigMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuGoodsConfig.class);
    }

    public XianyuGoodsConfig selectByAccountAndGoodsId(Long accountId, String goodsId) {
        return selectOne(new MongoQueryWrapper<XianyuGoodsConfig>()
                .eq(XianyuGoodsConfig::getXianyuAccountId, accountId)
                .eq(XianyuGoodsConfig::getXyGoodsId, goodsId));
    }

    public List<XianyuGoodsConfig> selectByAccountId(Long accountId) {
        return selectList(new MongoQueryWrapper<XianyuGoodsConfig>()
                .eq(XianyuGoodsConfig::getXianyuAccountId, accountId));
    }

    public List<XianyuGoodsConfig> selectAllWithAutoReply() {
        return mongoTemplate.find(Query.query(Criteria.where("xianyuAutoReplyOn").ne(null)), entityType);
    }

    public int update(XianyuGoodsConfig config) {
        return updateById(config);
    }

    public int updateFixedMaterial(Long accountId, String goodsId, String fixedMaterial) {
        Query query = Query.query(Criteria.where("xianyuAccountId").is(accountId).and("xyGoodsId").is(goodsId));
        return Math.toIntExact(mongoTemplate.updateFirst(query, new Update().set("fixedMaterial", fixedMaterial), entityType)
                .getModifiedCount());
    }

    public int deleteByAccountId(Long accountId) {
        return delete(new MongoQueryWrapper<XianyuGoodsConfig>()
                .eq(XianyuGoodsConfig::getXianyuAccountId, accountId));
    }
}
