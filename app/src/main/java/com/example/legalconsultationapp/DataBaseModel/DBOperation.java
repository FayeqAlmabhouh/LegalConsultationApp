package com.example.legalconsultationapp.DataBaseModel;

import com.example.legalconsultationapp.UserModel.UserData;
import com.example.legalconsultationapp.UserModel.UserInfo;
import com.example.legalconsultationapp.Constant.ConstantVariable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    public DBOperation() {
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.dbReference = FirebaseDatabase.getInstance().getReference();
        this.constantVariable = new ConstantVariable();
        this.mDataBase = FirebaseDatabase.getInstance();


    }

    public static FirebaseUser IsUserHaveAcount() {
        return FirebaseAuth.getInstance().getCurrentUser();
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
        return dbReference.child("Users").child(id).setValue(userData);
    }

    public void getUserDataFromDB(final DataStat dataStat) {
        List<UserData> data = new ArrayList<>();
        this.dbReference = mDataBase.getReference("Users");
        this.dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                data.clear();
                for (DataSnapshot keyNoad : dataSnapshot.getChildren()) {
                    UserData userData = keyNoad.getValue(UserData.class);
                    data.add(userData);
                }
                //dataStat.DataLoaded(data);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Signout() {
        firebaseAuth.signOut();
    }


    public UserData getUserdata() {
        //this.id = firebaseAuth.getCurrentUser().getUid();
        UserData userData = new UserData();
        this.dbReference = mDataBase.getReference("Users").child(id);
        dbReference.orderByChild("ID").equalTo(id)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            userData.setEmail(data.child(constantVariable.getDB_UserEmail()).getValue().toString());
                            userData.setUserName(data.child(constantVariable.getDB_UserName()).getValue().toString());
                            userData.setPhoneNumber(data.child(constantVariable.getDB_UserPhoneNumber()).getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        return userData;
    }


}
