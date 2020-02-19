package com.example.legalconsultationapp.AppUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.EditText;

import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

public class AppUtils {

    private Activity activity;
    private ACProgressFlower dialog;
    private View snackbarView;
    private Snackbar snackbar;
    private ConstantVariable constantVariable;

    public AppUtils(Activity activity) {
        this.activity = activity;
        this.constantVariable = new ConstantVariable();
    }

    public boolean checkConnection() {
        boolean flag = false;
        ConnectivityManager connectivityManager;
        NetworkInfo info;
        try {
            connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
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

    public void setError(EditText editText, String masg) {
        editText.setError(masg);
    }

    public boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean PaswordLengith(String passwor) {
        if (passwor.length() >= 6)
            return true;
        return false;
    }

    public boolean PasswordMatch(String OriginalPassword, String RepetPassword) {
        return OriginalPassword.equalsIgnoreCase(RepetPassword);
    }


    public void ShowDiload() {
        this.dialog = new ACProgressFlower.Builder(activity)
                .direction(ACProgressConstant.DIRECT_ANTI_CLOCKWISE).themeColor(Color.WHITE)
                .text("الرجاء الانتظار").fadeColor(Color.DKGRAY).build();
        dialog.show();
    }

    public void dialogDismiss() {
        dialog.dismiss();
    }

    public void SnackbareStyle(String message) {
        snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.setText(message);
        snackbarView = snackbar.getView();
        snackbarView.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        snackbarView.setTextDirection(View.TEXT_DIRECTION_RTL);
        snackbar.show();
    }


}
