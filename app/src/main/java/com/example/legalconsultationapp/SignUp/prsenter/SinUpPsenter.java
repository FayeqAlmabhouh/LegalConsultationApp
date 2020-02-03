package com.example.legalconsultationapp.SignUp.prsenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.AppUtils.ConstantPage;
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


    public SinUpPsenter(Activity activity) {
        this.activity = activity;
        this.userInfo = new UserInfo();
        this.constantVariable = new ConstantVariable();
        this.viewHolder = new ViewHolder(activity);
        this.sinUpModel = new SinUpModel();
        this.userPreferences = new UserPreferences(activity);
    }

    public void GoBackToLogIn() {
        Intent logIn = new Intent(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }

    public void GoToMainPage() {
        ConstantPage.SkipButoon(activity);
    }

    private boolean CheakeUserData(UserInfo userInfo) {
        boolean dataStae = true;
        if (userInfo.getuName().isEmpty()) {
            AppUtils.setError(viewHolder.getUserName(), "الأسم مطلوب ");
            dataStae = false;
        }
        if (userInfo.getuEmail().isEmpty()) {
            AppUtils.setError(viewHolder.getUserEmail(), "البريد الإكتروني مطلوب");
            dataStae = false;
        } else {
            boolean emailValid = AppUtils.isEmailValid(userInfo.getuEmail());
            if (emailValid == false) {
                AppUtils.setError(viewHolder.getUserEmail(), "تحقق من صحة البريد الإلكتروني ");
                dataStae = false;
            } else
                dataStae = true;
        }
        if (userInfo.getuPassword().isEmpty()) {
            AppUtils.setError(viewHolder.getUserPassword(), "كلمة السر مطلوبة");
            dataStae = false;
        } else {
            boolean chakePassLength = AppUtils.PaswordLengith(userInfo.getuPassword());
            if (chakePassLength == false) {
                AppUtils.setError(viewHolder.getUserPassword(), "الرجاء أدخال كلمة سر أكثر من 6 أحرف");
                dataStae = false;
            }
        }
        if (userInfo.getuComfarmpass().isEmpty()) {
            AppUtils.setError(viewHolder.getCofirmPass(), "يجب أن تتطابق كلمتي المرور ");
            dataStae = false;
        } else {
            boolean passMatch =
                    AppUtils.PasswordMatch(userInfo.getuPassword(), userInfo.getuComfarmpass());
            if (passMatch == false) {
                AppUtils.setError(viewHolder.getCofirmPass(), "يجب أن تتطابق كلمتي المرور ");
                dataStae = false;
            } else
                dataStae = true;
        }
        if (userInfo.getuPhoneNumper().isEmpty()) {
            AppUtils.setError(viewHolder.getUserPhoneNumber(), "رقم الجوال مطلوب");
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
            this.userInfo.setuPhoneNumper(viewHolder.getCcp().getFullNumberWithPlus() + phone);
            CreateAcount(this.userInfo);
           return;
        }

    }
    private void CreateAcount (UserInfo userInfo){
        Task task = sinUpModel.CreateAccount(userInfo);
        task.addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                    GoToMainPage();
                    Task  t = sinUpModel.SavDataToDataBase(userInfo);
                    if (t.isSuccessful()){
                        userPreferences.SaveUserData(userInfo);
                    }
                }else{
                    Toast.makeText(activity,task.getException().toString(),Toast.LENGTH_LONG).show();
                }

            }
        });


    }


}
