package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class XianyuGoodsOrderMapperTest {
    @Test
    void atomicClaimReturnsOnlyClaimedDocument() {
        MongoTemplate template = mock(MongoTemplate.class);
        XianyuGoodsOrder expected = new XianyuGoodsOrder();
        when(template.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), eq(XianyuGoodsOrder.class)))
                .thenReturn(expected);
        XianyuGoodsOrderMapper mapper = new XianyuGoodsOrderMapper(template, mock(MongoIdGenerator.class));
        assertSame(expected, mapper.claimForApiDelivery(1L, "order-1", "claim-1", System.currentTimeMillis() + 60_000));
        verify(template).findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), eq(XianyuGoodsOrder.class));
    }
}
