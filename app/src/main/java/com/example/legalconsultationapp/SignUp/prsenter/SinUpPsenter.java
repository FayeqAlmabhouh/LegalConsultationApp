package com.example.legalconsultationapp.SignUp.prsenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.SignUp.model.UserInfo;
import com.hbb20.CountryCodePicker;

public class SinUpPsenter {

    private Activity activity;
    private UserInfo userInfo;
    private ConstantVariable constantVariable;


    public SinUpPsenter(Activity activity) {
        this.activity = activity;
        this.userInfo = new UserInfo();
        this.constantVariable = new ConstantVariable();
    }

    public void GoBackToLogIn() {
        Intent logIn = new Intent();
        logIn.setClass(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }

    public void GoToMainPage() {
        ConstantPage.SkipButoon(activity);
    }

    public boolean CheakeUserData
            (EditText uname, EditText uEmail, EditText uPass, EditText uRpass, EditText uPhone, CountryCodePicker ccp) {
        boolean dataStae = true;

        String sName, sEmail, sPass, sRpass, sPhon , FullphonNumber;
        sName = uname.getText().toString();
        sEmail = uEmail.getText().toString();
        sPass = uPass.getText().toString();
        sRpass = uRpass.getText().toString();
        sPhon =  uPhone.getText().toString();
        if (sName.isEmpty()) {
            AppUtils.setError(uname, "الأسم مطلوب ");
            dataStae = false;
        }
        if (sEmail.isEmpty()) {
            AppUtils.setError(uEmail, "البريد الإكتروني مطلوب");
            dataStae = false;
        }
        if (!sEmail.isEmpty()) {
            boolean emailValid = AppUtils.isEmailValid(sEmail);
            if (emailValid == false) {
                AppUtils.setError(uEmail, "تحقق من صحة البريد الإلكتروني ");
                dataStae = false;
            }
        }
        if (sPass.isEmpty()) {
            AppUtils.setError(uPass, "كلمة السر مطلوبة");
            dataStae = false;
        }
        if (!sPass.isEmpty()) {
            boolean chakePassLength = AppUtils.PaswordLengith(sPass);
            if (chakePassLength == false) {
                AppUtils.setError(uPass, "الرجاء أدخال كلمة سر أكبر من 6 أحرف");
                dataStae = false;
            }
        }
        if (sRpass.isEmpty()) {
            AppUtils.setError(uRpass, "يجب أن تتطابق كلمتي المرور ");
            dataStae = false;
        }
        if ((!sPass.isEmpty()) && (!sRpass.isEmpty())  ) {
            boolean passMatch = AppUtils.PasswordMatch(sPass, sRpass);
            if (passMatch == false) {
                AppUtils.setError(uRpass, "يجب أن تتطابق كلمتي المرور ");
                dataStae = false;
            } else
                dataStae = true;
        }
        if (sPhon.isEmpty()) {
            AppUtils.setError(uPhone, "رقم الجوال مطلوب");
            dataStae = false;
        }

        if (dataStae == true) {

            FullphonNumber = ccp.getSelectedCountryCodeWithPlus() +sPhon;

            userInfo.setuEmail(sEmail);
            userInfo.setuName(sName);
            userInfo.setuPhoneNumper(sPhon);
            SaveUserData(userInfo);
        }
        return dataStae;
    }

    public void SaveUserData(UserInfo userInfo) {
        SharedPreferences saveUserData =
                activity.getSharedPreferences(constantVariable.getSHARED_PREF_NAME(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saveUserData.edit();
        editor.putString(constantVariable.getKey_User_Email(), userInfo.getuEmail());
        editor.putString(constantVariable.getKey_User_Name(), userInfo.getuName());
        editor.putString(constantVariable.getKey_User_PhoneNumper(), userInfo.getuPhoneNumper());
        editor.apply();
    }
}
