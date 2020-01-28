package com.example.legalconsultationapp.ProfilePage.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.legalconsultationapp.ProfilePage.Prsenter.EditeProfilePrsenter;
import com.example.legalconsultationapp.ProfilePage.Prsenter.ProfilePrsenter;
import com.example.legalconsultationapp.ProfilePage.Prsenter.ProfileViewFun;
import com.example.legalconsultationapp.R;

public class ProfileFragment extends Fragment implements ProfileViewFun {

    private ProfilePrsenter prsenter;
    private ImageButton bEditePage , blogOut ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.profile_fragment, container, false);
          prsenter = new ProfilePrsenter(root.getContext());
            bEditePage = root.findViewById(R.id.profilePageEditeBu);
              bEditePage.setOnClickListener(this::OnClick);
            blogOut = root.findViewById(R.id.profilePagelogoutBu);
               blogOut.setOnClickListener(this::OnClick);
        return root;
    }
    @Override
    public void OnClick(View view){
        if (view == bEditePage)
        {
            prsenter.GoToEditepage();
        }
        if (view == blogOut)
        {
            prsenter.logOut();
        }
    }
}
