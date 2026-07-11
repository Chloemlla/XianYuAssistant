package com.feijimiao.xianyuassistant.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MongoIdGenerator {
    private final MongoTemplate mongoTemplate;

    public long next(String sequenceName) {
        MongoSequence sequence = mongoTemplate.findAndModify(
                Query.query(Criteria.where("_id").is(sequenceName)),
                new Update().inc("value", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                MongoSequence.class);
        if (sequence == null) throw new IllegalStateException("Unable to allocate MongoDB sequence " + sequenceName);
        return sequence.getValue();
    }
}
