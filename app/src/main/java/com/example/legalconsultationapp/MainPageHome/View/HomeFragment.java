package com.example.legalconsultationapp.MainPageHome.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.legalconsultationapp.MainPageHome.Prsenter.HomePrsenter;
import com.example.legalconsultationapp.MainPageHome.Prsenter.HomeViewFun;
import com.example.legalconsultationapp.R;


public class HomeFragment extends Fragment implements HomeViewFun {

    private HomePageViewHolder viewHolder;
    private HomePrsenter prsenter;
    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, this.root);
        inlOnStart();
        inlVaripel();
        return root;
    }

    @Override
    public void OnClick(View view) {
        if (view == this.viewHolder.homSerch)
            prsenter.goToSerchPage();
    }

    @Override
    public void inlOnStart() {
        this.viewHolder = new HomePageViewHolder(this.root);
        this.prsenter = new HomePrsenter(getActivity());
    }

    @Override
    public void inlVaripel() {
        this.viewHolder.homSerch.setOnClickListener(this::OnClick);
        this.viewHolder.dataShow.setLayoutManager(new GridLayoutManager(this.root.getContext(), 2));
        this.viewHolder.dataShow.setHasFixedSize(true);
        this.prsenter.showCatogeryData(viewHolder.dataShow);
    }
}
