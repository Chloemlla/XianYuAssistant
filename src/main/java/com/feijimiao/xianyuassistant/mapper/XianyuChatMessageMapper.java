package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuChatMessage;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XianyuChatMessageMapper extends AbstractMongoMapper<XianyuChatMessage> {
    public XianyuChatMessageMapper(MongoTemplate template, MongoIdGenerator ids) { super(template, ids, XianyuChatMessage.class); }

    public XianyuChatMessage findByPnmId(Long accountId, String pnmId) { return mongoTemplate.findOne(Query.query(Criteria.where("xianyuAccountId").is(accountId).and("pnmId").is(pnmId)), entityType); }
    public List<XianyuChatMessage> findByAccountId(Long accountId, int limit, int offset) { return mongoTemplate.find(Query.query(Criteria.where("xianyuAccountId").is(accountId)).with(Sort.by(Sort.Direction.DESC, "messageTime")).skip(offset).limit(limit), entityType); }
    public List<XianyuChatMessage> findBySId(String sId) { return mongoTemplate.find(Query.query(Criteria.where("sId").is(sId)).with(Sort.by(Sort.Direction.ASC, "messageTime")), entityType); }
    public List<XianyuChatMessage> findBySenderUserId(String senderUserId) { return mongoTemplate.find(Query.query(Criteria.where("senderUserId").is(senderUserId)).with(Sort.by(Sort.Direction.DESC, "messageTime")), entityType); }
    public int deleteByAccountId(Long accountId) { return Math.toIntExact(mongoTemplate.remove(Query.query(Criteria.where("xianyuAccountId").is(accountId)), entityType).getDeletedCount()); }
    public List<XianyuChatMessage> findMessagesByPage(Long accountId, String xyGoodsId, String senderUserId, int limit, int offset) { Query q = messageQuery(accountId, xyGoodsId, senderUserId).with(Sort.by(Sort.Direction.DESC, "messageTime")).skip(offset).limit(limit); return mongoTemplate.find(q, entityType); }
    public int countMessages(Long accountId, String xyGoodsId, String senderUserId) { return Math.toIntExact(mongoTemplate.count(messageQuery(accountId, xyGoodsId, senderUserId), entityType)); }
    public List<XianyuChatMessage> findRecentBySId(String sId, int limit, int offset) { return mongoTemplate.find(Query.query(Criteria.where("sId").is(sId)).with(Sort.by(Sort.Direction.DESC, "messageTime")).skip(offset).limit(limit), entityType); }

    private Query messageQuery(Long accountId, String xyGoodsId, String senderUserId) {
        Criteria c = Criteria.where("xianyuAccountId").is(accountId);
        if (xyGoodsId != null && !xyGoodsId.isBlank()) c.and("xyGoodsId").is(xyGoodsId);
        if (senderUserId != null && !senderUserId.isBlank()) c.and("senderUserId").ne(senderUserId);
        return Query.query(c);
    }
}
