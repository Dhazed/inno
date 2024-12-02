package it.infocert.demoportal.beans;

public class SelfQRequest {
    
    String email;
    String phoneNumber;
    String dossierType;

    public String getDossierType() {
        return dossierType;
    }
    public void setDossierType(String dossierType) {
        this.dossierType = dossierType;
    }
    String lang;
    
    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
    public SelfQRequest(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
