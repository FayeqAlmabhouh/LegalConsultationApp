package com.example.legalconsultationapp.MainPageHome.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.legalconsultationapp.MainPageHome.Prsenter.HomePrsenter;
import com.example.legalconsultationapp.MainPageHome.Prsenter.HomeViewFun;
import com.example.legalconsultationapp.R;


public class HomeFragment extends Fragment implements HomeViewFun {

        private HomePrsenter prsenter;
        private TextView vSerch;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.home_fragment, container, false);
        prsenter = new HomePrsenter(root.getContext());
        vSerch = root.findViewById(R.id.homeSerch);
            vSerch.setOnClickListener(this::OnClick);
        return root;

    }
    @Override
    public void OnClick(View view) {
        if(view == vSerch)
        {
            prsenter.goToSerchPage();
        }
    }
}
