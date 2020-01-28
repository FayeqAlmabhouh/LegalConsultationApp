package com.example.legalconsultationapp.ProfilePage.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.legalconsultationapp.ProfilePage.Prsenter.EditeProfilePrsenter;
import com.example.legalconsultationapp.ProfilePage.Prsenter.EditeProfileViewFun;
import com.example.legalconsultationapp.R;

public class EditeProfile extends AppCompatActivity implements EditeProfileViewFun {


    private TextView  vbackTologIn;
    private EditeProfilePrsenter prsenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edite_profile_activity);

        prsenter = new EditeProfilePrsenter(this);
        vbackTologIn = findViewById(R.id.EditeProfileBackTOProfile);
            vbackTologIn.setOnClickListener(this::OnClick);
    }
    @Override
    public void OnClick(View view){
        if (view == vbackTologIn)
        {
            prsenter.BackToProfile();
        }


    }
}
