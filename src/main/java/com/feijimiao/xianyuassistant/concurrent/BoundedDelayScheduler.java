package com.feijimiao.xianyuassistant.concurrent;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component("sharedDelayScheduler")
public class BoundedDelayScheduler {
    private static final int MAX_PENDING_TASKS = 500;
    private final Semaphore admission = new Semaphore(MAX_PENDING_TASKS);
    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);

    public BoundedDelayScheduler() {
        executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        executor.setRemoveOnCancelPolicy(true);
    }

    public void schedule(Runnable task, long delay, TimeUnit unit) {
        if (!admission.tryAcquire()) {
            log.warn("延迟任务队列已满: pendingLimit={}", MAX_PENDING_TASKS);
            throw new RejectedExecutionException("延迟任务队列已满");
        }
        try {
            executor.schedule(() -> {
                try {
                    task.run();
                } finally {
                    admission.release();
                }
            }, delay, unit);
        } catch (RuntimeException e) {
            admission.release();
            throw e;
        }
    }

    @PreDestroy
    void shutdown() {
        executor.shutdownNow();
    }
}
