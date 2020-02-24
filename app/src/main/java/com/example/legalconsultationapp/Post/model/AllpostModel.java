package com.example.legalconsultationapp.Post.model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.Query;

public class AllpostModel {

    private DBOperation dbOperation;

    public AllpostModel() {
        dbOperation = new DBOperation();
    }


    public DatabaseReference getPostDetiles() {
        return dbOperation.getPost();
    }


}
