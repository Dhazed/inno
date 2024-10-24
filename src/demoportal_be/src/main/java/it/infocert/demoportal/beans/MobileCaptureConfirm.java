package it.infocert.demoportal.beans;

public class MobileCaptureConfirm {
    
    String idMobileSession;
    String status;

    public MobileCaptureConfirm(String idMobileSession, String status) {
        this.idMobileSession = idMobileSession;
        this.status = status;
    }
    public String getIdMobileSession() {
        return idMobileSession;
    }
    public void setIdMobileSession(String idMobileSession) {
        this.idMobileSession = idMobileSession;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
