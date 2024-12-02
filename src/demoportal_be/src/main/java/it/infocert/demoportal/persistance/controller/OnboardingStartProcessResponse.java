package it.infocert.demoportal.persistance.controller;

public class OnboardingStartProcessResponse {

    public String sessionId;
    public String token;
    public String refreshToken;
    public String id;


    public OnboardingStartProcessResponse(String sessionId, String token, String refreshToken, String id) {
        this.sessionId = sessionId;
        this.token = token;
        this.refreshToken = refreshToken;
        this.id = id;
    }
    
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
}
