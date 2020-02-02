package com.example.legalconsultationapp.SignUp.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.legalconsultationapp.R;
import com.hbb20.CountryCodePicker;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolder {
    private Activity view;

    public ViewHolder(Activity view) {
        this.view = view;
        ButterKnife.bind(this, view);
    }

    @BindView(R.id.SinUpSkip)
    protected TextView vSkipBu;
    @BindView(R.id.SinUpHaveAccount)
    protected TextView haveAcount;
    @BindView(R.id.SinUpEmail)
    protected EditText userEmail;
    @BindView(R.id.SinUpName)
    protected EditText userName;
    @BindView(R.id.SinUpPassword)
    protected EditText userPassword;
    @BindView(R.id.SinUpConfirmPassword)
    protected EditText cofirmPass;
    @BindView(R.id.SinUpPhoneNumber)
    protected EditText userPhoneNumber;
    @BindView(R.id.SinUpCCP)
    protected CountryCodePicker ccp;
    @BindView(R.id.SinUpBu)
    protected Button sinUpButton;
}
