package com.example.legalconsultationapp.LogIn.Prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.LogIn.View.LogIn;

public class ForgetPassPrsenter{

    private Activity activity;

    public ForgetPassPrsenter(Activity activity) {
        this.activity = activity;
    }


    public void GoBackToLogIn(){
        Intent logIn = new Intent();
        logIn.setClass(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }




}
