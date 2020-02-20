package com.example.legalconsultationapp.Splash.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.UserModel.UserPreferences;

import java.util.Timer;
import java.util.TimerTask;

public class SplashPrsenter {
    private Activity activity;
    private UserPreferences userPreferences;
    private ConstantPage constantPage;

    public SplashPrsenter(Activity activity) {
        this.activity = activity;
        this.userPreferences = new UserPreferences(activity);
        this.constantPage = new ConstantPage(this.activity);
    }

    public void SplashTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean chakeUserLogedIn = UserhaveAcount();
                if (chakeUserLogedIn == true)
                    constantPage.OpenMainPage();
                else
                    GoToLogInPage();
            }
        }, 500);
    }

    private void GoToLogInPage() {
        Intent logIn = new Intent(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }


    private boolean UserhaveAcount() {
        return userPreferences.IsUserlogedIN();
    }


}
