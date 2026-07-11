package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 操作记录实体
 */
@Data
@Document(collection = "xianyu_operation_log")
@CompoundIndex(name = "idx_operation_account_created", def = "{'xianyuAccountId': 1, 'createTime': -1}")
public class XianyuOperationLog {
    
    @Id
    private Long id;
    
    /**
     * 账号ID
     */
    private Long xianyuAccountId;
    
    /**
     * 操作类型
     */
    private String operationType;
    
    /**
     * 操作模块
     */
    private String operationModule;
    
    /**
     * 操作描述
     */
    private String operationDesc;
    
    /**
     * 操作状态：1-成功，0-失败，2-部分成功
     */
    private Integer operationStatus;
    
    /**
     * 目标类型
     */
    private String targetType;
    
    /**
     * 目标ID
     */
    private String targetId;
    
    /**
     * 请求参数（JSON格式）
     */
    private String requestParams;
    
    /**
     * 响应结果（JSON格式）
     */
    private String responseResult;
    
    /**
     * 错误信息
     */
    private String errorMessage;
    
    /**
     * IP地址
     */
    private String ipAddress;
    
    /**
     * 浏览器UA
     */
    private String userAgent;
    
    /**
     * 操作耗时（毫秒）
     */
    private Integer durationMs;
    
    /**
     * 创建时间（时间戳，毫秒）
     */
    private Long createTime;
}
