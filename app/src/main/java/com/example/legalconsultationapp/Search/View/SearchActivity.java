package com.example.legalconsultationapp.Search.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.legalconsultationapp.R;
import com.example.legalconsultationapp.Search.Prsenter.SerchPrsenter;
import com.example.legalconsultationapp.SignUp.Prsenter.SinUpViewFun;

public class SearchActivity extends AppCompatActivity implements SinUpViewFun {

    private TextView vBacckbu;
    private SerchPrsenter prsenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        prsenter = new SerchPrsenter(this);


        vBacckbu = findViewById(R.id.SBackBU);
            vBacckbu.setOnClickListener(this::OnClick);




    }

    @Override
    public void OnClick(View view){

        if (view == vBacckbu)
        {
          prsenter.backButon();

        }


    }
}
