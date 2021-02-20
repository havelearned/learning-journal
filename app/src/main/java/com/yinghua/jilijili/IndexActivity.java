package com.yinghua.jilijili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.utily.ActivityCollector;
import com.yinghua.jilijili.utily.Consts;
import com.yinghua.jilijili.utily.CountDownTimerUtils;
import com.yinghua.jilijili.utily.IndexCountDownTimerUtils;
import com.yinghua.jilijili.utily.IndexCountDownTimerUtils2;

import java.util.Random;

import static com.yinghua.jilijili.utily.Consts.FIRST_USE;


/**
 * 首页
 */
public class IndexActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ActivityCollector.addActivity(this);
        this.getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences spf = getPreferences(MODE_PRIVATE);
                boolean isFirst = spf.getBoolean("isFirst", true);
                Intent intent = new Intent();
                if(isFirst){
                    spf.edit().putBoolean("isFirst",false).apply();
                    intent.setClass(IndexActivity.this, WoelcomActivity.class);
                    startActivity(intent);
                }else{
                    intent.setClass(IndexActivity.this, WoelcomActivity.class);

                }
                startActivity(intent);
                finish();

            }
        },500);
    }
}