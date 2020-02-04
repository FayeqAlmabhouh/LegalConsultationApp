package com.example.legalconsultationapp.MainPageHome.Prsenter;

import android.content.Context;

import com.example.legalconsultationapp.Constant.ConstantPage;

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
