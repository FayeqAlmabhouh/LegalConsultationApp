package com.example.legalconsultationapp.Post.model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.legalconsultationapp.CatogeryModel.ClickListener;
import com.example.legalconsultationapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllPostViewAdapter extends RecyclerView.Adapter<AllPostViewHolder> {

    private Activity activity;
    private List<AllPostStructure> postStructures;

    public AllPostViewAdapter(Activity activity, List<AllPostStructure> postStructures) {
        this.activity = activity;
        this.postStructures = postStructures;
    }

    @NonNull
    @Override
    public AllPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(activity).inflate(R.layout.post_list_view, parent, false);
        return new AllPostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AllPostViewHolder holder, int position) {
        holder.postText.setText(postStructures.get(position).getTitle());
        holder.postDate.setText(Long.toString(postStructures.get(position).getDate()));
        holder.postDes.setText(postStructures.get(position).getDesc());
        if (!(postStructures.get(position).getImage().isEmpty()))
            Picasso.with(activity).load(postStructures.get(position).getImage()).into(holder.postImge);
        holder.setClickListener(new ClickListener() {
            @Override
            public void OnClick(View view) {
                AllPostStructure.postStructure = postStructures.get(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postStructures.size();
    }
}
