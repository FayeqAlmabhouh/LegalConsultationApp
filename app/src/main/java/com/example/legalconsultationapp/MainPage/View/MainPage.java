package com.example.legalconsultationapp.MainPage.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.legalconsultationapp.FavoritePage.View.FaveratFragment;
import com.example.legalconsultationapp.MainPageHome.View.HomeFragment;
import com.example.legalconsultationapp.ProfilePage.View.ProfileFragment;
import com.example.legalconsultationapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;


    private  MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);



        bottomNavigationView = findViewById(R.id.nav_view);

    bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,
                    new HomeFragment()).commit();

        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId())
            {
                case R.id.nav_home:
                    selectedFragment  = new HomeFragment();
                break;
                case  R.id.nav_faveret:
                    selectedFragment  = new FaveratFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment  = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainContainer, selectedFragment).commit();
            return true;
        }
    };


}

