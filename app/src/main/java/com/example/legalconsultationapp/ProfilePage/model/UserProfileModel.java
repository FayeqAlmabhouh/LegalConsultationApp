package com.example.legalconsultationapp.ProfilePage.model;

import android.app.Activity;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.example.legalconsultationapp.UserModel.UserData;
import com.google.android.gms.tasks.Task;

public class UserProfileModel {


    private DBOperation dbOperation;

    public UserProfileModel() {
        this.dbOperation = new DBOperation();
    }

    public void SinOut() {
        dbOperation.Signout();
    }

    public Task UpdateUserData(UserData userData) {
        return dbOperation.UpdateUserData(userData);
    }

    public void getUserData(Activity activity) {
        dbOperation.getUserdata(activity);
    }

}
