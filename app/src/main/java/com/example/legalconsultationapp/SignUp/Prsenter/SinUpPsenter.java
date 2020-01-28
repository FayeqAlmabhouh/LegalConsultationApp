package com.example.legalconsultationapp.SignUp.Prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.MainPage.View.MainPage;

public class SinUpPsenter {

    private Activity activity;


    public SinUpPsenter(Activity activity) {
        this.activity = activity;
    }

    public void GoBackToLogIn(){
        Intent logIn = new Intent();
        logIn.setClass(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }
    public   void SkipButoon (){
        ConstantPage.SkipButoon(activity);
    }
}
