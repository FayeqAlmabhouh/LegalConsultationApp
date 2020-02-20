package com.example.legalconsultationapp.FavoritePage.View;

import android.view.View;
import android.widget.TextView;

import com.example.legalconsultationapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class favertPageViewHolder {

    private View view;

    public favertPageViewHolder(View view) {
        this.view = view;
        ButterKnife.bind(this, this.view);
    }

    @BindView(R.id.FavertSerch)
    protected TextView serchPage;


}
