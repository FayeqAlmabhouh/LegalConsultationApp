package com.example.legalconsultationapp.ProfilePage.prsenter;

import android.app.Activity;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.ProfilePage.model.UserProfileModel;
import com.example.legalconsultationapp.ProfilePage.view.EditeProfileViewHolder;
import com.example.legalconsultationapp.ProfilePage.view.ProfileFragment;
import com.example.legalconsultationapp.UserModel.UserData;

import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;

public class EditeProfilePrsenter {

    private Activity activity;
    private UserProfileModel model;
    private AppUtils appUtils;
    private EditeProfileViewHolder viewHolder;
    private ConstantVariable constantVariable;
    private UserData userData;
    private UserPreferences userPreferences;

    public EditeProfilePrsenter(Activity activity) {
        this.activity = activity;
        this.model = new UserProfileModel();
        this.appUtils = new AppUtils(this.activity);
        this.viewHolder = new EditeProfileViewHolder(this.activity);
        this.constantVariable = new ConstantVariable();
        this.userData = new UserData();
        this.userPreferences = new UserPreferences(this.activity);

    }

    public void BackToProfile() {
        ProfileFragment profileFragment = new ProfileFragment();
        activity.finish();
    }

    public void SaveNewUserData(String name, String Phonumper) {
        appUtils.ShowDialog();
        if (appUtils.checkConnection() == false) {
            appUtils.SnackbareStyle(constantVariable.getNoInternet());
            appUtils.dialogDismiss();
        } else {
            this.userData.setUserName(name);
            this.userData.setPhoneNumber(Phonumper);
            Task t = model.UpdateUserData(this.userData);
            t.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()) {
                        model.getUserData(activity);
                        appUtils.dialogDismiss();
                        appUtils.SnackbareStyle(constantVariable.getUpdateSuccess());
                    }
                }
            });
        }
    }


}
