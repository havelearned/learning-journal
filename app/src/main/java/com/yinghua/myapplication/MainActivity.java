package com.yinghua.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.yinghua.myapplication.utily.HandTools;

public class MainActivity extends AppCompatActivity {
   /* private HandTools handTools;
    GestureDetector gestureDetector;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*

        //实例化MyGestureDetector
        handTools=new HandTools();

        //实例化GestureDetector并将MyGestureDetector实例传入
        gestureDetector= new GestureDetector(this, handTools);
*/

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IndexMain.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 重写onTouchEvent返回一个gestureDetector的屏幕触摸事件
     */
  /*  @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }*/

}