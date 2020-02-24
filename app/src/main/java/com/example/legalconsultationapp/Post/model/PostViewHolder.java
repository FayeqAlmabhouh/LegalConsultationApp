package com.example.legalconsultationapp.Post.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.legalconsultationapp.CatogeryModel.ClickListener;
import com.example.legalconsultationapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView postViewTitel;
    protected ImageView postViewImg;
    protected TextView postViewDescrption;
    protected TextView posViewDate;
    protected ClickListener clickListener;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        this.postViewTitel = (TextView) itemView.findViewById(R.id.view_post_title);
        this.postViewImg = (ImageView) itemView.findViewById(R.id.view_post_img);
        this.postViewDescrption = (TextView) itemView.findViewById(R.id.view_post_decs);
        this.posViewDate = (TextView) itemView.findViewById(R.id.view_post_data);
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
