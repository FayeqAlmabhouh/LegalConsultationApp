package com.example.legalconsultationapp.SubCategories.view;

import android.app.Activity;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class subCatogerViewHolder {

    private Activity activity;

    public subCatogerViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, this.activity);
    }

    @BindView(R.id.sub_catogery_back)
    protected TextView subCatogeryBack;
    @BindView(R.id.sub_catogery_serch)
    protected TextView serch;
    @BindView(R.id.sub_catogery_titel)
    protected TextView pageTitel;
    @BindView(R.id.sub_Catogery_RecycleView)
    protected RecyclerView recyclerView;

}
