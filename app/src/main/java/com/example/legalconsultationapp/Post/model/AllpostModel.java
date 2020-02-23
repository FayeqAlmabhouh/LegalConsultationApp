package com.example.legalconsultationapp.Post.model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.google.firebase.database.DatabaseReference;

public class AllpostModel {

    private DBOperation dbOperation;

    public AllpostModel() {
        dbOperation = new DBOperation();
    }

    public DatabaseReference getPosts() {
        return dbOperation.getPost();
    }
    
    public DatabaseReference getPostDetiles (){
        return dbOperation.getPost();
    }
    
    
}
