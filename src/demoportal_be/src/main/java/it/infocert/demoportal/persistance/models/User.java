package it.infocert.demoportal.persistance.models;

public class User {

    public String userid;
    public String name;
    public String surname;
    public String company;
    public String status;

     public User(String userid, String name, String surname, String company, String status) {
        this.userid = userid;
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.status = status;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
