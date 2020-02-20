package com.example.legalconsultationapp.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.legalconsultationapp.MainPage.view.MainPage;
import com.example.legalconsultationapp.Search.View.SearchActivity;

import androidx.fragment.app.Fragment;

public class ConstantPage {

    private Fragment localpage;
    private Activity activity;

    public ConstantPage(Activity activity) {
        this.activity = activity;
    }

    public Fragment getLocalpage() {
        return localpage;
    }

    public void setLocalpage(Fragment localpage) {
        this.localpage = localpage;
    }

    public void OpenMainPage() {
        Intent mainPage = new Intent(this.activity, MainPage.class);
        this.activity.startActivity(mainPage);
        this.activity.finish();
    }

    public void OpenSerchPage() {
        Intent serchpage = new Intent(this.activity, SearchActivity.class);
        this.activity.startActivity(serchpage);
    }
}
