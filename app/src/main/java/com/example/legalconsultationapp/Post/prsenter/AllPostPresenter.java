package com.example.legalconsultationapp.Post.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.CatogeryModel.CatogeryStructure;
import com.example.legalconsultationapp.Post.model.AllPostStructure;
import com.example.legalconsultationapp.Post.model.AllPostViewAdapter;
import com.example.legalconsultationapp.Post.model.AllpostModel;
import com.example.legalconsultationapp.SubCategories.view.SubCategories;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllPostPresenter {
    private Activity activity;
    private AppUtils appUtils;
    private ConstantPage constantPage;
    private AllpostModel model;
    private String catogeryId;

    public AllPostPresenter(Activity activity) {
        this.activity = activity;
        this.appUtils = new AppUtils(this.activity);
        this.constantPage = new ConstantPage(this.activity);
        this.model = new AllpostModel();
        this.catogeryId = CatogeryStructure.SelectedCatogery.getKey();
    }

    public void OpenSerchPage() {
        constantPage.OpenSerchPage();
    }

    public void BackToCatogryPage() {
        Intent catogryPage = new Intent(this.activity, SubCategories.class);
        this.activity.startActivity(catogryPage);
        this.activity.finish();
    }

    public void printPost(RecyclerView recyclerView) {
        List<AllPostStructure> listData = new ArrayList<>();
        model.getPosts().child(catogeryId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot getData : dataSnapshot.getChildren()) {
                    AllPostStructure allPostStructure = getData.getValue(AllPostStructure.class);
                    listData.add(allPostStructure);
                }
                ShowData(listData, recyclerView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void ShowData(List<AllPostStructure> listData, RecyclerView recyclerView) {
        recyclerView.setAdapter(new AllPostViewAdapter(this.activity, listData));
    }


}
