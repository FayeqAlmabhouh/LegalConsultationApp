package com.example.legalconsultationapp.ProfilePage.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.ProfilePage.model.UserProfileModel;
import com.example.legalconsultationapp.ProfilePage.view.EditeProfileViewHolder;
import com.example.legalconsultationapp.ProfilePage.view.ProfileFragment;
import com.example.legalconsultationapp.UserModel.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class EditeProfilePrsenter {

    private Activity activity;
    private UserProfileModel model;
    private AppUtils appUtils;
    private EditeProfileViewHolder viewHolder;
    private ConstantVariable constantVariable;

    public EditeProfilePrsenter(Activity activity) {
        this.activity = activity;
        this.model = new UserProfileModel();
        this.appUtils = new AppUtils(this.activity);
        this.viewHolder = new EditeProfileViewHolder(this.activity);
        this.constantVariable = new ConstantVariable();
    }

    public void BackToProfile() {
        Fragment profilePage = new ProfileFragment();
        activity.finish();

    }

    public void LogOut() {
        Intent logInpage = new Intent();
        logInpage.setClass(activity, LogIn.class);
        activity.startActivity(logInpage);
    }

    private UserData getUserData() {
        UserData userData = new UserData();
        userData.setPhoneNumber(viewHolder.getUserName().toString());
        userData.setPhoneNumber(viewHolder.getCcp().getSelectedCountryCodeWithPlus() + viewHolder.getUserphone().toString());
        return userData;
    }


    public void SvaeNewUserData() {
        model.UpdateUserData(getUserData());


    }


}
