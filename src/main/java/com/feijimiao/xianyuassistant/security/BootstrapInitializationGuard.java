package com.feijimiao.xianyuassistant.security;

import com.feijimiao.xianyuassistant.entity.SysBootstrapState;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class BootstrapInitializationGuard {
    private static final String STATE_ID = "singleton";
    private final MongoTemplate mongoTemplate;

    public BootstrapInitializationGuard(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public String acquire() {
        String owner = UUID.randomUUID().toString();
        SysBootstrapState state = new SysBootstrapState();
        state.setId(STATE_ID);
        state.setOwner(owner);
        state.setStatus("INITIALIZING");
        state.setUpdatedTime(Instant.now().toString());
        try {
            mongoTemplate.insert(state);
            return owner;
        } catch (DuplicateKeyException e) {
            throw new AlreadyInitializedException("系统已初始化或正在初始化");
        }
    }

    public void complete(String owner) {
        mongoTemplate.updateFirst(ownerQuery(owner), new Update()
                .set("status", "COMPLETE")
                .set("updatedTime", Instant.now().toString()), SysBootstrapState.class);
    }

    public void release(String owner) {
        mongoTemplate.remove(ownerQuery(owner).addCriteria(Criteria.where("status").is("INITIALIZING")), SysBootstrapState.class);
    }

    private Query ownerQuery(String owner) {
        return Query.query(Criteria.where("_id").is(STATE_ID).and("owner").is(owner));
    }
}
