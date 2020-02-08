package com.example.legalconsultationapp.ProfilePage.model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.example.legalconsultationapp.UserModel.UserData;

public class UserProfileModel {


    private DBOperation dbOperation;

    public UserProfileModel() {
        this.dbOperation = new DBOperation();
    }

    public void SinOut() {
        dbOperation.Signout();
    }

    public void UpdateUserData(UserData userData) {
        dbOperation.UpdateUserData(userData);
    }


}
