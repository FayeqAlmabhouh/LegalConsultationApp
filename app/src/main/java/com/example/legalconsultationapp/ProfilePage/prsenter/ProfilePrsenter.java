package com.example.legalconsultationapp.ProfilePage.prsenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.ProfilePage.model.UserProfileModel;
import com.example.legalconsultationapp.ProfilePage.view.EditeProfile;

import butterknife.ButterKnife;

public class ProfilePrsenter {

    private Context activity;
    private UserProfileModel model;
    private UserPreferences userPreferences;

    private AlertDialog alertDialog;

    public ProfilePrsenter(Context context) {
        this.activity = context;
        this.model = new UserProfileModel();
        userPreferences = new UserPreferences(context);
    }

    public void GoToEditepage() {
        Intent editePage = new Intent(activity, EditeProfile.class);
        activity.startActivity(editePage);

    }

    public void logOut() {
        model.SinOut();
        userPreferences.logOut();
        Intent editePage = new Intent(activity, LogIn.class);
        activity.startActivity(editePage);
        ((Activity) activity).finish();
    }


}
