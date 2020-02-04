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


    private TextView vbackTologIn;
    private EditeProfilePrsenter prsenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edite_profile_activity);

        prsenter = new EditeProfilePrsenter(EditeProfile.this);
        vbackTologIn = findViewById(R.id.edie_back);
        vbackTologIn.setOnClickListener(this::OnClick);
    }

    @Override
    public void OnClick(View view) {
        if (view == vbackTologIn) {
            prsenter.BackToProfile();
        }
    }

    public void OpenProFilePage() {
        MainPage mainPage = new MainPage();
        mainPage.OpenProFilePage();
        Intent i = new Intent(this, MainPage.class);
        startActivity(i);
    }


}
