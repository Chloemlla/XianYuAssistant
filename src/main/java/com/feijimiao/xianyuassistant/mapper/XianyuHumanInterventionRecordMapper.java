package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuHumanInterventionRecord;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class XianyuHumanInterventionRecordMapper extends AbstractMongoMapper<XianyuHumanInterventionRecord> {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public XianyuHumanInterventionRecordMapper(MongoTemplate t, MongoIdGenerator ids) { super(t, ids, XianyuHumanInterventionRecord.class); }
    public XianyuHumanInterventionRecord findActiveBySId(String sId) { return mongoTemplate.findOne(Query.query(Criteria.where("sId").is(sId).and("endTime").gt(now())).with(Sort.by(Sort.Direction.DESC,"endTime")), entityType); }
    public int cleanExpired() { return Math.toIntExact(mongoTemplate.remove(Query.query(Criteria.where("endTime").lt(now())), entityType).getDeletedCount()); }
    private String now() { return LocalDateTime.now().format(FORMAT); }
}
