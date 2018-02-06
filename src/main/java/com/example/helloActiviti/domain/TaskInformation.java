package com.example.helloActiviti.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by guang.yang on 2017-11-08.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskInformation {
    private String taskId;
    private String taskInfo;
    private String status;
    private String taskName;
    private String taskExcuteId;

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    private String processDefinitionId;


    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getTaskExcuteId() {
        return taskExcuteId;
    }

    public void setTaskExcuteId(String taskExcuteId) {
        this.taskExcuteId = taskExcuteId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
