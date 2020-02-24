package com.example.legalconsultationapp.SignUp.prsenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.legalconsultationapp.UserModel.UserData;
import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.SignUp.model.SinUpModel;
import com.example.legalconsultationapp.UserModel.UserInfo;
import com.example.legalconsultationapp.SignUp.view.ViewHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;

public class SinUpPsenter {

    private Activity activity;
    private UserInfo userInfo;
    private ConstantVariable constantVariable;
    private ViewHolder viewHolder;
    private SinUpModel sinUpModel;
    private UserPreferences userPreferences;
    private UserData userData;
    private AppUtils appUtils;
    private ConstantPage constantPage;

    public SinUpPsenter(Activity activity) {
        this.activity = activity;
        this.userInfo = new UserInfo();
        this.constantVariable = new ConstantVariable();
        this.viewHolder = new ViewHolder(activity);
        this.sinUpModel = new SinUpModel();
        this.userPreferences = new UserPreferences(activity);
        this.appUtils = new AppUtils(this.activity);
        this.constantPage = new ConstantPage(this.activity);
    }

    public void GoBackToLogIn() {
        Intent logIn = new Intent(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }

    public void GoToMainPage() {
       constantPage.OpenMainPage();
    }

    private boolean CheakeUserData(UserInfo userInfo) {
        boolean dataStae = true;
        if (userInfo.getuName().isEmpty()) {
            appUtils.setError(viewHolder.getUserName(),  constantVariable.getEmpty_name());
            dataStae = false;
        }
        if (userInfo.getuEmail().isEmpty()) {
            appUtils.setError(viewHolder.getUserEmail(), constantVariable.getEmpty_email());
            dataStae = false;
        } else {
            boolean emailValid = appUtils.isEmailValid(userInfo.getuEmail());
            if (emailValid == false) {
                appUtils.setError(viewHolder.getUserEmail(), constantVariable.getEmail_formatr());
                dataStae = false;
            } else
                dataStae = true;
        }
        if (userInfo.getuPassword().isEmpty()) {
            appUtils.setError(viewHolder.getUserPassword(), constantVariable.getEmpty_password());
            dataStae = false;
        } else {
            boolean chakePassLength = appUtils.PaswordLengith(userInfo.getuPassword());
            if (chakePassLength == false) {
                appUtils.setError(viewHolder.getUserPassword(), constantVariable.getPassword_Length());
                dataStae = false;
            }
        }
        if (userInfo.getuComfarmpass().isEmpty()) {
            appUtils.setError(viewHolder.getCofirmPass(),  constantVariable.getPassword_Mach());
            dataStae = false;
        } else {
            boolean passMatch =
                    appUtils.PasswordMatch(userInfo.getuPassword(), userInfo.getuComfarmpass());
            if (passMatch == false) {
                appUtils.setError(viewHolder.getCofirmPass(),  constantVariable.getPassword_Mach());
                dataStae = false;
            } else
                dataStae = true;
        }
        if (userInfo.getuPhoneNumper().isEmpty()) {
            appUtils.setError(viewHolder.getUserPhoneNumber(), constantVariable.getEmpty_numper());
            dataStae = false;
        }

        return dataStae;
    }

    private void SaveUserData(UserInfo userInfo) {
        sinUpModel.SaveUserData(activity, userInfo);
    }


    public void ChakeUserDataIsNotEmpty
            (String name, String email, String pas, String comfirmpass, String phone) {
        this.userInfo.setuName(name);
        this.userInfo.setuEmail(email);
        this.userInfo.setuPassword(pas);
        this.userInfo.setuComfarmpass(comfirmpass);
        this.userInfo.setuPhoneNumper(phone);
        String FullphonNumber;
        boolean userData = CheakeUserData(userInfo);
        if (userData == true) {
            FullphonNumber = viewHolder.getCcp().getSelectedCountryCode() + phone;
            this.userInfo.setuPhoneNumper(FullphonNumber);
            CreateAcount(this.userInfo);
            return;
        }
    }

    private void CreateAcount(UserInfo userInfo) {
        boolean checkInternet = appUtils.checkConnection();
        if (checkInternet == true) {
            appUtils.ShowLoadingDialogue();
            initUserData();
            Task task = sinUpModel.CreateAccount(userInfo);
            task.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()) {
                        appUtils.dialogDismiss();
                        SaveUserData(userInfo);
                        GoToMainPage();
                        Task t = sinUpModel.SavDataToDataBase(userInfo);
                        if (t.isSuccessful()) {
                            userPreferences.SaveUserData(userData);
                        }
                    } else {
                        Toast.makeText(activity, task.getException().toString(), Toast.LENGTH_LONG).show();
                    }

                }
            });
        } else
            appUtils.SnackbareStyle(constantVariable.getNoInternet());

    }

    private void initUserData() {
        userData = new UserData();
        userData.setEmail(this.userInfo.getuEmail());
        userData.setPhoneNumber(this.userInfo.getuPhoneNumper());
        userData.setUserName(this.userInfo.getuName());
    }
}
