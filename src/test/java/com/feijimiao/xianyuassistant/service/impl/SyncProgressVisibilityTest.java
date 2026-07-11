package com.feijimiao.xianyuassistant.service.impl;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SyncProgressVisibilityTest {
    @Test
    void asynchronouslyReadProgressFieldsAreVolatile() throws Exception {
        Class<?> type = Class.forName(ItemDetailSyncServiceImpl.class.getName() + "$SyncProgress");
        for (String field : new String[]{"completedCount", "successCount", "failedCount", "isCompleted", "isRunning", "message", "cancelled"}) {
            assertTrue(Modifier.isVolatile(type.getDeclaredField(field).getModifiers()), field + " must be volatile");
        }
    }
}
