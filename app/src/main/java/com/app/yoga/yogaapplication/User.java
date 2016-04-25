package com.app.yoga.yogaapplication;

/**
 * Created by Lenovo on 4/24/2016.
 */
public class User {
    private String facebookID;
    private String email;
    private String name;
    private String gender;

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String _facebookID) {
        this.facebookID = _facebookID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
