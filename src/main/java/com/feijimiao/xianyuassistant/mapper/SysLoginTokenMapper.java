package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.SysLoginToken;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 登录Token Mapper
 * @author IAMLZY
 * @date 2026/4/22
 */
@Repository
public class SysLoginTokenMapper extends AbstractMongoMapper<SysLoginToken> {
    public SysLoginTokenMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, SysLoginToken.class);
    }
}
