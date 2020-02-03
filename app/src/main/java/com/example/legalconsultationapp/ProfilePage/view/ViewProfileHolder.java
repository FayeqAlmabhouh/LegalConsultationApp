package com.example.legalconsultationapp.ProfilePage.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewProfileHolder {

    private View view;

    public ViewProfileHolder(View view) {
        this.view = view;
        ButterKnife.bind(this, this.view);
    }

    @BindView(R.id.profUserName)
    protected TextView vUserName;
    @BindView(R.id.profilePageEmail)
    protected TextView vUserEmail;
    @BindView(R.id.profilePagelogoutBu)
    protected ImageButton logOutBu;
    @BindView(R.id.profilePageEditeBu)
    protected ImageButton editeProfile;
    @BindView(R.id.profilePagePgoneNumber)
    protected TextView phoneNumper;
    @BindView(R.id.profilePagePassword)
    protected TextView editePassword;



}
