package it.infocert.demoportal.beans.isac;

public class Credential{
    
    public String nickname;
    public String password;
    public boolean hashed = false;
    public String policy = "none";
    public String state = "ACTIVE";
    
    public Credential() {
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isHashed() {
        return hashed;
    }
    public void setHashed(boolean hashed) {
        this.hashed = hashed;
    }
    public String getPolicy() {
        return policy;
    }
    public void setPolicy(String policy) {
        this.policy = policy;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}
