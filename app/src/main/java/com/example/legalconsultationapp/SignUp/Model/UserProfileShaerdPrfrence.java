package com.example.legalconsultationapp.SignUp.Model;

import android.content.Context;

public class UserProfileShaerdPrfrence{

    private static Context ctx;

    private static final String SHARED_PREF_NAME ="User Profile Dat";
    private static final String key_User_Email = "Email";
    private static final String key_User_Name = "Name";
    private static final String key_User_pasword = "password";
    private static final String key_User_PhoneNumper = "phoneNumper";

    public UserProfileShaerdPrfrence(Context context){
        this.ctx=context;
    }


    public void SaveUserData (String UserName , String UserPhoneNumber  ){

    }

















}
