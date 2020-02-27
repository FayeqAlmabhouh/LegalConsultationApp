package com.example.legalconsultationapp.Search.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.Search.Prsenter.SearchPresenter;
import com.example.legalconsultationapp.Search.Prsenter.SerchViewFun;

public class SearchActivity extends AppCompatActivity implements SerchViewFun {

    private SearchPresenter prsenter;
    private SearchActivityViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        ButterKnife.bind(this);
        intlOnStart();
        intlVariable();

    }

    @Override
    public void intlOnStart() {
        this.prsenter = new SearchPresenter(this);
        this.viewHolder = new SearchActivityViewHolder(this);
    }

    @Override
    public void intlVariable() {
        viewHolder.backBu.setOnClickListener(this::OnClick);
        viewHolder.serchBoxVal.setOnClickListener(this::OnClick);
        viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        viewHolder.recyclerView.setHasFixedSize(true);
    }

    @Override
    public void OnClick(View view) {
        if (view == viewHolder.backBu)
            prsenter.backButon();
        if (view == viewHolder.serchBoxVal)
            prsenter.viewSearchData(viewHolder.serchBoxVal.getText().toString(), viewHolder.recyclerView);
    }
}
