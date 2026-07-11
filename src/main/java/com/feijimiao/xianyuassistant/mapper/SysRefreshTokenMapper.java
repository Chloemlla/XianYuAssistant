package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.SysRefreshToken;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysRefreshTokenMapper extends AbstractMongoMapper<SysRefreshToken> {
    public SysRefreshTokenMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, SysRefreshToken.class);
    }
}
