package com.example.legalconsultationapp.LogIn.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.LogIn.View.ForgetPassword;
import com.example.legalconsultationapp.LogIn.View.logInViewHolder;
import com.example.legalconsultationapp.LogIn.model.logInModel;
import com.example.legalconsultationapp.SignUp.view.Signup;
import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;

public class LogInPrsenter {

    private Activity activity;
    private logInModel logInModel;
    private logInViewHolder viewHolder;
    private ConstantVariable constantVariable;
    private UserPreferences userPreferences;
    private AppUtils appUtils;
    private ConstantPage constantPage;

    public LogInPrsenter(Activity activity) {
        this.activity = activity;
        this.logInModel = new logInModel();
        this.viewHolder = new logInViewHolder(activity);
        this.constantVariable = new ConstantVariable();
        this.userPreferences = new UserPreferences(activity);
        this.appUtils = new AppUtils(this.activity);
        this.constantPage = new ConstantPage(this.activity);
    }

    public void GotToForgetPass() {
        Intent forgetPass = new Intent(activity, ForgetPassword.class);
        activity.startActivity(forgetPass);
        activity.finish();
    }

    public void GotToNewAcount() {
        Intent forgetPass = new Intent(activity, Signup.class);
        activity.startActivity(forgetPass);
        activity.finish();
    }

    public void MainPageButoon() {
        constantPage.OpenMainPage();
    }

    private boolean chakeUserData(String email, String pass) {
        boolean state = true;
        if (email.isEmpty()) {
            appUtils.setError(viewHolder.getEmail(), constantVariable.getEmpty_email());
            state = false;
        } else {
            state = appUtils.isEmailValid(email);
            if (state == false)
                appUtils.setError(viewHolder.getEmail(), constantVariable.getEmpty_email());
        }
        if (pass.isEmpty()) {
            appUtils.setError(viewHolder.getPassword(), constantVariable.getEmpty_password());
            state = false;
        }
        return state;
    }

    public void SinInWithEmailandPassword(String email, String password) {
        boolean CheckUserDta = chakeUserData(email, password);
        boolean CheckeInternetConection = appUtils.checkConnection();
        if (CheckeInternetConection == false)
            appUtils.SnackbareStyle(constantVariable.getNoInternet());
        if (CheckUserDta && CheckeInternetConection == true) {
            appUtils.ShowLoadingDialogue();
            Task task = logInModel.LogIn(email, password);
            task.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()) {
                        updateUserViewData();
                        MainPageButoon();
                    } else {
                        appUtils.SnackbareStyle(task.getException().toString());
                        appUtils.dialogDismiss();
                    }
                }
            });


        }
    }

    public void updateUserViewData() {

        logInModel.getUserData(activity);

    }

}
