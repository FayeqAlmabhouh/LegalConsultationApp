package com.example.legalconsultationapp.MainPageHome.Model;

import com.example.legalconsultationapp.CatogeryModel.CatogeryStructure;
import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.example.legalconsultationapp.DataBaseModel.DataOpState;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class homPageModel {

    private DBOperation dbOperation;

    public homPageModel() {
        dbOperation = new DBOperation();
    }

    public DatabaseReference getCatogeryStructures() {
     return dbOperation.getCatogeryData();
    }

}
