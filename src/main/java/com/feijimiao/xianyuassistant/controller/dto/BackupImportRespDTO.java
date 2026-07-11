package com.feijimiao.xianyuassistant.controller.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BackupImportRespDTO {
    private int totalCount;
    private int successCount;
    private List<String> failedModules;
    private Map<String, List<String>> failureDetails;
}
