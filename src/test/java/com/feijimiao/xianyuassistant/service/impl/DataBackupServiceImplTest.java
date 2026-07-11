package com.feijimiao.xianyuassistant.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijimiao.xianyuassistant.backup.BackupImportReporter;
import com.feijimiao.xianyuassistant.backup.DataBackupHandler;
import com.feijimiao.xianyuassistant.service.bo.BackupImportReqBO;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataBackupServiceImplTest {
    @Test
    void reportsRecordFailureAsModuleFailure() {
        DataBackupHandler handler = new DataBackupHandler() {
            public String getModuleKey() { return "account"; }
            public String getModuleName() { return "account"; }
            public Map<String, Object> exportData() { return Map.of(); }
            public void importData(Map<String, Object> data, Map<String, Object> context) {
                BackupImportReporter.recordFailure(context, "account", "cookie", new IllegalArgumentException("bad cookie"));
            }
        };
        DataBackupServiceImpl service = new DataBackupServiceImpl();
        ReflectionTestUtils.setField(service, "handlers", List.of(handler));
        ReflectionTestUtils.setField(service, "objectMapper", new ObjectMapper());
        BackupImportReqBO request = new BackupImportReqBO();
        request.setJsonData("{\"version\":\"1.0\",\"modules\":{\"account\":{\"cookies\":[]}}}");

        var response = service.importData(request);
        assertEquals(0, response.getSuccessCount());
        assertTrue(response.getFailedModules().contains("account"));
        assertEquals("cookie: bad cookie", response.getFailureDetails().get("account").get(0));
    }

    @Test
    void rejectsUnsupportedBackupSchemaVersion() {
        DataBackupServiceImpl service = new DataBackupServiceImpl();
        ReflectionTestUtils.setField(service, "handlers", List.of());
        ReflectionTestUtils.setField(service, "objectMapper", new ObjectMapper());
        BackupImportReqBO request = new BackupImportReqBO();
        request.setJsonData("{\"version\":\"999\",\"modules\":{}}");
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> service.importData(request));
    }
}
