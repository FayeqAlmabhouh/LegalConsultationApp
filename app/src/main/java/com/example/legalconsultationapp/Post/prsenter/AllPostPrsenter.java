package com.example.legalconsultationapp.Post.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.SubCategories.view.SubCategories;

public class AllPostPrsenter {
    private Activity activity;
    private AppUtils appUtils;
    private ConstantPage constantPage;

    public AllPostPrsenter(Activity activity) {
        this.activity = activity;
        this.appUtils = new AppUtils(this.activity);
        this.constantPage = new ConstantPage(this.activity);
    }

    public void OpenSerchPage() {
        constantPage.OpenSerchPage();
    }

    public void BackToCatogryPage() {
        Intent catogryPage = new Intent(this.activity, SubCategories.class);
        this.activity.startActivity(catogryPage);
        this.activity.finish();
    }


}
