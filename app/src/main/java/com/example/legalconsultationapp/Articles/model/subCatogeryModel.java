package com.example.legalconsultationapp.Articles.model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.google.firebase.database.DatabaseReference;

public class subCatogeryModel {

    private DBOperation dbOperation;

    public subCatogeryModel() {
        dbOperation = new DBOperation();
    }

    public DatabaseReference getSubCatogeryData(){
        return dbOperation.getSubCatogeryData();
    }

}
