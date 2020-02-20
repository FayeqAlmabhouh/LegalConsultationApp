package com.example.legalconsultationapp.ProfilePage.view;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.ProfilePage.prsenter.ChangePassPrsenter;
import com.example.legalconsultationapp.ProfilePage.prsenter.EditeProfileViewFun;
import com.example.legalconsultationapp.R;

public class ChangePassActivity extends AppCompatActivity implements EditeProfileViewFun {

    private ChangePassPrsenter prsenter;
    private ChangePassViewHolder viewHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_activity_pass);
        ButterKnife.bind(this);
        iniOnStart();
        iniVariable();
    }

    @Override
    public void OnClick(View view) {
        if (view == viewHolder.changePass)
            prsenter.ChangeUserPass(viewHolder.oldPass.getText().toString(), viewHolder.newPass.getText().toString(), viewHolder.newPassret.getText().toString());
        if (view == viewHolder.backToProfole)
            prsenter.BackToProfilePage();
    }

    @Override
    public void iniOnStart() {
        this.prsenter = new ChangePassPrsenter(this);
        this.viewHolder = new ChangePassViewHolder(this);
    }

    @Override
    public void iniVariable() {
        viewHolder.changePass.setOnClickListener(this::OnClick);
        viewHolder.backToProfole.setOnClickListener(this::OnClick);
    }
}
