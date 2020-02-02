package com.example.legalconsultationapp.SignUp.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SinUpModel {
    private Context ctx;
    private UserInfo userInfo;
    private final String SHARED_PREF_NAME = "User Profile Dat";
    private final String key_User_Email = "Email";
    private final String key_User_Name = "Name";
    private final String key_User_PhoneNumper = "phoneNumper";

    public SinUpModel(Context ctx) {
        this.ctx = ctx;
        this.userInfo = new UserInfo();
    }

    public void SaveUserData(UserInfo userInfo) {
        SharedPreferences saveUserData = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saveUserData.edit();
        editor.putString(key_User_Email, userInfo.getuEmail());
        editor.putString(key_User_Name, userInfo.getuName());
        editor.putString(key_User_PhoneNumper, userInfo.getuPhoneNumper());
        editor.apply();
    }
}
