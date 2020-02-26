package com.example.legalconsultationapp.Post.prsenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.legalconsultationapp.AppUtils.AppUtils;
import com.example.legalconsultationapp.Constant.ConstantPage;
import com.example.legalconsultationapp.Post.model.AllPostStructure;
import com.example.legalconsultationapp.Post.model.PostDetailModel;
import com.example.legalconsultationapp.Post.view.AllPostActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;

import androidx.annotation.NonNull;

public class PostDetailsPrsenters {

    private Activity activity;
    private AppUtils appUtils;
    private PostDetailModel model;
    private ConstantPage constantPage;

    public PostDetailsPrsenters(Activity activity) {
        this.activity = activity;
        this.appUtils = new AppUtils(this.activity);
        this.model = new PostDetailModel();
        this.constantPage = new ConstantPage(this.activity);
    }

    public void backBu() {
        Intent allPostPage = new Intent(activity, AllPostActivity.class);
        activity.startActivity(allPostPage);
        activity.finish();
    }

    public void mainPage() {
        constantPage.OpenMainPage();
    }

    public void setPosDat(ImageView posImg, TextView date, TextView titel, TextView content) {
        String dateFormat = DateFormat.getDateInstance().format(AllPostStructure.SelectedPostStructure.getDate());
        date.setText(dateFormat);
        titel.setText(AllPostStructure.SelectedPostStructure.getTitle());
        content.setText(AllPostStructure.SelectedPostStructure.getDescription());
        if (!(AllPostStructure.SelectedPostStructure.getImage().isEmpty()))
            Picasso.with(activity).load(AllPostStructure.SelectedPostStructure.getImage()).into(posImg);
    }

    public void openContactLawyer() {
        constantPage.openContactLawyer();
    }

    public void openFreeAdvice() {
        constantPage.openFreeAdvice();
    }

    public void savePostInFavert() {
        appUtils.ShowLoadingDialogue();
        model.addFavertPost(AllPostStructure.SelectedPostStructure.getKey()).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                appUtils.dialogDismiss();
            }
        });
    }

    public void removePostFavert() {
        appUtils.ShowLoadingDialogue();
        model.removeFavertPost(AllPostStructure.SelectedPostStructure.getKey()).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                appUtils.dialogDismiss();
            }
        });
    }

}
