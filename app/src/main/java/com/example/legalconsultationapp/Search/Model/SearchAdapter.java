package com.example.legalconsultationapp.Search.Model;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.legalconsultationapp.CatogeryModel.ClickListener;
import com.example.legalconsultationapp.Post.model.AllPostStructure;
import com.example.legalconsultationapp.Post.view.PostDetails;
import com.example.legalconsultationapp.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolderAdpt> {

    private List<AllPostStructure> data;
    private Activity activity;

    public SearchAdapter(List<AllPostStructure> data, Activity activity) {
        this.data = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public SearchViewHolderAdpt onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(activity).inflate(R.layout.post_list_view, parent, false);
        return new SearchViewHolderAdpt(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolderAdpt holder, int position) {
        String date = DateFormat.getDateInstance().format(data.get(position).getDate());
        holder.postViewTitel.setText(data.get(position).getTitle());
        holder.postViewDescrption.setText(data.get(position).getDescription());
        holder.posViewDate.setText(date);
        if (!(data.get(position).getImage().isEmpty()))
            Picasso.with(activity).load(data.get(position).getImage()).into(holder.postViewImg);
        holder.setClickListener(new ClickListener() {
            @Override
            public void OnClick(View view) {
                AllPostStructure.SelectedPostStructure = data.get(position);
                Intent postDetils = new Intent(activity, PostDetails.class);
                activity.startActivity(postDetils);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
