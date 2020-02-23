package com.example.legalconsultationapp.Post.view;

import android.app.Activity;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AllPostViewHolder {

    private Activity activity;

    public AllPostViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, this.activity);
    }

    @BindView(R.id.post_back)
    protected TextView back;
    @BindView(R.id.post_serch)
    protected TextView serch;
    @BindView(R.id.post_titel)
    protected TextView pageTitel;
    @BindView(R.id.all_post_recycler_view)
    protected RecyclerView AllPostRecyclerView;

}
