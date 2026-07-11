package com.feijimiao.xianyuassistant.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BoundedDelaySchedulerTest {
    @Test
    void rejectsTasksBeyondAdmissionLimit() {
        BoundedDelayScheduler scheduler = new BoundedDelayScheduler();
        try {
            for (int i = 0; i < 500; i++) {
                scheduler.schedule(() -> { }, 1, TimeUnit.DAYS);
            }
            assertThrows(RejectedExecutionException.class,
                    () -> scheduler.schedule(() -> { }, 1, TimeUnit.DAYS));
        } finally {
            scheduler.shutdown();
        }
    }
}
