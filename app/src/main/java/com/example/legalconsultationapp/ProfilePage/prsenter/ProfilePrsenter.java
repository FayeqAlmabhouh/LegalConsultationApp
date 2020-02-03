package com.example.legalconsultationapp.ProfilePage.prsenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.ProfilePage.view.ProfileFragment;
import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.ProfilePage.model.UserProfileModel;
import com.example.legalconsultationapp.ProfilePage.view.EditeProfile;

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
        new AlertDialog.Builder(activity).setTitle("هل ترريد تسجيل الخروج ؟").
                setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        model.SinOut();
                        userPreferences.logOut();
                        Intent editePage = new Intent(activity, LogIn.class);
                        activity.startActivity(editePage);
                        ((Activity) activity).finish();
                    }
                }).setNegativeButton("لا", null).show();
    }
}
