package com.example.legalconsultationapp.ProfilePage.model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;

public class UserProfileModel {


    DBOperation dbOperation;

    public UserProfileModel() {
        this.dbOperation = new DBOperation();
    }

    public void SinOut() {
        dbOperation.Signout();
    }
}
