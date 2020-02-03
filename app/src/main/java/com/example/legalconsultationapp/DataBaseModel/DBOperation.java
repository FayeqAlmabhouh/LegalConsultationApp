package com.example.legalconsultationapp.DataBaseModel;

import com.example.legalconsultationapp.UserModel.UserInfo;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DBOperation {

    private FirebaseAuth firebaseAuth;
    private String id = "";
    private DatabaseReference dbReference;
    private ConstantVariable constantVariable;
    String mUid;
    public DBOperation() {
        this.firebaseAuth = FirebaseAuth.getInstance();

        this.dbReference = FirebaseDatabase.getInstance().getReference();
        this.constantVariable = new ConstantVariable();


    }

    public static FirebaseUser IsUserHaveAcount() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public Task CreateNewUsers(String email, String password) {

        return firebaseAuth.createUserWithEmailAndPassword(email, password);
    }

    public Task SaveUserDataInDB(UserInfo userInfo) {
        this.id = firebaseAuth.getCurrentUser().getUid();
        Map<String, String> userData = new HashMap<>();
        userData.put(constantVariable.getDB_UserName(), userInfo.getuName());
        userData.put(constantVariable.getDB_UserEmail(), userInfo.getuEmail());
        userData.put(constantVariable.getDB_UserPhoneNumber(), userInfo.getuPhoneNumper());
        return dbReference.child("Users").child(id).setValue(userData);
    }

    public void Signout() {
        firebaseAuth.signOut();
    }
}
