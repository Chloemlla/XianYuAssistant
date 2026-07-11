package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuAccount;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 闲鱼账号Mapper
 */
@Repository
public class XianyuAccountMapper extends AbstractMongoMapper<XianyuAccount> {
    public XianyuAccountMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuAccount.class);
    }
}
