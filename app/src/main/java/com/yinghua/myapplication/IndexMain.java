package com.yinghua.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yinghua.myapplication.ui.view.bottom.dynamic.DynamicFragment;
import com.yinghua.myapplication.ui.view.bottom.moive.MovieFragment;
import com.yinghua.myapplication.ui.view.bottom.my.MyFragment;
import com.yinghua.myapplication.ui.view.bottom.show.ShowFragment;
import com.yinghua.myapplication.ui.view.top.boxoffice.BoxofficeFragment;
import com.yinghua.myapplication.ui.view.top.comingsoon.ComingSoonFragment;
import com.yinghua.myapplication.ui.view.top.recommend.RecommendFragment;
import com.yinghua.myapplication.ui.view.top.starrnaking.StrrnaKingFragment;
import com.yinghua.myapplication.utily.MyFragAdapter;
import com.yinghua.myapplication.utily.TopFragAdapter;

import java.util.ArrayList;
import java.util.List;

public class IndexMain extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ViewPager viewPager;
    BottomNavigationView navigation;//底部导航栏对象
    List<Fragment> listFragment;//存储页面对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_main);
        this.getSupportActionBar().hide();

        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}