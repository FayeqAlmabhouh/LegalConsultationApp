package com.example.legalconsultationapp.Search.Model;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;

public class SearchModel {

    private FirebaseFirestore firebaseFirestore;


    public SearchModel() {
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public Query findUserPost(String serachText) {
        return firebaseFirestore.collection("AllPosts").whereEqualTo("title", serachText);
    }


}
