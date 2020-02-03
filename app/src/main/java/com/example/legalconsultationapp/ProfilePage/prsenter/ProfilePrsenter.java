package com.example.legalconsultationapp.ProfilePage.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.ProfilePage.model.UserProfileModel;
import com.example.legalconsultationapp.ProfilePage.view.EditeProfile;

public class ProfilePrsenter {

    private Activity activity;
    private UserProfileModel model;
    private UserPreferences userPreferences;

    public ProfilePrsenter(Activity context) {
        this.activity = context;
        this.model = new UserProfileModel();
        userPreferences = new UserPreferences(context);
    }

    public void GoToEditepage() {
        Intent editePage = new Intent(activity, EditeProfile.class);
        activity.startActivity(editePage);
        activity.finish();
    }

    public void logOut() {
        model.SinOut();
        userPreferences.ClearuserTempData();
        Intent editePage = new Intent(activity, LogIn.class);
        activity.finish();
    }


}
