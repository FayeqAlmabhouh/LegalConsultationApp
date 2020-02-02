package com.example.legalconsultationapp.LogIn.View;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.legalconsultationapp.LogIn.Prsenter.LogInPrsenter;
import com.example.legalconsultationapp.LogIn.Prsenter.ViewFunPrsenter;
import com.example.legalconsultationapp.R;
public class LogIn extends AppCompatActivity implements ViewFunPrsenter {

    @BindView(R.id.logInForgetPass)
        TextView forgetBaas;

    private TextView vForgetPass, vNewAcount, vSkip;
    private LogInPrsenter prsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);


        ButterKnife.bind(this);
        forgetBaas.setOnClickListener(this::OnClick);

        prsenter = new LogInPrsenter(this);
        vForgetPass = findViewById(R.id.logInForgetPass);

        vNewAcount = findViewById(R.id.logInNewUser);
        vNewAcount.setOnClickListener(this::OnClick);

        vSkip = findViewById(R.id.loginSkip);
        vSkip.setOnClickListener(this::OnClick);

    }

    @Override
    public void OnClick(View view) {
        if (view == forgetBaas) {
            prsenter.GotToForgetPass();
        }
        if (view == vNewAcount) {
            prsenter.GotToNewAcount();
        }
        if (view == vSkip) {
            prsenter.SkipButoon();
        }


    }
}
