package com.example.legalconsultationapp.Post.prsenter;

import android.app.Activity;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.CatogeryModel.subCatogeryStructure;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.Post.model.PostAdapter;
import com.example.legalconsultationapp.Post.model.AllPostStructure;
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
    private String catId;

    public AllPostPresenter(Activity activity) {
        this.activity = activity;
        this.appUtils = new AppUtils(this.activity);
        this.constantPage = new ConstantPage(this.activity);
        this.model = new AllpostModel();
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
        this.catId = subCatogeryStructure.selectedSubCatogeryStructure.getKey();

        appUtils.ShowLoadingDialogue();
        List<AllPostStructure> listData = new ArrayList<>();
        this.model.getPostDetiles().child(this.catId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    AllPostStructure post = data.getValue(AllPostStructure.class);
                    listData.add(post);
                }
                ShowData(listData, recyclerView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void ShowData(List<AllPostStructure> listData, RecyclerView recyclerView) {
        appUtils.dialogDismiss();
        recyclerView.setAdapter(new PostAdapter(this.activity, listData));
    }

    public String getPageTitel() {
        return subCatogeryStructure.selectedSubCatogeryStructure.getTitle();
    }

    public void openContactLawyer() {
        constantPage.setLawyerPage(this.activity);
        constantPage.openContactLawyer();
    }

    public void openFreeAdvice() {
        constantPage.setLawyerPage(this.activity);
        constantPage.openFreeAdvice();
    }








}
