package com.yinghua.jilijili;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yinghua.jilijili.ui.top.recommend.Reommend_Movie_Info;
import com.yinghua.jilijili.ui.top.recommend.Reommend_Movie_Order;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieInfo extends AppCompatActivity {
    ImageView imageView;
    ViewPager2 viewPager2;
    TabLayout tableLayout;
    Bundle bundle;//传递参数

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        this.getSupportActionBar().hide();
        imageView=findViewById(R.id.test_image);
        Intent intent = getIntent();
        String[] movies = intent.getStringArrayExtra("movie");
        Glide.with(this).load(movies[5]).into(imageView);

        bundle= new Bundle();
        bundle.putStringArray("movies",movies);
        inItViewPage();
    }

    private void inItViewPage() {
        tableLayout = findViewById(R.id.itest_TabLayout);
        viewPager2 = findViewById(R.id.testViewPage);
        //适配器分配多少个页面
        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            //对应的位置，分配哪个一页面
            public Fragment createFragment(int position) {
                if (position == 0) {
                    Reommend_Movie_Info reommend_movie_info = new Reommend_Movie_Info();
                    reommend_movie_info.setArguments(bundle);
                    return reommend_movie_info;
                } else if (position == 1) {


                    return new Reommend_Movie_Order();
                }
                return null;
            }

            //告诉 viewPage2有多少个页面
            @Override
            public int getItemCount() {
                return 2;
            }
        });

        //设置ViewPager2的预加载数，传入大于1的值来设置预加载数量，默认不预加载
        viewPager2.setOffscreenPageLimit(1);

        new TabLayoutMediator(tableLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {

            //设置标题
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("详情");
                } else if (position == 1) {
                    tab.setText("购买电影票");
                }
            }
        }).attach();
    }
}