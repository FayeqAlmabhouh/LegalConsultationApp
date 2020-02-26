package com.example.legalconsultationapp.LogIn.View;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.LogIn.prsenter.LogInPrsenter;
import com.example.legalconsultationapp.LogIn.prsenter.ViewFunPrsenter;
import com.example.legalconsultationapp.R;

public class LogIn extends AppCompatActivity implements ViewFunPrsenter {
    private LogInPrsenter prsenter;
    private logInViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);
        ButterKnife.bind(this);
        initOnStatrt();
        initVaripel();

    }

    @Override
    public void OnClick(View view) {
        initVaripel();
        if (view == viewHolder.skip)
            prsenter.MainPageButoon();
        else if (view == viewHolder.newUser)
            prsenter.GotToNewAcount();
        else if (view == viewHolder.forgetPass)
            prsenter.GotToForgetPass();
        else if (view == viewHolder.logInBu)
            prsenter.SinInWithEmailandPassword(viewHolder.email.getText().toString(), viewHolder.password.getText().toString());

    }

    @Override
    public void initOnStatrt() {
        prsenter = new LogInPrsenter(this);
        viewHolder = new logInViewHolder(this);
    }

    @Override
    public void initVaripel() {
        viewHolder.logInBu.setOnClickListener(this::OnClick);
        viewHolder.forgetPass.setOnClickListener(this::OnClick);
        viewHolder.newUser.setOnClickListener(this::OnClick);
        viewHolder.skip.setOnClickListener(this::OnClick);
    }
}
