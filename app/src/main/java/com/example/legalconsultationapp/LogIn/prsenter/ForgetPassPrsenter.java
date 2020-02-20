package com.example.legalconsultationapp.LogIn.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.LogIn.View.forgetPassViewHolder;
import com.example.legalconsultationapp.LogIn.model.logInModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;

public class ForgetPassPrsenter {

    private Activity activity;
    private logInModel logInModel;
    private AppUtils appUtils;
    private ConstantVariable constantVariable;
    private forgetPassViewHolder viewHolder;

    public ForgetPassPrsenter(Activity activity) {
        this.activity = activity;
        this.logInModel = new logInModel();
        this.appUtils = new AppUtils(activity);
        this.constantVariable = new ConstantVariable();
        this.viewHolder = new forgetPassViewHolder(activity);

    }

    public void GoBackToLogIn() {
        Intent logIn = new Intent(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }


    private boolean checkeEmailFiled(String email) {
        boolean state = true;
        if (email.isEmpty()) {
            appUtils.setError(viewHolder.getuEmail(), constantVariable.getEmpty_email());
            state = false;
        } else {
            state = appUtils.isEmailValid(email);
            if (state == false)
                appUtils.setError(viewHolder.getuEmail(), constantVariable.getEmpty_email());
        }
        return state;


    }

    private void UserResetPasswor(String email) {
        appUtils.ShowDialog();
        Task task = logInModel.resetPass(email).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    appUtils.SnackbareStyle(constantVariable.getPassSendeItToEmail());
                    GoBackToLogIn();
                } else
                    appUtils.SnackbareStyle(task.getException().toString());

            }
        });
    }
    public void  SendUserPass (String email){

        boolean chakeInternt = appUtils.checkConnection();
        boolean chakeUserDta = checkeEmailFiled(email);
        if (chakeInternt == false)
            appUtils.SnackbareStyle(constantVariable.getNoInternet());
        if (chakeInternt && chakeUserDta == true)
            UserResetPasswor(email);


    }

}
