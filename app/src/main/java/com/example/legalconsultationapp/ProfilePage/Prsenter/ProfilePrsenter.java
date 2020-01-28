package com.example.legalconsultationapp.ProfilePage.Prsenter;

import android.content.Context;
import android.content.Intent;

import com.example.legalconsultationapp.LogIn.View.LogIn;
import com.example.legalconsultationapp.ProfilePage.View.EditeProfile;

public class ProfilePrsenter{

    private Context context;

    public ProfilePrsenter(Context context) {
        this.context = context;
    }
    public void GoToEditepage()
    {
        Intent editePage = new Intent();
            editePage.setClass(context, EditeProfile.class);
            context.startActivity(editePage);
    }
    public void  logOut ()
    {
        Intent editePage = new Intent();
        editePage.setClass(context, LogIn.class);
        context.startActivity(editePage);
    }







}
