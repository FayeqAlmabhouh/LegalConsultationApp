package com.example.legalconsultationapp.Post.view;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.Post.prsenter.AllPostFun;
import com.example.legalconsultationapp.Post.prsenter.AllPostPrsenter;
import com.example.legalconsultationapp.R;

public class AllPostActivity extends AppCompatActivity implements AllPostFun {

    private AllPostViewHolder viewHolder;
    private AllPostPrsenter prsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_post_activity);
        ButterKnife.bind(this);
        intlOnStart();
        intlVariable();
    }

    @Override
    public void intlOnStart() {
        this.prsenter = new AllPostPrsenter(this);
        this.viewHolder = new AllPostViewHolder(this);
    }

    @Override
    public void intlVariable() {
        this.viewHolder.back.setOnClickListener(this::OnClick);
        this.viewHolder.serch.setOnClickListener(this::OnClick);
    }

    @Override
    public void OnClick(View view) {
        if (view == viewHolder.back)
            prsenter.BackToCatogryPage();
        if (view == viewHolder.serch)
            prsenter.OpenSerchPage();
    }
}
