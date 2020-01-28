package com.example.legalconsultationapp.SignUp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.SignUp.Prsenter.SinUpPsenter;
import com.example.legalconsultationapp.SignUp.Prsenter.SinUpViewFun;

public class Signup extends AppCompatActivity implements SinUpViewFun {
    private SinUpPsenter psenter;
    private TextView vhaveAcount , vSkipbu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        psenter = new SinUpPsenter(this);
        vhaveAcount = findViewById(R.id.SinUpHaveAccount);
            vhaveAcount.setOnClickListener(this::OnClick);
        vSkipbu = findViewById(R.id.SinUpSkip);
            vSkipbu.setOnClickListener(this::OnClick);

    }
    @Override
    public void OnClick(View view) {
        if (view == vhaveAcount)
        {
            psenter.GoBackToLogIn();
        }
        if (view == vSkipbu)
        {
            psenter.SkipButoon();
        }

    }
}
