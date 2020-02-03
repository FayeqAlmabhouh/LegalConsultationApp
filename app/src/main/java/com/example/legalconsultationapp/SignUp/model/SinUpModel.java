package com.example.legalconsultationapp.SignUp.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.legalconsultationapp.UserModel.UserInfo;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.google.android.gms.tasks.Task;

public class SinUpModel {

    private ConstantVariable constantVariable;
    private DBOperation dbOperation;

    public SinUpModel() {
        dbOperation = new DBOperation();
        constantVariable = new ConstantVariable();
    }

    public void SaveUserData(Context context, UserInfo userInfo) {
        SharedPreferences saveUserData = context.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saveUserData.edit();
        editor.putString(constantVariable.getKey_User_Email(), userInfo.getuEmail());
        editor.putString(constantVariable.getKey_User_Name(), userInfo.getuName());
        editor.putString(constantVariable.getKey_User_PhoneNumper(), userInfo.getuPhoneNumper());
        editor.apply();
    }

    public Task CreateAccount(UserInfo userInfo) {
        return dbOperation.CreateNewUsers(userInfo.getuEmail(), userInfo.getuPassword());
    }

    public Task SavDataToDataBase(UserInfo userInfo) {
        return dbOperation.SaveUserDataInDB(userInfo);
    }


}
