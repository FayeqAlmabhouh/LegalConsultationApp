package com.example.legalconsultationapp.LawyerContents.View;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.example.legalconsultationapp.LawyerContents.Prsenter.FreeAdvicePrsenter;
import com.example.legalconsultationapp.LawyerContents.Prsenter.LawyerFun;
import com.example.legalconsultationapp.R;

public class RequestFreeAdvice extends AppCompatActivity implements LawyerFun {

    private FreeAdvicePrsenter prsenter;
    private FreeAdviceViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_free_advice_activity);
        ButterKnife.bind(this);
        intlOnStart();
        intlVariable();

    }

    @Override
    public void intlOnStart() {
        this.prsenter = new FreeAdvicePrsenter(this);
        this.viewHolder = new FreeAdviceViewHolder(this);
    }


    @Override
    public void intlVariable() {
        this.viewHolder.freeAdviceBu.setOnClickListener(this::OnClick);

    }

    @Override
    public void OnClick(View view) {
        if (view == viewHolder.freeAdviceBu)
            prsenter.backBu();
    }
}
