package com.example.legalconsultationapp.MainPageHome.View;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageViewHolder {

    private View view;

    public HomePageViewHolder(View view) {
        this.view = view;
        ButterKnife.bind(this, this.view);
    }

    @BindView(R.id.homeSerch)
    protected TextView homSerch;
    @BindView(R.id.HomeRecycleView)
    protected RecyclerView dataShow;

    public RecyclerView getDataShow() {
        return dataShow;
    }
}
