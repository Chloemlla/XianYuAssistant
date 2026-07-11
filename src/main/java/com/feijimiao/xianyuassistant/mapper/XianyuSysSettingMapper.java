package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuSysSetting;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 系统配置Mapper
 * @author IAMLZY
 * @date 2026/4/22
 */
@Repository
public class XianyuSysSettingMapper extends AbstractMongoMapper<XianyuSysSetting> {
    public XianyuSysSettingMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuSysSetting.class);
    }
}
