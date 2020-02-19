package com.example.legalconsultationapp.MainPageHome.Model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.google.firebase.database.DatabaseReference;

public class homPageModel {

    private DBOperation dbOperation;

    public homPageModel() {
        dbOperation = new DBOperation();
    }

    public DatabaseReference getCatogeryStructures() {
        return dbOperation.getCatogeryData();
    }

}
