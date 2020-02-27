package com.example.legalconsultationapp.Search.Prsenter;

import android.app.Activity;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.Post.model.AllPostStructure;
import com.example.legalconsultationapp.Post.model.PostAdapter;
import com.example.legalconsultationapp.Search.Model.SearchAdapter;
import com.example.legalconsultationapp.Search.Model.SearchModel;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class SearchPresenter {

    private Activity activity;
    private SearchModel model;
    private AppUtils appUtils;

    public SearchPresenter(Activity activity) {
        this.activity = activity;
        this.model = new SearchModel();
        this.appUtils = new AppUtils(this.activity);
    }

    public void backButon() {
        Fragment fragment = new ConstantPage(this.activity).getLocalpage();
        activity.finish();
    }

    public void viewSearchData(String serchDat, RecyclerView recyclerView) {

        List<AllPostStructure> postData = new ArrayList<>();
        model.findUserPost(serchDat).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null && queryDocumentSnapshots.size() > 0) {
                    for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                        AllPostStructure postStructure = doc.toObject(AllPostStructure.class);
                        postData.add(postStructure);
                    }
                    ShowData(postData, recyclerView);
                }

            }
        });
    }

    private void ShowData(List<AllPostStructure> listData, RecyclerView recyclerView) {
        recyclerView.setAdapter(new SearchAdapter(listData, this.activity));
    }

}
