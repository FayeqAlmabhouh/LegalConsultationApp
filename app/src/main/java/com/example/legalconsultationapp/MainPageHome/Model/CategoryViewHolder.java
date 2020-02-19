package com.example.legalconsultationapp.MainPageHome.Model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    protected TextView catogerName;
    protected ImageView catogeyImg;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        catogerName = (TextView) itemView.findViewById(R.id.main_post_txt);
        catogeyImg = (ImageView) itemView.findViewById(R.id.main_post_img);
    }
}
