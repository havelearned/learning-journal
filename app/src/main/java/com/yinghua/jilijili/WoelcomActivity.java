package com.yinghua.jilijili;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.utily.IndexCountDownTimerUtils;
import java.util.Random;

public class WoelcomActivity extends AppCompatActivity {
    public static Activity activity;
    String[] strImage = {"http://jilijili.fun/indexImage/1.jpg", "http://jilijili.fun/indexImage/2.gif", "http://jilijili.fun/indexImage/3.gif"};
    ImageView index_image;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woelcom);
        this.getSupportActionBar().hide();
        activity=this;
        
        //初始化视图
        inItView();
        
        //网络加载图片
        doIndexImage();

        Intent intent = new Intent();
        IndexCountDownTimerUtils countDownTimerUtils = new IndexCountDownTimerUtils(4000, 1000, button, this);
        countDownTimerUtils.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences spf = getPreferences(MODE_PRIVATE);
                boolean isFirst = spf.getBoolean("isFirst", true);
                if(isFirst){
                    spf.edit().putBoolean("isFirst",false).apply();
                    intent.setClass(WoelcomActivity.this,GuideActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    index(intent);
                }
            }
        },4000);

    }

    private void index(Intent intent) {
        intent.setClass(WoelcomActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void inItView() {
        index_image = findViewById(R.id.index_image);
        button = findViewById(R.id.bu_woelcom);
    }


    public void doIndexImage() {
        Random random = new Random();
        int S = random.nextInt(3);
        Glide.with(this).load(strImage[S]).into(index_image);

//        CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(60000, 1000, button);
//        countDownTimerUtils.start();
    }

}