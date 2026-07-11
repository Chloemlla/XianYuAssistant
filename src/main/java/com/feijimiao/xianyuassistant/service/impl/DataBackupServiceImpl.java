package com.feijimiao.xianyuassistant.service.impl;

import com.feijimiao.xianyuassistant.backup.DataBackupHandler;
import com.feijimiao.xianyuassistant.backup.BackupImportReporter;
import com.feijimiao.xianyuassistant.service.DataBackupService;
import com.feijimiao.xianyuassistant.service.bo.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Service
public class DataBackupServiceImpl implements DataBackupService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Autowired
    private List<DataBackupHandler> handlers;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<BackupModuleRespBO> getModules() {
        List<BackupModuleRespBO> result = new ArrayList<>();
        for (DataBackupHandler handler : handlers) {
            BackupModuleRespBO bo = new BackupModuleRespBO();
            bo.setModuleKey(handler.getModuleKey());
            bo.setModuleName(handler.getModuleName());
            result.add(bo);
        }
        return result;
    }

    @Override
    public BackupExportRespBO exportData(BackupExportReqBO reqBO) {
        List<String> selectedModules = reqBO.getModules();
        Map<String, Object> allData = new LinkedHashMap<>();
        allData.put("exportTime", LocalDateTime.now().format(FORMATTER));
        allData.put("version", "1.0");

        Map<String, Object> modulesData = new LinkedHashMap<>();
        for (DataBackupHandler handler : handlers) {
            if (selectedModules != null && !selectedModules.contains(handler.getModuleKey())) {
                continue;
            }
            try {
                Map<String, Object> moduleData = handler.exportData();
                modulesData.put(handler.getModuleKey(), moduleData);
                log.info("[DataBackup] 导出模块 {} 成功", handler.getModuleKey());
            } catch (Exception e) {
                log.error("[DataBackup] 导出模块 {} 失败", handler.getModuleKey(), e);
                modulesData.put(handler.getModuleKey(), Map.of("_error", e.getMessage()));
            }
        }
        allData.put("modules", modulesData);

        try {
            BackupExportRespBO respBO = new BackupExportRespBO();
            respBO.setJsonData(objectMapper.writeValueAsString(allData));
            return respBO;
        } catch (Exception e) {
            throw new RuntimeException("序列化备份数据失败: " + e.getMessage(), e);
        }
    }

    @Override
    public BackupImportRespBO importData(BackupImportReqBO reqBO) {
        BackupImportRespBO respBO = new BackupImportRespBO();
        List<String> failedModules = new ArrayList<>();
        int totalCount = 0;
        int successCount = 0;
        Map<String, List<String>> failureDetails = new LinkedHashMap<>();

        Map<String, Object> allData;
        try {
            allData = objectMapper.readValue(reqBO.getJsonData(), new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new RuntimeException("解析备份数据失败: " + e.getMessage(), e);
        }
        Object version = allData.get("version");
        if (version == null || !"1.0".equals(String.valueOf(version))) {
            throw new RuntimeException("不支持的备份版本: " + version);
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> modulesData = (Map<String, Object>) allData.get("modules");
        if (modulesData == null) {
            throw new RuntimeException("备份数据格式错误: 缺少 modules 字段");
        }

        List<String> selectedModules = reqBO.getModules();

        Map<String, DataBackupHandler> handlerMap = new LinkedHashMap<>();
        for (DataBackupHandler handler : handlers) {
            handlerMap.put(handler.getModuleKey(), handler);
        }

        Map<String, Object> importContext = new LinkedHashMap<>();

        for (String moduleKey : modulesData.keySet()) {
            if (moduleKey.startsWith("_")) continue;
            if (selectedModules != null && !selectedModules.contains(moduleKey)) continue;

            DataBackupHandler handler = handlerMap.get(moduleKey);
            if (handler == null) {
                log.warn("[DataBackup] 未找到模块 {} 的处理器，跳过", moduleKey);
                continue;
            }

            totalCount++;
            try {
                @SuppressWarnings("unchecked")
                Map<String, Object> moduleData = (Map<String, Object>) modulesData.get(moduleKey);
                if (moduleData == null || moduleData.containsKey("_error")) {
                    throw new IllegalArgumentException("模块数据为空或导出时已失败");
                }
                handler.importData(moduleData, importContext);
                List<String> recordFailures = BackupImportReporter.failuresFor(importContext, moduleKey);
                if (recordFailures.isEmpty()) {
                    successCount++;
                    log.info("[DataBackup] 导入模块 {} 成功", moduleKey);
                } else {
                    failedModules.add(moduleKey);
                    failureDetails.put(moduleKey, recordFailures);
                    log.warn("[DataBackup] 导入模块 {} 存在 {} 条失败记录", moduleKey, recordFailures.size());
                }
            } catch (Exception e) {
                failedModules.add(moduleKey);
                failureDetails.put(moduleKey, List.of(e.getMessage() == null ? e.getClass().getSimpleName() : e.getMessage()));
                log.error("[DataBackup] 导入模块 {} 失败", moduleKey, e);
            }
        }

        respBO.setTotalCount(totalCount);
        respBO.setSuccessCount(successCount);
        respBO.setFailedModules(failedModules);
        respBO.setFailureDetails(failureDetails);
        return respBO;
    }
}
