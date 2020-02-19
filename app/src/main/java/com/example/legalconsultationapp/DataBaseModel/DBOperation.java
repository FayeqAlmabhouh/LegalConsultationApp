package com.example.legalconsultationapp.DataBaseModel;

import android.app.Activity;

import com.example.legalconsultationapp.CatogeryModel.CatogeryStructure;
import com.example.legalconsultationapp.UserModel.UserData;
import com.example.legalconsultationapp.UserModel.UserInfo;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;


public class DBOperation {

    private FirebaseAuth firebaseAuth;
    private String id = "";
    private DatabaseReference dbReference;
    private ConstantVariable constantVariable;
    private FirebaseDatabase mDataBase;
    private String name, email, phoneNumber;
    private UserPreferences userPreferences;
    private UserData userData;
    private FirebaseUser firebaseUser;
    private AuthCredential credential;
    private StorageReference storageReference;
    private FirebaseStorage storage;

    public DBOperation() {
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.constantVariable = new ConstantVariable();
        this.mDataBase = FirebaseDatabase.getInstance();
        this.dbReference = FirebaseDatabase.getInstance().getReference();
        this.userData = new UserData();
        this.firebaseUser = firebaseAuth.getCurrentUser();
        this.storage = FirebaseStorage.getInstance();
    }

    public Task CreateNewUsers(String email, String password) {

        return firebaseAuth.createUserWithEmailAndPassword(email, password);
    }

    public Task logIn(String email, String Pass) {
        return firebaseAuth.signInWithEmailAndPassword(email, Pass);

    }

    public Task SaveUserDataInDB(UserInfo userInfo) {
        this.id = firebaseAuth.getCurrentUser().getUid();
        Map<String, String> userData = new HashMap<>();
        userData.put(constantVariable.getDB_UserName(), userInfo.getuName());
        userData.put(constantVariable.getDB_UserEmail(), userInfo.getuEmail());
        userData.put(constantVariable.getDB_UserPhoneNumber(), userInfo.getuPhoneNumper());
        userData.put(constantVariable.getDB_UserID(), this.id);
        return dbReference.child(constantVariable.getDB_RootName()).child(id).setValue(userData);
    }

    public void Signout() {
        firebaseAuth.signOut();
    }

    public void getUserdata(Activity activity) {
        this.dbReference =
                FirebaseDatabase.getInstance().getReference().child(constantVariable.getDB_RootName());
        userPreferences = new UserPreferences(activity);
        this.id = firebaseAuth.getCurrentUser().getUid();
        this.dbReference.child(this.id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = dataSnapshot.child(constantVariable.getDB_UserName()).getValue().toString();
                    email = dataSnapshot.child(constantVariable.getDB_UserEmail()).getValue().toString();
                    phoneNumber = dataSnapshot.child(constantVariable.getDB_UserPhoneNumber()).getValue().toString();
                    userData.setUserName(name);
                    userData.setEmail(email);
                    userData.setPhoneNumber(phoneNumber);
                    userPreferences.SaveUserData(userData);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public Task ResetPass(String email) {
        return this.firebaseAuth.sendPasswordResetEmail(email);
    }

    public Task UpdateUserData(UserData userData) {
        Map<String, Object> newUserData = new HashMap<>();
        newUserData.put(constantVariable.getDB_UserName(), userData.getUserName());
        newUserData.put(constantVariable.getDB_UserPhoneNumber(), userData.getPhoneNumber());
        this.dbReference = FirebaseDatabase.getInstance().getReference().child(constantVariable.getDB_RootName());
        this.id = firebaseAuth.getCurrentUser().getUid();
        return this.dbReference.child(this.getUserId()).updateChildren(newUserData);
    }

    private String getUserId() {
        return this.id = firebaseAuth.getCurrentUser().getUid();
    }

    public Task ChangePassword(String UserPass) {
        this.firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        return firebaseUser.updatePassword(UserPass);
    }

    public Task PasswordCredential(String email, String Password) {
        this.credential = EmailAuthProvider.getCredential(email, Password);
        return firebaseUser.reauthenticate(this.credential);
    }

    public DatabaseReference getCatogeryData() {
        return this.dbReference = FirebaseDatabase.getInstance().getReference().child("Categories");

    }
}
