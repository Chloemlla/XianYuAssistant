package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuKeywordReplyContent;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class XianyuKeywordReplyContentMapper extends AbstractMongoMapper<XianyuKeywordReplyContent> {
    public XianyuKeywordReplyContentMapper(MongoTemplate t, MongoIdGenerator ids) { super(t, ids, XianyuKeywordReplyContent.class); }
    public List<XianyuKeywordReplyContent> selectByRuleId(Long id) { return mongoTemplate.find(Query.query(Criteria.where("ruleId").is(id)), entityType); }
    public int deleteByRuleId(Long id) { return Math.toIntExact(mongoTemplate.remove(Query.query(Criteria.where("ruleId").is(id)), entityType).getDeletedCount()); }
}
