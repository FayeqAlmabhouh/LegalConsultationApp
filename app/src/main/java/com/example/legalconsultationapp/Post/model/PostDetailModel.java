package com.example.legalconsultationapp.Post.model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.google.android.gms.tasks.Task;

public class PostDetailModel {

    DBOperation dbOperation;

    public PostDetailModel() {
        dbOperation = new DBOperation();
    }

    public Task addFavertPost(String postId) {
        return dbOperation.SaveFavertPost(postId);
    }

    public Task removeFavertPost(String posId) {
        return this.dbOperation.removeFavertPost(posId);
    }


}
