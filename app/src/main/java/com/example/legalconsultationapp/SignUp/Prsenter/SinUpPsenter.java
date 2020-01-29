package com.example.legalconsultationapp.SignUp.Prsenter;
import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.SignUp.Model.UserInfo;

public class SinUpPsenter {


    private Activity activity;
    private UserInfo userInfo;


    public SinUpPsenter(Activity activity)
    {
        this.activity = activity;
        this.userInfo = new UserInfo();
    }

    public void GoBackToLogIn()
    {
        Intent logIn = new Intent();
        logIn.setClass(activity, LogIn.class);
        activity.startActivity(logIn);
        activity.finish();
    }
    public   void SkipButoon ()
    {
        ConstantPage.SkipButoon(activity);
    }

    public boolean CheakeUserData
            (EditText uname, EditText uEmail, EditText uPass , EditText uRpass , EditText uPhone)
    {
        boolean dataStae = true;

        String sName,sEmail,sPass,sRpass,sPhon;

        sName = uname.getText().toString();
        sEmail = uEmail.getText().toString();
        sPass = uPass.getText().toString();
        sRpass = uRpass.getText().toString();
        sPhon = uPhone.getText().toString();

        if (sName.isEmpty())
        {
            AppUtils.setError(uname,"الأسم مطلوب ");
            dataStae = false;
        }
        if (sEmail.isEmpty())
        {
            AppUtils.setError(uEmail,"البريد الإكتروني مطلوب");
            dataStae = false;
        }
        if (!sEmail.isEmpty())
        {
            boolean emailValid = AppUtils.isEmailValid(sEmail);
                if (emailValid == false)
                {
                    AppUtils.setError(uEmail,"تحقق من صحة البريد الإلكتروني ");
                    dataStae = false;
                }
        }
        if (sPass.isEmpty())
        {
            AppUtils.setError(uPass,"كلمة السر مطلوبة");
            dataStae= false;
        }
        if(!sPass.isEmpty())
        {
            boolean chakePassLength = AppUtils.PaswordLengith(sPass);
            if (chakePassLength == false)
            {
                AppUtils.setError(uPass,"الرجاء أدخال كلمة سر أكبر من 6 أحرف");
                dataStae = false;
            }
        }
        if (sRpass.isEmpty())
        {
            AppUtils.setError(uRpass,"يجب أن تتطابق كلمتي المرور ");
            dataStae= false;
        }
        if (!(sPass.isEmpty()&&sRpass.isEmpty()))
        {
               boolean passMatch =  AppUtils.PasswordMatch(sPass,sRpass);
               if(passMatch == true)
                   dataStae = true;
               else
                   dataStae = false;
        }
        if (sPhon.isEmpty())
        {
            AppUtils.setError(uPhone,"رقم الجوال مطلوب");
            dataStae = false;
        }

    if (dataStae == true)
    {
        this.SaveUserDat(sName,sEmail,sPass,sPhon);
    }
        return dataStae;
    }

    private  void SaveUserDat (String name , String email , String password , String phone)
    {
        this.userInfo.setuName(name);
        this.userInfo.setuEmail(email);
        this.userInfo.setuPassword(password);
        this.userInfo.setuPhoneNumper(phone);
    }




}
