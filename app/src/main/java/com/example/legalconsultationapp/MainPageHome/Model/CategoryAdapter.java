package com.example.legalconsultationapp.MainPageHome.Model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.legalconsultationapp.CatogeryModel.CatogeryStructure;
import com.example.legalconsultationapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private Activity context;
    private List<CatogeryStructure> data;

    public CategoryAdapter(Activity context, List<CatogeryStructure> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.main_page_post, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.catogerName.setText(data.get(position).getTitle());
        Picasso.with(context).load(data.get(position).getImage()).into(holder.catogeyImg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
