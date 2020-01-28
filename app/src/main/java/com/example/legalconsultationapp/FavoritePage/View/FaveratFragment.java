package com.example.legalconsultationapp.FavoritePage.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.legalconsultationapp.FavoritePage.Prsenter.FavertPresnter;
import com.example.legalconsultationapp.FavoritePage.Prsenter.FavertViewFun;
import com.example.legalconsultationapp.R;

public class FaveratFragment extends Fragment implements FavertViewFun {
    private FavertPresnter presnter;
    private TextView vFaveratSerch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.faverat_fragment, container, false);

        presnter = new FavertPresnter(root.getContext());

            vFaveratSerch = root.findViewById(R.id.FavertSerch);
                vFaveratSerch.setOnClickListener(this::OnClick);
        return  root;
    }
    @Override
    public void OnClick(View view) {
        if (view == vFaveratSerch)
        {
            presnter.GoToSerchPage();
        }
    }
}
