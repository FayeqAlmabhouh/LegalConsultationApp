package com.example.legalconsultationapp.ProfilePage.prsenter;

import android.app.Activity;
import android.widget.Toast;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.ProfilePage.model.UserProfileModel;
import com.example.legalconsultationapp.ProfilePage.view.ChangePassViewHolder;
import com.example.legalconsultationapp.ProfilePage.view.ProfileFragment;
import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;

public class ChangePassPrsenter {

    private Activity activity;
    private AppUtils appUtils;
    private UserProfileModel model;
    private ChangePassViewHolder viewHolder;
    private ConstantVariable constantVariable;
    private UserPreferences userPreferences;

    public ChangePassPrsenter(Activity activity) {
        this.activity = activity;
        this.appUtils = new AppUtils(this.activity);
        this.model = new UserProfileModel();
        this.viewHolder = new ChangePassViewHolder(this.activity);
        this.constantVariable = new ConstantVariable();
        this.userPreferences = new UserPreferences(this.activity);
    }

    private boolean CheckEmptiyBox(String oldPass, String newPass, String reptePass) {
        boolean State = true;
        if (oldPass.isEmpty()) {
            State = false;
            appUtils.setError(viewHolder.getOldPass(), constantVariable.getEmpty_password());
        }
        if (newPass.isEmpty()) {
            State = false;
            appUtils.setError(viewHolder.getNewPass(), constantVariable.getEmpty_password());
        } else {
            State = appUtils.PaswordLengith(newPass);
            if (State == false)
                appUtils.setError(viewHolder.getNewPass(), constantVariable.getPassword_Length());
        }
        if (reptePass.isEmpty()) {
            appUtils.setError(viewHolder.getNewPassret(), constantVariable.getPassword_Mach());
            State = false;
        } else {
            State = appUtils.PasswordMatch(newPass, reptePass);
            if (State == false)
                appUtils.setError(viewHolder.getNewPassret(), constantVariable.getPassword_Mach());

        }
        return State;
    }

    public void ChangeUserPass(String oldPass, String newPass, String newRepetPass) {
        if (appUtils.checkConnection() == false)
            appUtils.SnackbareStyle(constantVariable.getNoInternet());
        else if (appUtils.checkConnection() && CheckEmptiyBox(oldPass, newPass, newRepetPass) == true) {
            appUtils.ShowDiload();
            model.CheakeOldPass(userPreferences.getUserEmail(), oldPass).addOnCompleteListener
                    (new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()) {
                                model.ChangePass(newPass).addOnCompleteListener(new OnCompleteListener() {
                                    @Override
                                    public void onComplete(@NonNull Task task) {
                                        if (task.isSuccessful()) {
                                            appUtils.dialogDismiss();
                                            appUtils.SnackbareStyle(constantVariable.getPasswordChange());

                                        } else {
                                            appUtils.dialogDismiss();
                                            Toast.makeText(activity, task.getException().toString(), Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            } else {
                                appUtils.dialogDismiss();
                                appUtils.setError(viewHolder.getOldPass(), constantVariable.getOld_Pass_wrong());
                            }

                        }
                    });
        }
    }

    public void BackToProfilePage() {
        ProfileFragment profileFragment = new ProfileFragment();
        activity.finish();
    }

}
