package com.example.legalconsultationapp.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.legalconsultationapp.LawyerContents.View.RequestFreeAdvice;
import com.example.legalconsultationapp.MainPage.view.MainPage;
import com.example.legalconsultationapp.Search.View.SearchActivity;

import androidx.fragment.app.Fragment;

public class ConstantPage {

    private Fragment localpage;
    private Activity activity;

    private Activity LawyerPage;


    public ConstantPage(Activity activity) {
        this.activity = activity;
    }

    public Fragment getLocalpage() {
        return localpage;
    }

    public void setLocalpage(Fragment localpage) {
        this.localpage = localpage;
    }

    public void OpenMainPage() {
        Intent mainPage = new Intent(this.activity, MainPage.class);
        this.activity.startActivity(mainPage);
        this.activity.finish();
    }

    public void OpenSerchPage() {
        Intent serchpage = new Intent(this.activity, SearchActivity.class);
        this.activity.startActivity(serchpage);
    }

    public void openContactLawyer() {
        Intent ContactLawyer = new Intent(activity, com.example.legalconsultationapp.LawyerContents.View.ContactLawyer.class);
        activity.startActivity(ContactLawyer);
        activity.finish();
    }

    public void openFreeAdvice() {
        Intent FreeAdvice = new Intent(activity, RequestFreeAdvice.class);
        activity.startActivity(FreeAdvice);
        activity.finish();
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getLawyerPage() {
        return LawyerPage;
    }

    public void setLawyerPage(Activity lawyerPage) {
        LawyerPage = lawyerPage;
    }
}
