package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuGoodsAutoReplyRecord;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public class XianyuGoodsAutoReplyRecordMapper extends AbstractMongoMapper<XianyuGoodsAutoReplyRecord> {
    public XianyuGoodsAutoReplyRecordMapper(MongoTemplate t, MongoIdGenerator ids) { super(t, ids, XianyuGoodsAutoReplyRecord.class); }
    public int updateStateAndContent(Long id, Integer state, String replyContent) { return modified(id, new Update().set("state", state).set("replyContent", replyContent)); }
    public int updateTriggerContext(Long id, String triggerContext) { return modified(id, new Update().set("triggerContext", triggerContext)); }
    public List<XianyuGoodsAutoReplyRecord> selectByAccountId(Long accountId) { return mongoTemplate.find(Query.query(Criteria.where("xianyuAccountId").is(accountId)).with(Sort.by(Sort.Direction.DESC, "createTime")), entityType); }
    public XianyuGoodsAutoReplyRecord selectLatestByAccountIdAndSId(Long accountId, String sId) { return mongoTemplate.findOne(Query.query(Criteria.where("xianyuAccountId").is(accountId).and("sId").is(sId)).with(Sort.by(Sort.Direction.DESC, "createTime")), entityType); }
    public int deleteByAccountId(Long accountId) { return Math.toIntExact(mongoTemplate.remove(Query.query(Criteria.where("xianyuAccountId").is(accountId)), entityType).getDeletedCount()); }
    public List<XianyuGoodsAutoReplyRecord> selectByAccountIdAndGoodsId(Long accountId, String goodsId, int limit, int offset) { return mongoTemplate.find(Query.query(Criteria.where("xianyuAccountId").is(accountId).and("xyGoodsId").is(goodsId)).with(Sort.by(Sort.Direction.DESC, "createTime")).skip(offset).limit(limit), entityType); }
    public int countByAccountIdAndGoodsId(Long accountId, String goodsId) { return Math.toIntExact(mongoTemplate.count(Query.query(Criteria.where("xianyuAccountId").is(accountId).and("xyGoodsId").is(goodsId)), entityType)); }
    public int countYesterdayAiReplies() { return countAiRepliesByDate(LocalDate.now().minusDays(1).toString()); }
    public int countAllReplies() { return Math.toIntExact(mongoTemplate.count(new Query(), entityType)); }
    public int countAiRepliesByDate(String date) { return Math.toIntExact(mongoTemplate.count(Query.query(Criteria.where("createTime").regex("^" + java.util.regex.Pattern.quote(date))), entityType)); }
    private int modified(Long id, Update update) { return Math.toIntExact(mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)), update, entityType).getModifiedCount()); }
}
