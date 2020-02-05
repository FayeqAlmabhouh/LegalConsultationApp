package com.example.legalconsultationapp.ProfilePage.view;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.legalconsultationapp.R;
import com.hbb20.CountryCodePicker;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditeProfileViewHolder {

    private Activity activity;

    public EditeProfileViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
    }

    @BindView(R.id.edie_back)
    protected TextView backToProfile;
    @BindView(R.id.editeProfileName)
    protected EditText userName;
    @BindView(R.id.editeProfileccp)
    protected CountryCodePicker ccp;
    @BindView(R.id.editeProfilePhoneNumber)
    protected EditText userphone;
    @BindView(R.id.editeProfileBu)
    protected Button saveNewData;

    public TextView getBackToProfile() {
        return backToProfile;
    }

    public EditText getUserName() {
        return userName;
    }

    public CountryCodePicker getCcp() {
        return ccp;
    }

    public EditText getUserphone() {
        return userphone;
    }

    public Button getSaveNewData() {
        return saveNewData;
    }
}
