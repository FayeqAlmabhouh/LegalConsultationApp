package com.example.legalconsultationapp.FavoritePage.Prsenter;

import android.app.Activity;

import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.FavoritePage.Model.FavoriteModel;

public class FavoritePresenter {

    private Activity activity;
    private ConstantPage constantPage;
    private FavoriteModel model;

    public FavoritePresenter(Activity activity) {
        this.activity = activity;
        this.constantPage = new ConstantPage(this.activity);
        this.model = new FavoriteModel();
    }

    public void GoToSerchPage() {
        constantPage.OpenSerchPage();
    }








}
