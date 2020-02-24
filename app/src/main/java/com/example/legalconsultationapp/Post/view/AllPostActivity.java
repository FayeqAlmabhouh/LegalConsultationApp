package com.example.legalconsultationapp.Post.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.Post.prsenter.AllPostFun;
import com.example.legalconsultationapp.Post.prsenter.AllPostPresenter;
import com.example.legalconsultationapp.R;

public class AllPostActivity extends AppCompatActivity implements AllPostFun {

    private AllPostViewHolder viewHolder;
    private AllPostPresenter prsenter;

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
        this.prsenter = new AllPostPresenter(this);
        this.viewHolder = new AllPostViewHolder(this);
    }

    @Override
    public void intlVariable() {
        this.viewHolder.back.setOnClickListener(this::OnClick);
        this.viewHolder.serch.setOnClickListener(this::OnClick);
        this.viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        this.viewHolder.recyclerView.setHasFixedSize(true);
        this.prsenter.printPost(viewHolder.recyclerView);
        this.viewHolder.pageTitel.setText(this.prsenter.getPageTitel());
        this.viewHolder.ContactLawyer.setOnClickListener(this::OnClick);
        this.viewHolder.freeAdvice.setOnClickListener(this::OnClick);
    }

    @Override
    public void OnClick(View view) {
        if (view == viewHolder.back)
            prsenter.BackToCatogryPage();
        if (view == viewHolder.serch)
            prsenter.OpenSerchPage();
        if (view == viewHolder.ContactLawyer)
            prsenter.openContactLawyer();
        if (view == viewHolder.freeAdvice)
            prsenter.openFreeAdvice();
    }
}
