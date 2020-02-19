package com.example.legalconsultationapp.MainPageHome.Model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView catogerName;
    protected ImageView catogeyImg;

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        catogerName = (TextView) itemView.findViewById(R.id.main_post_txt);
        catogeyImg = (ImageView) itemView.findViewById(R.id.main_post_img);
        itemView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        clickListener.OnClick(v);
    }
}
