package com.yinghua.jilijili.utily;

import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;


public class CountDownTimerUtils extends CountDownTimer {

    private Button button;
    long millisUntilFinished;
    public CountDownTimerUtils(long millisInFuture, long countDownInterval, Button button) {
        super(millisInFuture, countDownInterval);
        this.button = button;

    }

    @Override
    public void onTick(long millisUntilFinished) {
        button.setClickable(false); //设置不可点击
        button.setText(millisUntilFinished / 1000 + "s");  //设置倒计时显示时间和文字
        this.millisUntilFinished=millisUntilFinished;
        button.setTextColor(Color.parseColor("#FFA3A3A3"));//设置字体的颜色
//        button.setBackgroundResource(R.drawable.shape_register_code); //设置按钮不可点击的样式

    }

    public void onTick(boolean Clickable){
        button.setClickable(Clickable); //设置不可点击
        button.setText(this.millisUntilFinished / 1000 + "s");  //设置倒计时显示时间和文字
        button.setTextColor(Color.parseColor("#FFA3A3A3"));//设置字体的颜色
//        button.setBackgroundResource(R.drawable.shape_register_code); //设置按钮不可点击的样式

    }
    @Override
    public void onFinish() {
        button.setText("获取验证码");
        button.setClickable(true);//重新获得点击
//        button.setBackgroundResource(R.drawable.shape_register_code_red);//还原背景色

    }
}
