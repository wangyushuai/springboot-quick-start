package com.example.springboot.domain;

import java.util.Date;

/**
 * 操作日志模型
 * @author wangyushuai2@jd.com
 * @date 2019/2/19
 */
public class OperationLog {
    /**
     * 操作类型
     */
    private String operationType;
    /**
     * 操作记录
     */
    private String operationRecord;
    /**
     * 开始时间
     */
    private Date startTime;


    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationRecord() {
        return operationRecord;
    }

    public void setOperationRecord(String operationRecord) {
        this.operationRecord = operationRecord;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
