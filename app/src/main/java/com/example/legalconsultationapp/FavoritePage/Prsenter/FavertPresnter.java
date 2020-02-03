package com.example.legalconsultationapp.FavoritePage.Prsenter;

import android.app.Activity;
import android.content.Context;

import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.FavoritePage.View.FaveratFragment;

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
