package com.feijimiao.xianyuassistant.security;

import com.feijimiao.xianyuassistant.entity.SysBootstrapState;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class BootstrapInitializationGuardTest {
    @Test
    void acquiresSingletonClaimOnce() {
        MongoTemplate mongoTemplate = mock(MongoTemplate.class);
        BootstrapInitializationGuard guard = new BootstrapInitializationGuard(mongoTemplate);
        assertNotNull(guard.acquire());
    }

    @Test
    void duplicateSingletonClaimRejectsConcurrentInitializer() {
        MongoTemplate mongoTemplate = mock(MongoTemplate.class);
        doThrow(new DuplicateKeyException("duplicate")).when(mongoTemplate).insert(any(SysBootstrapState.class));
        BootstrapInitializationGuard guard = new BootstrapInitializationGuard(mongoTemplate);
        assertThrows(AlreadyInitializedException.class, guard::acquire);
    }
}
