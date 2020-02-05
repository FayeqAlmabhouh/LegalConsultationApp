package com.example.legalconsultationapp.LogIn.View;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class forgetPassViewHolder {

    private Activity activity;

    public forgetPassViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this,activity);
    }

    @BindView(R.id.forgepassback)
    protected TextView openlogenpage;
    @BindView(R.id.forgetPassEmail)
    protected EditText uEmail;
    @BindView(R.id.forgetPassBu)
    protected Button forgetPassbu;

    public TextView getOpenlogenpage() {
        return openlogenpage;
    }

    public EditText getuEmail() {
        return uEmail;
    }

    public Button getForgetPassbu() {
        return forgetPassbu;
    }
}
