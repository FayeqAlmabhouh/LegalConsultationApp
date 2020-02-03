package com.example.legalconsultationapp.AppUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

public class AppUtils {

    private static ACProgressFlower dialog;


    public static boolean checkConnection(Activity context) {
        boolean flag = false;
        ConnectivityManager connectivityManager;
        NetworkInfo info;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            info = connectivityManager.getActiveNetworkInfo();

            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                System.out.println(info.getTypeName());
                flag = true;
            }
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                System.out.println(info.getTypeName());
                flag = true;
            }
        } catch (Exception exception) {
            System.out.println("Exception at network connection....." + exception);
        }
        return flag;
    }


    public static void setError(EditText editText, String masg) {
        editText.setError(masg);
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static boolean PaswordLengith(String passwor) {
        if (passwor.length() >= 6) {
            return true;
        }
        return false;
    }

    public static boolean PasswordMatch(String OriginalPassword, String RepetPassword) {
        return OriginalPassword.equalsIgnoreCase(RepetPassword);
    }


    public static boolean cheakeUserData(EditText eEmail, EditText ePassword) {
        boolean stat = true;
        String sEmail, sPassword;

        sEmail = eEmail.getText().toString();
        sPassword = ePassword.getText().toString();

        if (sEmail.isEmpty()) {
            AppUtils.setError(eEmail, "Can't be empty");
            stat = false;
        }
        if (!(sEmail.isEmpty())) {
            boolean cheakeEmailFormat = AppUtils.isEmailValid(sEmail);
            if (cheakeEmailFormat == false) {
                AppUtils.setError(eEmail, "Enter Valid Email");
                stat = false;
            } else if (cheakeEmailFormat == true) {
                stat = true;
            }
        }
        if (sPassword.isEmpty()) {
            AppUtils.setError(ePassword, "Can't be empty");
            stat = false;
        }
        if (!(sPassword.isEmpty())) {
            boolean passlength = AppUtils.PaswordLengith(sPassword);
            if (passlength == false) {
                AppUtils.setError(ePassword, "Password Length  is less than 6");
                stat = false;
            } else if (passlength == true) {
                stat = true;
            }
        }
        return stat;
    }

    public static void ShowDiload(Activity activity) {
        dialog = new ACProgressFlower.Builder(activity)
                .direction(ACProgressConstant.DIRECT_ANTI_CLOCKWISE).themeColor(Color.WHITE)
                .text("الرجاء الانتظار").fadeColor(Color.DKGRAY).build();
        dialog.show();
        dialog.dismiss();
    }

    public static void dialogDismiss() {
        dialog.dismiss();
    }


}
