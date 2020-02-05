package com.example.legalconsultationapp.UserModel;

public class UserData {


    private String Email;
    private String PhoneNumber;
    private String UserName;


    public UserData(String email, String phoneNumber, String userName) {
        Email = email;
        PhoneNumber = phoneNumber;
        UserName = userName;
    }

    public UserData() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
