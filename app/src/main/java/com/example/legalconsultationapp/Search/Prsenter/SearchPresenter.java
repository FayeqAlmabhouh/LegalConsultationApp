package com.example.legalconsultationapp.Search.Prsenter;

import android.app.Activity;

import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.Search.Model.SearchModel;

import androidx.fragment.app.Fragment;

public class SearchPresenter {

    private Activity activity;
    private SearchModel model;

    public SearchPresenter(Activity activity) {
        this.activity = activity;
        this.model = new SearchModel();
    }

    public void backButon() {
        Fragment fragment = new ConstantPage(this.activity).getLocalpage();
        activity.finish();
    }
}
