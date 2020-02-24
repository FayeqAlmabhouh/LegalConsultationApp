package com.example.legalconsultationapp.LawyerContents.View;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.LawyerContents.Prsenter.ContactLawyerPrsenter;
import com.example.legalconsultationapp.LawyerContents.Prsenter.LawyerFun;
import com.example.legalconsultationapp.R;

public class ContactLawyer extends AppCompatActivity implements LawyerFun {

    private ContactLawyerPrsenter prsenter;
    private ContactLawyerViewHolder viewHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_lawyer_activity);
        ButterKnife.bind(this);
        intlOnStart();
        intlVariable();

    }

    @Override
    public void intlOnStart() {
        this.viewHolder = new ContactLawyerViewHolder(this);
        this.prsenter = new ContactLawyerPrsenter(this);
    }

    @Override
    public void intlVariable() {
        this.viewHolder.backBu.setOnClickListener(this::OnClick);
    }

    @Override
    public void OnClick(View view) {
        if (view == viewHolder.backBu)
            prsenter.backBu();

    }
}
