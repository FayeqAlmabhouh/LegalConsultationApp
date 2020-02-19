package com.example.legalconsultationapp.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.legalconsultationapp.MainPage.view.MainPage;
import com.example.legalconsultationapp.Search.View.SearchActivity;

import androidx.fragment.app.Fragment;

public class ConstantPage {

    private Fragment localpage;


    public Fragment getLocalpage() {
        return localpage;
    }

    public void setLocalpage(Fragment localpage) {
        this.localpage = localpage;
    }

    public static void OpenMainPage(Activity activity) {
        Intent mainPage = new Intent(activity, MainPage.class);
        activity.startActivity(mainPage);
        activity.finish();
    }

    public static void OpenSerchPage(Context activity) {
        Intent serchpage = new Intent();
        serchpage.setClass(activity, SearchActivity.class);
        activity.startActivity(serchpage);
    }
}
