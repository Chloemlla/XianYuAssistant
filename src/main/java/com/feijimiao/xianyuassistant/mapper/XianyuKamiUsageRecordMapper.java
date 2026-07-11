package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuKamiUsageRecord;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class XianyuKamiUsageRecordMapper extends AbstractMongoMapper<XianyuKamiUsageRecord> {
    public XianyuKamiUsageRecordMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuKamiUsageRecord.class);
    }
}
