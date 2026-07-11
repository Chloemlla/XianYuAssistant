package com.feijimiao.xianyuassistant.backup;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackupImportReporterTest {
    @Test
    void recordsPerModuleRecordFailures() {
        Map<String, Object> context = new LinkedHashMap<>();
        BackupImportReporter.recordFailure(context, "account", "cookie", new IllegalArgumentException("bad schema"));
        assertEquals(1, BackupImportReporter.failuresFor(context, "account").size());
        assertEquals("cookie: bad schema", BackupImportReporter.failuresFor(context, "account").get(0));
    }
}
