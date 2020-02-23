package com.example.legalconsultationapp.Post.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.legalconsultationapp.CatogeryModel.ClickListener;
import com.example.legalconsultationapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllPostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView postText;
    protected ImageView postImge;
    protected TextView postDes;
    protected TextView postDate;
    protected ClickListener clickListener;

    public AllPostViewHolder(@NonNull View itemView) {
        super(itemView);
        this.postText = (TextView) itemView.findViewById(R.id.view_post_title);
        this.postImge = (ImageView) itemView.findViewById(R.id.view_post_img);
        this.postDate = (TextView) itemView.findViewById(R.id.view_post_data);
        this.postDes = (TextView) itemView.findViewById(R.id.view_post_decs);
        itemView.setOnClickListener(this);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        clickListener.OnClick(v);
    }
}
