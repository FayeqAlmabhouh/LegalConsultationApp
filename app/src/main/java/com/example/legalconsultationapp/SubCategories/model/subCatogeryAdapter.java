package com.example.legalconsultationapp.SubCategories.model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.legalconsultationapp.CatogeryModel.ClickListener;
import com.example.legalconsultationapp.CatogeryModel.subCatogeryStructure;
import com.example.legalconsultationapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class subCatogeryAdapter extends RecyclerView.Adapter<subCatogeryViewHolder> {

    private Activity activity;
    private List<subCatogeryStructure> subCatogeryDaat;

    public subCatogeryAdapter(Activity activity, List<subCatogeryStructure> subCatogeryDaat) {
        this.activity = activity;
        this.subCatogeryDaat = subCatogeryDaat;
    }

    @NonNull
    @Override
    public subCatogeryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(activity).inflate(R.layout.sub_categories_view, parent, false);
        return new subCatogeryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull subCatogeryViewHolder holder, int position) {
        holder.subCatogerName.setText(subCatogeryDaat.get(position).getTitle());
        if (!(subCatogeryDaat.get(position).getImage().isEmpty()))
            Picasso.with(activity).load(subCatogeryDaat.get(position).getImage()).into(holder.subCatogeyImg);
        holder.setClickListener(new ClickListener() {
            @Override
            public void OnClick(View view) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return subCatogeryDaat.size();
    }
}
