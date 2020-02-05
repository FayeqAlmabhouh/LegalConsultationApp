package com.example.legalconsultationapp.LogIn.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.legalconsultationapp.LogIn.prsenter.ForgetPassPrsenter;
import com.example.legalconsultationapp.LogIn.prsenter.ViewFunPrsenter;
import com.example.legalconsultationapp.R;

public class ForgetPassword extends AppCompatActivity implements ViewFunPrsenter {


    private TextView vBackToLogIn;
    private ForgetPassPrsenter prsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_activity);
        prsenter = new ForgetPassPrsenter(this);
        vBackToLogIn = findViewById(R.id.forgepassback);
            vBackToLogIn.setOnClickListener(this::OnClick);
    }
    @Override
    public void OnClick(View view){
        if (view == vBackToLogIn)
        {
            prsenter.GoBackToLogIn();
        }


    }

    @Override
    public void initOnStatrt() {

    }

    @Override
    public void initVaripel() {

    }
}
