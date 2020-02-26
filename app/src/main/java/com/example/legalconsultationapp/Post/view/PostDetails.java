package com.example.legalconsultationapp.Post.view;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.legalconsultationapp.Post.prsenter.AllPostFun;
import com.example.legalconsultationapp.Post.prsenter.PostDetailsPrsenters;
import com.example.legalconsultationapp.R;

public class PostDetails extends AppCompatActivity implements AllPostFun {

    private PostDetailsPrsenters prsenters;
    private PostDetailsViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_activity_detiles);
        ButterKnife.bind(this);
        intlOnStart();
        intlVariable();
    }

    @Override
    public void intlOnStart() {
        this.prsenters = new PostDetailsPrsenters(this);
        this.viewHolder = new PostDetailsViewHolder(this);
    }

    @Override
    public void intlVariable() {
        this.viewHolder.PostBack.setOnClickListener(this::OnClick);
        this.viewHolder.homePage.setOnClickListener(this::OnClick);
        this.prsenters.setPosDat(viewHolder.postImg, viewHolder.postDate, viewHolder.postTitel, viewHolder.postContent);
        this.viewHolder.ContactLawyer.setOnClickListener(this::OnClick);
        this.viewHolder.freeAdvice.setOnClickListener(this::OnClick);
        this.viewHolder.favoriteBu.setOnClickListener(this::faveriteBuListener);
    }

    @Override
    public void OnClick(View view) {
        if (view == this.viewHolder.PostBack)
            prsenters.backBu();
        if (view == this.viewHolder.homePage)
            prsenters.mainPage();
        if (view == viewHolder.ContactLawyer)
            prsenters.openContactLawyer();
        if (view == viewHolder.freeAdvice)
            prsenters.openFreeAdvice();
    }

    public void faveriteBuListener(View v) {
        this.viewHolder.favoriteBu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    viewHolder.favoriteBu.setBackgroundResource(R.drawable.ic_star_is_click);
                    prsenters.savePostInFavert();
                } else {
                    viewHolder.favoriteBu.setBackgroundResource(R.drawable.ic_star_no_click);
                    prsenters.removePostFavert();
                }
            }
        });
    }


}

