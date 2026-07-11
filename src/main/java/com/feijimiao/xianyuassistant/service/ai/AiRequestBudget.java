package com.feijimiao.xianyuassistant.service.ai;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Component
public class AiRequestBudget {
    private final int maxPromptCharacters;
    private final long timeoutSeconds;
    private final Semaphore permits;
    private final ExecutorService executor;

    public AiRequestBudget(@Value("${ai.limits.max-prompt-characters:8000}") int maxPromptCharacters,
                           @Value("${ai.limits.max-concurrent-requests:4}") int maxConcurrentRequests,
                           @Value("${ai.limits.request-timeout-seconds:45}") long timeoutSeconds,
                           @Qualifier("aiRequestExecutor") ExecutorService executor) {
        this.maxPromptCharacters = Math.max(256, maxPromptCharacters);
        this.timeoutSeconds = Math.max(1, timeoutSeconds);
        this.permits = new Semaphore(Math.max(1, maxConcurrentRequests));
        this.executor = executor;
    }

    public <T> T call(String prompt, Supplier<T> operation) {
        return call(operation, prompt);
    }

    public <T> T call(Supplier<T> operation, String... inputs) {
        validateInputs(inputs);
        if (!permits.tryAcquire()) {
            throw new IllegalStateException("AI请求并发已达上限");
        }
        Future<T> future;
        try {
            future = executor.submit(operation::get);
        } catch (RuntimeException e) {
            permits.release();
            throw new IllegalStateException("AI请求执行队列已满", e);
        }
        try {
            return future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            future.cancel(true);
            throw new IllegalStateException("AI请求超时或失败", e);
        } finally {
            permits.release();
        }
    }

    public Flux<String> stream(String prompt, Supplier<Flux<String>> operation) {
        return stream(operation, prompt);
    }

    public Flux<String> stream(Supplier<Flux<String>> operation, String... inputs) {
        return Flux.defer(() -> {
            validateInputs(inputs);
            if (!permits.tryAcquire()) {
                return Flux.error(new IllegalStateException("AI请求并发已达上限"));
            }
            try {
                return operation.get()
                        .timeout(Duration.ofSeconds(timeoutSeconds))
                        .doFinally(signal -> permits.release());
            } catch (Exception e) {
                permits.release();
                return Flux.error(e);
            }
        });
    }

    public void validateInputs(String... inputs) {
        if (inputs == null || inputs.length == 0 || inputs[0] == null || inputs[0].isBlank()) {
            throw new IllegalArgumentException("AI prompt不能为空");
        }
        long totalCharacters = 0;
        for (String input : inputs) {
            if (input != null) totalCharacters += input.length();
        }
        if (totalCharacters > maxPromptCharacters) {
            throw new IllegalArgumentException("AI prompt超过字符预算: " + maxPromptCharacters);
        }
    }
}
