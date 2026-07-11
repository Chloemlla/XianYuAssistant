package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuCookie;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 闲鱼Cookie Mapper
 */
@Repository
public class XianyuCookieMapper extends AbstractMongoMapper<XianyuCookie> {
    public XianyuCookieMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator) {
        super(mongoTemplate, idGenerator, XianyuCookie.class);
    }

    public List<XianyuCookie> claimDueCredentialMaintenance(int limit, long now, long leaseUntil, long nextMaintenanceAt) {
        Criteria due = new Criteria().orOperator(
                Criteria.where("nextCredentialMaintenanceAt").exists(false),
                Criteria.where("nextCredentialMaintenanceAt").lte(now));
        Criteria leaseAvailable = new Criteria().orOperator(
                Criteria.where("credentialMaintenanceLeaseUntil").exists(false),
                Criteria.where("credentialMaintenanceLeaseUntil").lt(now));
        return claimBatch(limit, new Criteria().andOperator(Criteria.where("cookieStatus").is(1), due, leaseAvailable),
                new Update().set("credentialMaintenanceLeaseUntil", leaseUntil)
                        .set("nextCredentialMaintenanceAt", nextMaintenanceAt));
    }

    public List<XianyuCookie> claimDueWebsocketTokenRefresh(int limit, long now, long refreshBefore, long leaseUntil) {
        Criteria due = new Criteria().orOperator(
                Criteria.where("tokenExpireTime").exists(false),
                Criteria.where("tokenExpireTime").lte(refreshBefore));
        Criteria leaseAvailable = new Criteria().orOperator(
                Criteria.where("websocketTokenLeaseUntil").exists(false),
                Criteria.where("websocketTokenLeaseUntil").lt(now));
        return claimBatch(limit, new Criteria().andOperator(Criteria.where("cookieStatus").is(1), due, leaseAvailable),
                new Update().set("websocketTokenLeaseUntil", leaseUntil));
    }

    public void releaseCredentialMaintenanceLease(Long accountId) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("xianyuAccountId").is(accountId)),
                new Update().unset("credentialMaintenanceLeaseUntil"), entityType);
    }

    public void releaseWebsocketTokenLease(Long accountId) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("xianyuAccountId").is(accountId)),
                new Update().unset("websocketTokenLeaseUntil"), entityType);
    }

    private List<XianyuCookie> claimBatch(int limit, Criteria criteria, Update update) {
        List<XianyuCookie> claimed = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            XianyuCookie cookie = mongoTemplate.findAndModify(Query.query(criteria), update,
                    FindAndModifyOptions.options().returnNew(true), entityType);
            if (cookie == null) break;
            claimed.add(cookie);
        }
        return claimed;
    }
}
