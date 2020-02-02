package com.example.legalconsultationapp.Search.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.Search.Prsenter.SearchPresenter;
import com.example.legalconsultationapp.SignUp.prsenter.SinUpViewFun;

public class SearchActivity extends AppCompatActivity  {

    private TextView vBacckbu;
    private SearchPresenter prsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        initView();
        initListener();
        initPresenter();
    }

    private void initPresenter() {
        prsenter = new SearchPresenter(this);
    }

    private void initListener() {
        vBacckbu.setOnClickListener(this::OnClick);
    }

    private void initView() {
        vBacckbu = findViewById(R.id.SBackBU);
    }

    public void OnClick(View view) {
        if (view == vBacckbu) {
            prsenter.backButon();
        }
    }
}
