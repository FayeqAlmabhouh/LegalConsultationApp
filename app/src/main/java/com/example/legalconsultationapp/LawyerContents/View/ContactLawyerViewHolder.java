package com.example.legalconsultationapp.LawyerContents.View;

import android.app.Activity;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactLawyerViewHolder {


    private Activity activity;

    public ContactLawyerViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, this.activity);
    }

    @BindView(R.id.content_Lawyer_back)
    protected TextView backBu;


}
