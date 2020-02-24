package com.example.legalconsultationapp.SubCategories.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.SubCategories.model.subCatogeryAdapter;
import com.example.legalconsultationapp.SubCategories.model.subCatogeryModel;
import com.example.legalconsultationapp.CatogeryModel.subCatogeryStructure;
import com.example.legalconsultationapp.CatogeryModel.CatogeryStructure;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.MainPage.view.MainPage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class subCatogeryPrsenter {

    private Activity activity;
    private AppUtils appUtils;
    private subCatogeryModel model;
    private String catogeryKey = "";
    private ConstantPage constantPage;


    public subCatogeryPrsenter(Activity activity) {
        this.activity = activity;
        this.constantPage = new ConstantPage(this.activity);
        this.appUtils = new AppUtils(this.activity);
        this.model = new subCatogeryModel();
    }

    public void getSubCatogeryPost(RecyclerView recyclerView) {
        this.catogeryKey = CatogeryStructure.SelectedCatogery.getKey();
        appUtils.ShowLoadingDialogue();
        List<subCatogeryStructure> Listdata = new ArrayList<>();

        this.model.getSubCatogeryData().child(this.catogeryKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    subCatogeryStructure subCatogeryStructureData = data.getValue(subCatogeryStructure.class);
                    Listdata.add(subCatogeryStructureData);
                }
                ShowData(Listdata, recyclerView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void ShowData(List<subCatogeryStructure> listdata, RecyclerView recyclerView) {
        appUtils.dialogDismiss();
        recyclerView.setAdapter(new subCatogeryAdapter(this.activity, listdata));
    }

    public void backTOHomePage() {
        Intent openMainPage = new Intent(this.activity, MainPage.class);
        this.activity.startActivity(openMainPage);
        this.activity.finish();
    }

    public void openSerchPage() {
        constantPage.OpenSerchPage();
    }

    public String getCatogeryTitel() {
        return CatogeryStructure.SelectedCatogery.getTitle();
    }


}
