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

    public void SaveUserData(UserData userData) {
        SharedPreferences saveUserData = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saveUserData.edit();
        editor.putString(constantVariable.getKey_User_Email(), userData.getEmail());
        editor.putString(constantVariable.getKey_User_Name(), userData.getUserName());
        editor.putString(constantVariable.getKey_User_PhoneNumper(), userData.getPhoneNumber());
        editor.apply();
    }

    public String getUserName() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        return sharedPreferences.getString(constantVariable.getKey_User_Name(), null);
    }

    public String getUserEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        return sharedPreferences.getString(constantVariable.getKey_User_Email(), null);
    }

    public String getUserPhone() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        return sharedPreferences.getString(constantVariable.getKey_User_PhoneNumper(), null);
    }

    public boolean IsUserlogedIN() {
        SharedPreferences userHaveAcount = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), context.MODE_PRIVATE);
        if (userHaveAcount.getString(constantVariable.getKey_User_Name(), null) != null)
            return true;
        return false;
    }

    public void logOut() {
        SharedPreferences logOut = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), context.MODE_PRIVATE);
        SharedPreferences.Editor editor = logOut.edit();
        editor.clear();
        editor.apply();
    }

}
