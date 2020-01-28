package com.example.legalconsultationapp.Splash.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.Splash.Prsenter.SplashPrsenter;

public class Splash extends AppCompatActivity {



    private SplashPrsenter prsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        this.prsenter = new SplashPrsenter(this);
        prsenter.isNetworkAvailable();

    }
}
