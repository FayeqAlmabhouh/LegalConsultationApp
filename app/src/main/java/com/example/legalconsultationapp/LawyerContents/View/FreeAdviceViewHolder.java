package com.example.legalconsultationapp.LawyerContents.View;

import android.app.Activity;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FreeAdviceViewHolder {

    private Activity activity;

    public FreeAdviceViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, this.activity);
    }

    @BindView(R.id.requser_free_advice)
    protected TextView freeAdviceBu;

}
