package com.yinghua.jilijili.utily;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;

import com.yinghua.jilijili.GuideActivity;
import com.yinghua.jilijili.IndexActivity;
import com.yinghua.jilijili.LoginActivity;
import com.yinghua.jilijili.MainActivity;


public class IndexCountDownTimerUtils extends CountDownTimer {

    private Button button;
    Context context;

    public IndexCountDownTimerUtils(long millisInFuture, long countDownInterval, Button button, android.content.Context context) {
        super(millisInFuture, countDownInterval);
        this.button = button;
        this.context = context;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        button.setText(millisUntilFinished / 1000 + "s");  //设置倒计时显示时间和文字
        button.setTextColor(Color.parseColor("#FFA3A3A3"));//设置字体的颜色
//        button.setBackgroundResource(R.drawable.shape_register_code); //设置按钮不可点击的样式

    }

    public void onFinish() {


//        button.setBackgroundResource(R.drawable.shape_register_code_red);//还原背景色

    }
}
