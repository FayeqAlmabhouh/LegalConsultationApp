package com.example.legalconsultationapp.Search.View;


import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import androidx.recyclerview.widget.RecyclerView;
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
    @BindView(R.id.serchBox)
    protected EditText serchBoxVal;
    @BindView(R.id.SearchRecycleView)
    protected RecyclerView recyclerView;

}
