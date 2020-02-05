package com.example.legalconsultationapp.LogIn.View;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class logInViewHolder {

    private Activity activity;


    public logInViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this,activity);
    }

    @BindView(R.id.logInEmail)
    protected EditText email;
    @BindView(R.id.logInPass)
    protected EditText password;
    @BindView(R.id.logInBu)
    protected Button logInBu;
    @BindView(R.id.logInForgetPass)
    protected TextView forgetPass;
    @BindView(R.id.logInNewUser)
    protected TextView newUser;
    @BindView(R.id.loginSkip)
    protected TextView skip;

    public EditText getEmail() {
        return email;
    }

    public void setEmail(EditText email) {
        this.email = email;
    }

    public EditText getPassword() {
        return password;
    }

    public void setPassword(EditText password) {
        this.password = password;
    }

    public Button getLogInBu() {
        return logInBu;
    }

    public void setLogInBu(Button logInBu) {
        this.logInBu = logInBu;
    }

    public TextView getForgetPass() {
        return forgetPass;
    }

    public void setForgetPass(TextView forgetPass) {
        this.forgetPass = forgetPass;
    }

    public TextView getNewUser() {
        return newUser;
    }

    public void setNewUser(TextView newUser) {
        this.newUser = newUser;
    }

    public TextView getSkip() {
        return skip;
    }

    public void setSkip(TextView skip) {
        this.skip = skip;
    }
}
