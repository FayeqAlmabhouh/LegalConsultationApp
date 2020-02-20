package com.example.legalconsultationapp.FavoritePage.Prsenter;

import android.app.Activity;

import com.example.legalconsultationapp.Constant.ConstantPage;

public class FavertPresnter {

    private Activity activity;
    private ConstantPage constantPage;

    public FavertPresnter(Activity activity) {
        this.activity = activity;
        this.constantPage = new ConstantPage(this.activity);
    }

    public void GoToSerchPage() {
        constantPage.OpenSerchPage();
    }

}
