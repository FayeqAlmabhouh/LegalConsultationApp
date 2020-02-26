package com.example.legalconsultationapp.LogIn.View;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.LogIn.prsenter.ForgetPassPrsenter;
import com.example.legalconsultationapp.LogIn.prsenter.ViewFunPrsenter;
import com.example.legalconsultationapp.R;

public class ForgetPassword extends AppCompatActivity implements ViewFunPrsenter {


    private ForgetPassPrsenter prsenter;
    private forgetPassViewHolder viewHolder;
    private String UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_activity);
        initOnStatrt();
        initVaripel();
    }

    @Override
    public void OnClick(View view) {
        initVaripel();
        if (view == viewHolder.openlogenpage)
            prsenter.GoBackToLogIn();
        if (view == viewHolder.forgetPassbu)
            prsenter.SendUserPass(UserEmail);
    }

    @Override
    public void initOnStatrt() {
        ButterKnife.bind(this);
        prsenter = new ForgetPassPrsenter(this);
        viewHolder = new forgetPassViewHolder(this);
    }

    @Override
    public void initVaripel() {
        viewHolder.openlogenpage.setOnClickListener(this::OnClick);
        viewHolder.forgetPassbu.setOnClickListener(this::OnClick);
        this.UserEmail = viewHolder.uEmail.getText().toString();
    }
}
