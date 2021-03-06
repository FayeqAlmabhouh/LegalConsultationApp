package com.example.legalconsultationapp.ProfilePage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.ProfilePage.prsenter.EditeProfilePrsenter;
import com.example.legalconsultationapp.ProfilePage.prsenter.EditeProfileViewFun;
import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.UserModel.UserPreferences;

public class EditeProfile extends AppCompatActivity implements EditeProfileViewFun {

    private EditeProfilePrsenter prsenter;
    private EditeProfileViewHolder viewHolder;
    private UserPreferences userPreferences;
    private String name, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edite_profile_activity);
        iniOnStart();
        iniVariable();
    }

    @Override
    public void OnClick(View view) {
        iniVariable();
        if (view == viewHolder.backToProfile)
            prsenter.BackToProfile();
        if (view == viewHolder.saveNewData)
            prsenter.SaveNewUserData(name, phone);
    }

    @Override
    public void iniOnStart() {
        this.prsenter = new EditeProfilePrsenter(EditeProfile.this);
        this.viewHolder = new EditeProfileViewHolder(this);
        this.userPreferences = new UserPreferences(this);
        this.viewHolder.userName.setText(userPreferences.getUserName());
        this.viewHolder.userphone.setText(userPreferences.getUserPhone());
    }

    @Override
    public void iniVariable() {
        this.viewHolder.backToProfile.setOnClickListener(this::OnClick);
        this.viewHolder.saveNewData.setOnClickListener(this::OnClick);
        this.name = viewHolder.userName.getText().toString();
        this.phone = viewHolder.ccp.getSelectedCountryCode()+viewHolder.userphone.getText().toString();
    }

}
