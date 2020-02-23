package com.example.legalconsultationapp.Post.view;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostDetailsViewHolder {

    private Activity activity;

    public PostDetailsViewHolder(Activity activity) {
        this.activity = activity;
        ButterKnife.bind(this, this.activity);
    }

    @BindView(R.id.post_det_back)
    protected TextView PostBack;
    @BindView(R.id.post_det_data)
    protected TextView postDate;
    @BindView(R.id.post_det_image)
    protected ImageView postImg;
    @BindView(R.id.post_det_Content)
    protected TextView postContent;


}
