package it.infocert.demoportal.beans.isac;

import java.util.ArrayList;

public class IsacIdentity{

    public String id;
    public String accountId;
    public boolean professionalUse = false;
    public String type = "NORMAL";
    public State state = new State();
    public ArrayList<Capability> capabilities;
    public Credential credential;
    public SecurityInformation securityInformation;
    public String description;

    public IsacIdentity(String id, String accountId, Credential credential,SecurityInformation securityInformation) {
        this.capabilities.add(new Capability());
        this.id = id;
        this.accountId = accountId;
        this.credential = credential;
        this.securityInformation = securityInformation;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public boolean isProfessionalUse() {
        return professionalUse;
    }
    public void setProfessionalUse(boolean professionalUse) {
        this.professionalUse = professionalUse;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public ArrayList<Capability> getCapabilities() {
        return capabilities;
    }
    public void setCapabilities(ArrayList<Capability> capabilities) {
        this.capabilities = capabilities;
    }
    public Credential getCredential() {
        return credential;
    }
    public void setCredential(Credential credential) {
        this.credential = credential;
    }
    public SecurityInformation getSecurityInformation() {
        return securityInformation;
    }
    public void setSecurityInformation(SecurityInformation securityInformation) {
        this.securityInformation = securityInformation;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
