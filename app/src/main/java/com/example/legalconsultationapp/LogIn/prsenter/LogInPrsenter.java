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
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;

public class LogInPrsenter {

    private Activity activity;
    private logInModel logInModel;
    private logInViewHolder viewHolder;
    private ConstantVariable constantVariable;
    private UserPreferences userPreferences;

    public LogInPrsenter(Activity activity) {
        this.activity = activity;
        this.logInModel = new logInModel();
        this.viewHolder = new logInViewHolder(activity);
        this.constantVariable = new ConstantVariable();
        this.userPreferences = new UserPreferences(activity);
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

    public void SkipButoon() {
        ConstantPage.OpenMainPage(activity);
    }

    private boolean chakeUserData(String email, String pass) {
        boolean state = true;

        if (email.isEmpty()) {
            AppUtils.setError(viewHolder.getEmail(), constantVariable.getEmpty_email());
            state = false;
        } else if (!(email.isEmpty()))
            state = AppUtils.isEmailValid(email);
        if (pass.isEmpty()) {
            AppUtils.setError(viewHolder.getPassword(), constantVariable.getEmpty_password());
            state = false;
        }
        return state;
    }

    public void SinInWithEmailandPassword(String email, String password) {
        boolean cheakeUserDta = chakeUserData(email, password);
        boolean ChakeInternetConection = AppUtils.checkConnection(activity);
        if (ChakeInternetConection == false)
            Snackbar.make(activity.findViewById(android.R.id.content), constantVariable.getNoInternet(), Snackbar.LENGTH_LONG).show();
        if (cheakeUserDta && ChakeInternetConection == true) {
            Task task = logInModel.LogIn(email, password);
            task.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()) {
                        SkipButoon();
                        //userPreferences.SaveUserData(logInModel.getUserData());

                    }else
                        Snackbar.make(activity.findViewById(android.R.id.content), "User Not Found", Snackbar.LENGTH_LONG).show();


                }
            });


            userPreferences.SaveUserData(logInModel.getUserData());

        }
    }


}
