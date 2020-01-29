package com.example.legalconsultationapp.MainPageHome.Prsenter;

import android.app.Activity;
import android.content.Context;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.MainPageHome.View.HomeFragment;

public class HomePrsenter{

    private Context activity;

    public HomePrsenter(Context activity) {
        this.activity = activity;
    }

    public  void goToSerchPage(){
        //ConstantPage.localpage = new HomeFragment();
        ConstantPage.OpenSerchPage(activity);
    }





}
