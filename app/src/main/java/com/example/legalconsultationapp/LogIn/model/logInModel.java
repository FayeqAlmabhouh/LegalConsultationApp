package com.example.legalconsultationapp.LogIn.model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.example.legalconsultationapp.UserModel.UserData;
import com.google.android.gms.tasks.Task;

public class logInModel {


    private DBOperation dbOperation;

    public logInModel() {
        dbOperation = new DBOperation();
    }


    public Task LogIn(String email, String password) {
        return dbOperation.logIn(email, password);
    }

    public UserData getUserData() {
        return dbOperation.getUserdata();
    }

}
