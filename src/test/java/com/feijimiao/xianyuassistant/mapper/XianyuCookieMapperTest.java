package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuCookie;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class XianyuCookieMapperTest {
    @Test
    void claimsOnlyBoundedDueBatchWithoutFullCollectionScan() {
        MongoTemplate template = mock(MongoTemplate.class);
        XianyuCookie cookie = new XianyuCookie();
        cookie.setXianyuAccountId(1L);
        when(template.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), eq(XianyuCookie.class)))
                .thenReturn(cookie)
                .thenReturn(null);
        XianyuCookieMapper mapper = new XianyuCookieMapper(template, mock(MongoIdGenerator.class));
        assertEquals(1, mapper.claimDueCredentialMaintenance(10, 100, 200, 300).size());
    }
}
