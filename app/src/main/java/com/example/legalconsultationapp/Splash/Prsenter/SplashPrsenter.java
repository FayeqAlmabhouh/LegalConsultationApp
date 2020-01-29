package com.example.legalconsultationapp.Splash.Prsenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.Splash.Model.SplashModel;
import com.google.firebase.auth.FirebaseUser;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SplashPrsenter{

    private Activity activity;
    private SplashModel splashModel;
    public SplashPrsenter(Activity activity) {
        this.activity = activity;
        this.splashModel = new SplashModel();
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
                    UserLgIn ();
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
    private void UserLgIn ()
    {
       String userStat =  splashModel.HaveAcount();

       if (userStat.equals("100"))
       {
           GoToLogInPage();
       }else{
           ConstantPage.SkipButoon(activity);

       }



    }






}
