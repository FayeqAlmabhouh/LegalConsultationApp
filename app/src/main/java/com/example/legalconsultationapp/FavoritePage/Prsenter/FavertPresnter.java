package com.example.legalconsultationapp.FavoritePage.Prsenter;

import android.content.Context;

import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.FavoritePage.View.FaveratFragment;

public class FavertPresnter {

    private Context context ;

    public FavertPresnter(Context context) {
        this.context = context;
    }

    public void GoToSerchPage(){
        //ConstantPage.localpage = new FaveratFragment();
        ConstantPage.OpenSerchPage(context);
    }

}
