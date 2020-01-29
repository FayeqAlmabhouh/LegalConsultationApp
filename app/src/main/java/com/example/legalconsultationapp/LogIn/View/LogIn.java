package com.example.legalconsultationapp.LogIn.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.legalconsultationapp.LogIn.Prsenter.LogInPrsenter;
import com.example.legalconsultationapp.LogIn.Prsenter.ViewFunPrsenter;
import com.example.legalconsultationapp.R;

public class LogIn extends AppCompatActivity implements ViewFunPrsenter {





    private TextView vForgetPass , vNewAcount, vSkip;
    private LogInPrsenter prsenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);

        prsenter = new LogInPrsenter(this);
        vForgetPass = findViewById(R.id.logInForgetPass);
            vForgetPass.setOnClickListener(this::OnClick);
        vNewAcount = findViewById(R.id.logInNewUser);
            vNewAcount.setOnClickListener(this::OnClick);

        vSkip = findViewById(R.id.loginSkip);
        vSkip.setOnClickListener(this::OnClick);

    }
    @Override
    public void OnClick(View view){
        if (view == vForgetPass)
        {
            prsenter.GotToForgetPass();
        }
        if (view == vNewAcount)
        {
            prsenter.GotToNewAcount();
        }
        if (view == vSkip)
        {
            prsenter.SkipButoon();
        }



    }
}
