package com.example.legalconsultationapp.Splash.Prsenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.LogIn.View.LogIn;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SplashPrsenter{

    private Activity activity;

    public SplashPrsenter(Activity activity) {
        this.activity = activity;
    }
    public void isNetworkAvailable()
    {
        Timer timer = new Timer();
        boolean isNetworkConnect = AppUtils.checkConnection(activity);
        if (isNetworkConnect == true)
        {
            timer.schedule(new TimerTask() {
                @Override
                public void run(){
                   GoToLogInPage();
                }
            },500);
        }else{
            Toast.makeText(activity, "Check Internet Connection",Toast.LENGTH_LONG).show();
        }
    }
    private  void GoToLogInPage()
    {
        Intent logIn = new Intent();
        logIn.setClass(activity.getApplicationContext(), LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }






}
