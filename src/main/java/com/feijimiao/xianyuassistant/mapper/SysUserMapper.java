package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.SysUser;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 系统用户Mapper
 * @author IAMLZY
 * @date 2026/4/22
 */
@Repository
public class SysUserMapper extends AbstractMongoMapper<SysUser> {
    public SysUserMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, SysUser.class);
    }
}
