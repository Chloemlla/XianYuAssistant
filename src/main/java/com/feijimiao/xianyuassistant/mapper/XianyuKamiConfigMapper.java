package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuKamiConfig;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import com.feijimiao.xianyuassistant.persistence.MongoQueryWrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XianyuKamiConfigMapper extends AbstractMongoMapper<XianyuKamiConfig> {
    public XianyuKamiConfigMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuKamiConfig.class);
    }

    public List<XianyuKamiConfig> findByAccountId(Long accountId) {
        return selectList(new MongoQueryWrapper<XianyuKamiConfig>()
                .eq(XianyuKamiConfig::getXianyuAccountId, accountId)
                .orderByDesc(XianyuKamiConfig::getCreateTime));
    }
}
