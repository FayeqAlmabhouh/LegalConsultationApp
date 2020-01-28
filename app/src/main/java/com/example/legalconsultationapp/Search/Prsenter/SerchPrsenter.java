package com.example.legalconsultationapp.Search.Prsenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.legalconsultationapp.AppUtils.ConstantPage;
import com.example.legalconsultationapp.MainPage.View.MainPage;

import androidx.fragment.app.Fragment;

public class SerchPrsenter{

    private Activity activity;

    public SerchPrsenter(Activity activity) {
        this.activity = activity;
    }

    public void backButon (){

        Fragment fragment = new ConstantPage().localpage;
        activity.finish();







    }


}
