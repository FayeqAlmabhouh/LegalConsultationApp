package com.example.legalconsultationapp.UserModel;

public class UserInfo {

    private String uName;
    private String uEmail;
    private String uPassword;
    private String uPhoneNumper;
    private String uComfarmpass;

    public UserInfo(String uName, String uEmail, String uPassword, String uPhoneNumper) {
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPassword = uPassword;
        this.uPhoneNumper = uPhoneNumper;
    }

    public UserInfo() {
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPhoneNumper() {
        return uPhoneNumper;
    }

    public void setuPhoneNumper(String uPhoneNumper) {
        this.uPhoneNumper = uPhoneNumper;
    }

    public String getuComfarmpass() {
        return uComfarmpass;
    }

    public void setuComfarmpass(String uComfarmpass) {
        this.uComfarmpass = uComfarmpass;
    }
}
