package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuKamiItem;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import com.feijimiao.xianyuassistant.persistence.MongoQueryWrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class XianyuKamiItemMapper extends AbstractMongoMapper<XianyuKamiItem> {
    public XianyuKamiItemMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuKamiItem.class);
    }

    public XianyuKamiItem findNextUnused(Long configId) {
        return selectOne(new MongoQueryWrapper<XianyuKamiItem>()
                .eq(XianyuKamiItem::getKamiConfigId, configId)
                .eq(XianyuKamiItem::getStatus, 0)
                .orderByAsc(XianyuKamiItem::getSortOrder));
    }

    public XianyuKamiItem findRandomUnused(Long configId) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("kamiConfigId").is(configId).and("status").is(0)),
                Aggregation.sample(1));
        return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(entityType), entityType)
                .getUniqueMappedResult();
    }

    public List<XianyuKamiItem> findByConfigId(Long configId) {
        return selectList(baseConfigQuery(configId));
    }

    public List<XianyuKamiItem> findByConfigIdWithFilter(Long configId, Integer status, String keyword) {
        MongoQueryWrapper<XianyuKamiItem> wrapper = baseConfigQuery(configId).eq(status != null, XianyuKamiItem::getStatus, status);
        if (keyword != null && !keyword.isBlank()) wrapper.like(XianyuKamiItem::getKamiContent, keyword);
        return selectList(wrapper);
    }

    public int countUnused(Long configId) {
        return countByConfigIdAndStatus(configId, 0);
    }

    public int countUsed(Long configId) {
        return countByConfigIdAndStatus(configId, 1);
    }

    public int countByConfigId(Long configId) {
        return Math.toIntExact(selectCount(new MongoQueryWrapper<XianyuKamiItem>()
                .eq(XianyuKamiItem::getKamiConfigId, configId)));
    }

    public int countByConfigIdAndContent(Long configId, String content) {
        return Math.toIntExact(selectCount(new MongoQueryWrapper<XianyuKamiItem>()
                .eq(XianyuKamiItem::getKamiConfigId, configId)
                .eq(XianyuKamiItem::getKamiContent, content)));
    }

    public int markUsed(Long id, String orderId) {
        Query query = Query.query(Criteria.where("_id").is(id).and("status").is(0));
        Update update = new Update().set("status", 1).set("orderId", orderId).set("usedTime", LocalDateTime.now());
        return Math.toIntExact(mongoTemplate.updateFirst(query, update, entityType).getModifiedCount());
    }

    public int markUnused(Long id) {
        Query query = Query.query(Criteria.where("_id").is(id).and("status").is(1));
        Update update = new Update().set("status", 0).unset("orderId").unset("usedTime");
        return Math.toIntExact(mongoTemplate.updateFirst(query, update, entityType).getModifiedCount());
    }

    public List<XianyuKamiItem> findByConfigIdAndStatus(Long configId, Integer status) {
        return selectList(baseConfigQuery(configId).eq(XianyuKamiItem::getStatus, status));
    }

    private int countByConfigIdAndStatus(Long configId, Integer status) {
        return Math.toIntExact(selectCount(new MongoQueryWrapper<XianyuKamiItem>()
                .eq(XianyuKamiItem::getKamiConfigId, configId)
                .eq(XianyuKamiItem::getStatus, status)));
    }

    private MongoQueryWrapper<XianyuKamiItem> baseConfigQuery(Long configId) {
        return new MongoQueryWrapper<XianyuKamiItem>()
                .eq(XianyuKamiItem::getKamiConfigId, configId)
                .orderByAsc(XianyuKamiItem::getSortOrder);
    }
}
