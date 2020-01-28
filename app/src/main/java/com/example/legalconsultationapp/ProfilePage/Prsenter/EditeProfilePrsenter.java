package com.example.legalconsultationapp.ProfilePage.Prsenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.ProfilePage.View.ProfileFragment;

public class EditeProfilePrsenter{


    private Activity activity;

    public EditeProfilePrsenter(Activity activity) {
        this.activity = activity;
    }

    public void BackToProfile (){
        ProfileFragment profileFragment = new ProfileFragment();
        activity.finish();
    }

    public void LogOut (){
        Intent logInpage = new Intent();
        logInpage.setClass(activity, LogIn.class);
        activity.startActivity(logInpage);

    }



}
