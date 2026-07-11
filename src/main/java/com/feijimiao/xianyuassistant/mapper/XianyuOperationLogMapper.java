package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuOperationLog;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class XianyuOperationLogMapper extends AbstractMongoMapper<XianyuOperationLog> {
    public XianyuOperationLogMapper(MongoTemplate t, MongoIdGenerator ids) { super(t, ids, XianyuOperationLog.class); }
    public List<XianyuOperationLog> selectByPage(Long a, String type, String module, Integer status, Integer size, Integer offset) { return mongoTemplate.find(filter(a,type,module,status).with(Sort.by(Sort.Direction.DESC,"createTime")).skip(offset).limit(size), entityType); }
    public Integer countByCondition(Long a, String type, String module, Integer status) { return Math.toIntExact(mongoTemplate.count(filter(a,type,module,status), entityType)); }
    public int deleteByAccountId(Long a) { return Math.toIntExact(mongoTemplate.remove(Query.query(Criteria.where("xianyuAccountId").is(a)), entityType).getDeletedCount()); }
    public int deleteOlderThan(long cutoff) { return Math.toIntExact(mongoTemplate.remove(Query.query(Criteria.where("createTime").lt(cutoff)), entityType).getDeletedCount()); }
    private Query filter(Long a,String t,String m,Integer s){ Criteria c=Criteria.where("xianyuAccountId").is(a); if(t!=null&&!t.isBlank())c.and("operationType").is(t); if(m!=null&&!m.isBlank())c.and("operationModule").is(m); if(s!=null)c.and("operationStatus").is(s); return Query.query(c); }
}
