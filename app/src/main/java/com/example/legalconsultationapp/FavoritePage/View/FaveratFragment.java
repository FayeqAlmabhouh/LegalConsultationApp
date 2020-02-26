package com.example.legalconsultationapp.FavoritePage.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.legalconsultationapp.FavoritePage.Prsenter.FavoritePresenter;
import com.example.legalconsultationapp.FavoritePage.Prsenter.FavertViewFun;
import com.example.legalconsultationapp.R;

public class FaveratFragment extends Fragment implements FavertViewFun {
    private View root;
    private FavoritePresenter presnter;
    private favertPageViewHolder viewHolder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.faverat_fragment, container, false);
        ButterKnife.bind(this, this.root);
        inlOnStart();
        intlVariable();
        return root;
    }

    @Override
    public void OnClick(View view) {
        if (view == this.viewHolder.serchPage)
            presnter.GoToSerchPage();
    }

    @Override
    public void intlVariable() {
        this.viewHolder.serchPage.setOnClickListener(this::OnClick);
    }

    @Override
    public void inlOnStart() {
        this.presnter = new FavoritePresenter(this.getActivity());
        this.viewHolder = new favertPageViewHolder(this.root);
    }
}
