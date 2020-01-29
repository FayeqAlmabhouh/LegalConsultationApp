package com.example.legalconsultationapp.Splash.Model;

import com.example.legalconsultationapp.DataBaseModel.DBOperation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashModel {

    private FirebaseAuth mAuthm;
    private FirebaseUser  mUsers;


    public SplashModel()
    {
        this.mUsers = DBOperation.IsUserHaveAcount();
    }
    public String HaveAcount()
    {
       if (mUsers == null)
        {
          return "100";
        }
       else
       {
           return "101";
       }
    }








}
