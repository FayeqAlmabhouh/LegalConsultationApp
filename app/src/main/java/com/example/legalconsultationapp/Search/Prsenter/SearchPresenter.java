package com.example.legalconsultationapp.Search.Prsenter;

import android.app.Activity;

import com.example.legalconsultationapp.Constant.ConstantPage;

import androidx.fragment.app.Fragment;

public class SearchPresenter {

    private Activity activity;

    public SearchPresenter(Activity activity) {
        this.activity = activity;
    }

    public void backButon() {
        Fragment fragment = new ConstantPage().getLocalpage();
        activity.finish();
    }
}
