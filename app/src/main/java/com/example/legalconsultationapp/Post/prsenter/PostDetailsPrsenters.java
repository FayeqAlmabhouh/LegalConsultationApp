package com.example.legalconsultationapp.Post.prsenter;

import android.app.Activity;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Post.model.PostDetailModel;

public class PostDetailsPrsenters {

    private Activity activity;
    private AppUtils appUtils;
    private PostDetailModel model;

    public PostDetailsPrsenters(Activity activity) {
        this.activity = activity;
        this.appUtils = new AppUtils(this.activity);
        this.model = new PostDetailModel();
    }





}
