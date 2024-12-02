package it.infocert.demoportal.beans;

import com.fasterxml.jackson.annotation.JsonAlias;

public class SelfQRCodeRes {

    @JsonAlias("process-id")
    String processId;

    public SelfQRCodeRes(String processId) {
        this.processId = processId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
