package com.example.legalconsultationapp.Search.Prsenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.MainPage.View.MainPage;

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
