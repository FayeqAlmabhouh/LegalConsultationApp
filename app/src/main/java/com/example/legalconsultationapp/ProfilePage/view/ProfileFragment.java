package com.example.legalconsultationapp.ProfilePage.view;


import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.legalconsultationapp.UserModel.UserPreferences;
import com.example.legalconsultationapp.ProfilePage.prsenter.ProfilePrsenter;
import com.example.legalconsultationapp.ProfilePage.prsenter.ProfileViewFun;
import com.example.legalconsultationapp.R;

public class ProfileFragment extends Fragment implements ProfileViewFun {

    private ViewProfileHolder viewProfileHolder;
    private ProfilePrsenter profilePrsenter;
    private UserPreferences userData;
    private View root;
    private Dialog dialog;
    private TextView dilogcalcel, dilogLogOut;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.profile_fragment, container, false);
        ButterKnife.bind(this, getActivity());
        CallPrsenter();
        CallVariable();
        return root;
    }

    @Override
    public void OnClick(View view) {
        if (view == viewProfileHolder.logOutBu)
            initDialog();
        else if (view == viewProfileHolder.editeProfile)
            profilePrsenter.GoToEditepage();
    }

    @Override
    public void CallPrsenter() {
        this.viewProfileHolder = new ViewProfileHolder(this.root);
        this.profilePrsenter = new ProfilePrsenter(root.getContext());
        this.userData = new UserPreferences(getContext());

    }

    @Override
    public void CallVariable() {
        viewProfileHolder.logOutBu.setOnClickListener(this::OnClick);
        viewProfileHolder.editeProfile.setOnClickListener(this::OnClick);
        viewProfileHolder.editePassword.setOnClickListener(this::OnClick);
        viewProfileHolder.vUserName.setText(userData.getUserName());
        viewProfileHolder.vUserName.setOnClickListener(this::OpenEditePage);
        viewProfileHolder.vUserEmail.setText(userData.getUserEmail());
        viewProfileHolder.vUserEmail.setOnClickListener(this::OpenEditePage);
        viewProfileHolder.phoneNumper.setText(userData.getUserPhone());
        viewProfileHolder.phoneNumper.setOnClickListener(this::OpenEditePage);
    }

    @Override
    public void OpenEditePage(View v) {
        profilePrsenter.GoToEditepage();
    }

    @Override
    public void DialogClicic(View v) {
        if (v == dilogLogOut)
            profilePrsenter.logOut();
        else if (v == dilogcalcel)
            dialog.dismiss();
    }

    @Override
    public void initDialog() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dilog);
        dilogLogOut = dialog.findViewById(R.id.dilog_logOut);
        dilogLogOut.setOnClickListener(this::DialogClicic);
        dilogcalcel = dialog.findViewById(R.id.dilog_cancel);
        dilogcalcel.setOnClickListener(this::DialogClicic);
        dialog.show();

    }
}
