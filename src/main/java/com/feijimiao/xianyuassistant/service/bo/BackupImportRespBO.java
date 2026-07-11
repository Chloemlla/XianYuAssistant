package com.feijimiao.xianyuassistant.service.bo;

import lombok.Data;

@Data
public class BackupImportRespBO {
    private int totalCount;
    private int successCount;
    private java.util.List<String> failedModules;
    private java.util.Map<String, java.util.List<String>> failureDetails;
}
