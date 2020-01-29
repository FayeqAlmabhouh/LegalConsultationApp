package com.example.legalconsultationapp.Splash.prsenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.example.legalconsultationapp.LogIn.View.LogIn;

import java.util.Timer;
import java.util.TimerTask;

public class SplashPrsenter {
    private Activity activity;
    public SplashPrsenter(Activity activity) {
        this.activity = activity;
    }
    public void SplashTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                GoToLogInPage();
            }
        },500);
    }
    private void GoToLogInPage() {
        Intent logIn = new Intent(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();

    }
}
