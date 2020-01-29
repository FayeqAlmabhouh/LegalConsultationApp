package com.example.legalconsultationapp.DataBaseModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DBOperation{


    public static FirebaseUser IsUserHaveAcount ()
    {
        return FirebaseAuth.getInstance().getCurrentUser();
    }
}
