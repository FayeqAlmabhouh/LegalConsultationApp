package com.example.legalconsultationapp.Search.View;


import android.app.Activity;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivityViewHolder {

    private Activity activity;

    public SearchActivityViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, this.activity);
    }
    @BindView(R.id.SBackBU)
    protected TextView backBu;



}
