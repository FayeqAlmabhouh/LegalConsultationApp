package com.example.legalconsultationapp.MainPageHome.Prsenter;

import android.app.Activity;
import android.view.View;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.CatogeryModel.CatogeryStructure;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.MainPageHome.Model.CategoryAdapter;
import com.example.legalconsultationapp.MainPageHome.Model.homPageModel;
import com.example.legalconsultationapp.MainPageHome.View.HomePageViewHolder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

public class HomePrsenter {

    private Activity activity;
    private HomePageViewHolder viewHolder;
    private homPageModel model;
    private CategoryAdapter adapter;
    private AppUtils appUtils;
    private View view;

    public HomePrsenter(Activity activity,View v) {
        this.activity = activity;
        this.model = new homPageModel();
        this.appUtils = new AppUtils(this.activity);
        this.view =v;
        this.viewHolder = new HomePageViewHolder(view);
    }

    public void goToSerchPage() {
        //ConstantPage.localpage = new HomeFragment();
        ConstantPage.OpenSerchPage(activity);
    }

    public void showCatogeryData (){
        appUtils.ShowDiload();
        ArrayList <CatogeryStructure> catogeryStructuresData = new ArrayList<>();
        model.getCatogeryStructures().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data :dataSnapshot.getChildren()){
                    CatogeryStructure  catogeryStructure = data.getValue(CatogeryStructure.class);
                    catogeryStructuresData.add(catogeryStructure);
                }
                ShowData(catogeryStructuresData);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    private void ShowData(ArrayList<CatogeryStructure> data) {
        appUtils.dialogDismiss();
       this.viewHolder.getDataShow().setAdapter(new CategoryAdapter(this.activity,data));

    }



}
