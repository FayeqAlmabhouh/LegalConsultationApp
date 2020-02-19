package com.example.legalconsultationapp.Articles.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.CatogeryModel.CatogeryStructure;
import com.example.legalconsultationapp.R;

public class Post extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_activity);


        CatogeryStructure catogeryStructure = new CatogeryStructure();

        AppUtils appUtils = new AppUtils(this);

        appUtils.SnackbareStyle(catogeryStructure.getSelectedCatogery().getTitle());






    }
}
