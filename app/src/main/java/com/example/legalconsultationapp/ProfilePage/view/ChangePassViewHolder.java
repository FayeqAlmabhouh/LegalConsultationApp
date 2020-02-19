package com.example.legalconsultationapp.ProfilePage.view;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangePassViewHolder {

    private Activity activity;

    public ChangePassViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, this.activity);
    }

    @BindView(R.id.newPassOld)
    protected EditText oldPass;
    @BindView(R.id.newPassNew)
    protected EditText newPass;
    @BindView(R.id.newPassReepet)
    protected EditText newPassret;
    @BindView(R.id.changePassBU)
    protected Button changePass;
    @BindView(R.id.forgepassback)
    protected TextView backToProfole;

    public EditText getOldPass() {
        return oldPass;
    }

    public EditText getNewPass() {
        return newPass;
    }

    public EditText getNewPassret() {
        return newPassret;
    }
}
