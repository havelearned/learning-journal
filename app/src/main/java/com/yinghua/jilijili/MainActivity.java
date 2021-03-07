package com.yinghua.jilijili;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();
        if (WoelcomActivity.activity != null) {
            WoelcomActivity.activity.finish();
        }
        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.navigation_show, R.id.navigation_movie, R.id.navigation_dynamic).build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, configuration);

        NavigationUI.setupWithNavController(navigationView, navController);



    }


}
