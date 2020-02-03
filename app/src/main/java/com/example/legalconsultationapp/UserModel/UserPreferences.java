package com.example.legalconsultationapp.UserModel;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.legalconsultationapp.Constant.ConstantVariable;

public class UserPreferences {

    private ConstantVariable constantVariable;
    private Context context;

    public UserPreferences(Context context) {
        constantVariable = new ConstantVariable();
        this.context = context;
    }

    public void SaveUserData(UserInfo userInfo) {
        SharedPreferences saveUserData = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saveUserData.edit();
        editor.putString(constantVariable.getKey_User_Email(), userInfo.getuEmail());
        editor.putString(constantVariable.getKey_User_Name(), userInfo.getuName());
        editor.putString(constantVariable.getKey_User_PhoneNumper(), userInfo.getuPhoneNumper());
        editor.apply();
    }

    public String getUserName() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        return sharedPreferences.getString(constantVariable.getDB_UserName(), null);
    }

    public String getUserEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        return sharedPreferences.getString(constantVariable.getDB_UserEmail(), null);
    }

    public String getUserPhone() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        return sharedPreferences.getString(constantVariable.getDB_UserPhoneNumber(), null);
    }

    public void ClearuserTempData() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
