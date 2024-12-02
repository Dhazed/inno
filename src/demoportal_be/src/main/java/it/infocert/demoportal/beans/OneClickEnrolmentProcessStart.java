package it.infocert.demoportal.beans;

public class OneClickEnrolmentProcessStart {
    
    String processStatus;
    String taskName;
    String taskId;
    String sessionKey;
    
    public OneClickEnrolmentProcessStart(String processStatus, String taskName, String taskId, String sessionKey) {
        this.processStatus = processStatus;
        this.taskName = taskName;
        this.taskId = taskId;
        this.sessionKey = sessionKey;
    }
    
    public String getProcessStatus() {
        return processStatus;
    }
    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
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
    public String getSessionKey() {
        return sessionKey;
    }
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
    
}
