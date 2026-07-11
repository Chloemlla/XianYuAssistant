package com.feijimiao.xianyuassistant.backup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class BackupImportReporter {
    private static final String FAILURE_KEY = "_importFailures";

    private BackupImportReporter() {
    }

    @SuppressWarnings("unchecked")
    public static void recordFailure(Map<String, Object> context, String moduleKey, String recordType, Exception error) {
        Map<String, List<String>> failures = (Map<String, List<String>>) context.computeIfAbsent(
                FAILURE_KEY, ignored -> new LinkedHashMap<String, List<String>>());
        String message = recordType + ": " + (error.getMessage() == null ? error.getClass().getSimpleName() : error.getMessage());
        failures.computeIfAbsent(moduleKey, ignored -> new ArrayList<>()).add(message);
    }

    @SuppressWarnings("unchecked")
    public static List<String> failuresFor(Map<String, Object> context, String moduleKey) {
        Object value = context.get(FAILURE_KEY);
        if (!(value instanceof Map<?, ?> failures)) {
            return List.of();
        }
        Object moduleFailures = failures.get(moduleKey);
        return moduleFailures instanceof List<?> list
                ? list.stream().map(String::valueOf).toList()
                : List.of();
    }
}
