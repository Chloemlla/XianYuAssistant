package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuKeywordReplyRule;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class XianyuKeywordReplyRuleMapper extends AbstractMongoMapper<XianyuKeywordReplyRule> {
    public XianyuKeywordReplyRuleMapper(MongoTemplate t, MongoIdGenerator ids) { super(t, ids, XianyuKeywordReplyRule.class); }
    public List<XianyuKeywordReplyRule> selectByAccountAndGoodsId(Long a, String g) { return mongoTemplate.find(base(a, g), entityType); }
    public XianyuKeywordReplyRule selectByKeyword(Long a, String g, String k) { Query q=base(a,g); q.addCriteria(Criteria.where("keyword").is(k).and("isFallback").is(0)); return mongoTemplate.findOne(q, entityType); }
    public XianyuKeywordReplyRule selectFallback(Long a, String g) { Query q=base(a,g); q.addCriteria(Criteria.where("isFallback").is(1)); return mongoTemplate.findOne(q, entityType); }
    public List<XianyuKeywordReplyRule> matchExact(Long a, String g, String m) { Query q=base(a,g); q.addCriteria(Criteria.where("matchMode").is(2).and("keyword").is(m).and("isFallback").is(0)); return mongoTemplate.find(q, entityType); }
    public List<XianyuKeywordReplyRule> matchFuzzy(Long a, String g, String m) { return mongoTemplate.find(base(a,g), entityType).stream().filter(r -> Integer.valueOf(1).equals(r.getMatchMode()) && !Integer.valueOf(1).equals(r.getIsFallback()) && r.getKeyword()!=null && m.contains(r.getKeyword())).toList(); }
    private Query base(Long a, String g) { return Query.query(Criteria.where("xianyuAccountId").is(a).and("xyGoodsId").is(g)); }
}
