package com.example.legalconsultationapp.ProfilePage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.legalconsultationapp.MainPage.view.MainPage;
import com.example.legalconsultationapp.ProfilePage.prsenter.EditeProfilePrsenter;
import com.example.legalconsultationapp.ProfilePage.prsenter.EditeProfileViewFun;
import com.example.legalconsultationapp.R;

public class EditeProfile extends AppCompatActivity implements EditeProfileViewFun {

    private EditeProfilePrsenter prsenter;
    private EditeProfileViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edite_profile_activity);
        iniOnStart();

    }

    @Override
    public void OnClick(View view) {

    }

    @Override
    public void iniOnStart() {
        this.prsenter = new EditeProfilePrsenter(EditeProfile.this);
        this.viewHolder = new EditeProfileViewHolder(this);

    }

    @Override
    public void iniVariable() {
        this.viewHolder.backToProfile.setOnClickListener(this::OnClick);
        this.viewHolder.saveNewData.setOnClickListener(this::OnClick);


    }


}
