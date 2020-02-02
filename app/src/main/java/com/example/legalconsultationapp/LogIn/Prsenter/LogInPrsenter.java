package com.example.legalconsultationapp.LogIn.Prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.LogIn.View.ForgetPassword;
import com.example.legalconsultationapp.SignUp.view.Signup;

public class LogInPrsenter {

    private Activity activity;

    public LogInPrsenter(Activity activity) {
        this.activity = activity;
    }

    public void GotToForgetPass() {
        Intent forgetPass = new Intent();
        forgetPass.setClass(activity, ForgetPassword.class);
        activity.startActivity(forgetPass);
        activity.finish();
    }

    public void GotToNewAcount() {
        Intent forgetPass = new Intent();
        forgetPass.setClass(activity, Signup.class);
        activity.startActivity(forgetPass);
        activity.finish();
    }

    public void SkipButoon() {
        ConstantPage.SkipButoon(activity);
    }
}
