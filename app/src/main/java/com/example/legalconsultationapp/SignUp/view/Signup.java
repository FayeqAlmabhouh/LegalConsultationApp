package com.example.legalconsultationapp.SignUp.view;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.legalconsultationapp.MainPage.View.MainPage;
import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.SignUp.prsenter.SinUpPsenter;
import com.example.legalconsultationapp.SignUp.prsenter.SinUpViewFun;
import com.google.android.material.snackbar.Snackbar;
import com.hbb20.CountryCodePicker;

public class Signup extends AppCompatActivity implements SinUpViewFun {


    private SinUpPsenter psenter;
    private ViewHolder viewHolder;
    private String sUserName, sUserEmail, sUserPassword, sUserComfiremPassword, sUserPoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        CallPrsenter();
        getViewData();
    }

    @Override
    public void OnClick(View view) {
        getViewData();
        if (view == viewHolder.haveAcount)
            psenter.GoBackToLogIn();
        if (view == viewHolder.vSkipBu)
            psenter.GoToMainPage();
        if (view == viewHolder.sinUpButton)
          psenter.ChakeUserDataIsNotEmpty(sUserName,sUserEmail,sUserPassword,sUserComfiremPassword,sUserPoneNumber);

    }

    @Override
    public void getViewData() {
        viewHolder = new ViewHolder(this);
        viewHolder.vSkipBu.setOnClickListener(this::OnClick);
        viewHolder.haveAcount.setOnClickListener(this::OnClick);
        viewHolder.sinUpButton.setOnClickListener(this::OnClick);
        sUserName = viewHolder.userName.getText().toString();
        sUserEmail = viewHolder.userEmail.getText().toString();
        sUserPoneNumber = viewHolder.userPhoneNumber.getText().toString();
        sUserPassword = viewHolder.userPassword.getText().toString();
        sUserComfiremPassword = viewHolder.cofirmPass.getText().toString();

    }

    @Override
    public void CallPrsenter() {
        this.psenter = new SinUpPsenter(this);
    }
}
