package com.feijimiao.xianyuassistant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class RuntimeExecutorConfig {
    @Bean(name = "websocketMessageExecutor", destroyMethod = "shutdown")
    public ExecutorService websocketMessageExecutor() {
        return boundedExecutor(4, 16, 500, "ws-message-", true);
    }

    @Bean(name = "maintenanceExecutor", destroyMethod = "shutdown")
    public ExecutorService maintenanceExecutor() {
        return boundedExecutor(2, 8, 100, "maintenance-", false);
    }

    @Bean(name = "deliveryExecutor", destroyMethod = "shutdown")
    public ExecutorService deliveryExecutor() {
        return boundedExecutor(2, 8, 200, "delivery-", false);
    }

    @Bean(name = "aiRequestExecutor", destroyMethod = "shutdown")
    public ExecutorService aiRequestExecutor() {
        return boundedExecutor(2, 4, 16, "ai-request-", false);
    }

    private ExecutorService boundedExecutor(int core, int max, int capacity, String prefix, boolean callerRuns) {
        return new ThreadPoolExecutor(core, max, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(capacity), namedFactory(prefix),
                callerRuns ? new ThreadPoolExecutor.CallerRunsPolicy() : new ThreadPoolExecutor.AbortPolicy());
    }

    private ThreadFactory namedFactory(String prefix) {
        AtomicInteger sequence = new AtomicInteger();
        return task -> new Thread(task, prefix + sequence.incrementAndGet());
    }
}
