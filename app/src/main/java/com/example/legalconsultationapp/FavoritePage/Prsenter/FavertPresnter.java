package com.example.legalconsultationapp.FavoritePage.Prsenter;

import android.content.Context;

import com.example.legalconsultationapp.Constant.ConstantPage;

public class FavertPresnter {

    private Context activity ;

    public FavertPresnter(Context activity) {
        this.activity = activity;
    }

    public void GoToSerchPage(){
        //ConstantPage.localpage = new FaveratFragment();
        ConstantPage.OpenSerchPage(activity);
    }

}
