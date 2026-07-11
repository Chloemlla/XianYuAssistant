package com.feijimiao.xianyuassistant.service.ai;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AiRequestBudgetTest {
    private final ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.AbortPolicy());

    @AfterEach
    void shutdown() {
        executor.shutdownNow();
    }

    @Test
    void rejectsCombinedPromptBeyondBudget() {
        AiRequestBudget budget = new AiRequestBudget(256, 1, 2, executor);
        assertThrows(IllegalArgumentException.class,
                () -> budget.call(() -> "unused", "a".repeat(200), "b".repeat(100)));
    }

    @Test
    void rejectsConcurrentRequestBeyondBulkhead() throws Exception {
        AiRequestBudget budget = new AiRequestBudget(1000, 1, 2, executor);
        CountDownLatch entered = new CountDownLatch(1);
        CountDownLatch release = new CountDownLatch(1);
        var first = Executors.newSingleThreadExecutor();
        try {
            first.submit(() -> budget.call("hello", () -> {
                entered.countDown();
                try { release.await(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                return "ok";
            }));
            entered.await(1, TimeUnit.SECONDS);
            assertThrows(IllegalStateException.class, () -> budget.call("second", () -> "unexpected"));
            release.countDown();
        } finally {
            release.countDown();
            first.shutdownNow();
        }
    }

    @Test
    void returnsSuccessfulResultInsideBudget() {
        AiRequestBudget budget = new AiRequestBudget(1000, 1, 2, executor);
        assertEquals("ok", budget.call("hello", () -> "ok"));
    }
}
