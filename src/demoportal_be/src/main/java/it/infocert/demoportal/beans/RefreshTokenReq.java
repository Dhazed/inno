package it.infocert.demoportal.beans;

public class RefreshTokenReq {

    String sessionId;

    public RefreshTokenReq(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
