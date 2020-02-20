package com.example.legalconsultationapp.SubCategories.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.legalconsultationapp.CatogeryModel.ClickListener;
import com.example.legalconsultationapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class subCatogeryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView subCatogerName;
    protected ImageView subCatogeyImg;
    private ClickListener clickListener;

    public subCatogeryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.subCatogerName = (TextView) itemView.findViewById(R.id.sub_categoryView_txt);
        this.subCatogeyImg = (ImageView) itemView.findViewById(R.id.sub_categoryView_img);
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
