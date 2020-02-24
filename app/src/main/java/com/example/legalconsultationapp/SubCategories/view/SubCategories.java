package com.example.legalconsultationapp.SubCategories.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.SubCategories.prsenter.subCatogeryFun;
import com.example.legalconsultationapp.SubCategories.prsenter.subCatogeryPrsenter;
import com.example.legalconsultationapp.R;

public class SubCategories extends AppCompatActivity implements subCatogeryFun {

    private subCatogeryPrsenter prsenter;
    private subCatogerViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_categories_activity);
        ButterKnife.bind(this);
        intlOnStart();
        intlVariable();
    }

    @Override
    public void OnClick(View view) {
        if (view == viewHolder.serch)
            prsenter.openSerchPage();
        if (view == viewHolder.subCatogeryBack)
            prsenter.backTOHomePage();
    }

    @Override
    public void intlOnStart() {
        this.prsenter = new subCatogeryPrsenter(this);
        this.viewHolder = new subCatogerViewHolder(this);
    }

    @Override
    public void intlVariable() {
        this.viewHolder.serch.setOnClickListener(this::OnClick);
        this.viewHolder.subCatogeryBack.setOnClickListener(this::OnClick);
        this.viewHolder.pageTitel.setText(prsenter.getCatogeryTitel());
        this.viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        this.viewHolder.recyclerView.setHasFixedSize(true);
        this.prsenter.getSubCatogeryPost(viewHolder.recyclerView);
    }
}
