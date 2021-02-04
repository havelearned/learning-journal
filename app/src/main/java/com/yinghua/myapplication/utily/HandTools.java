package com.yinghua.myapplication.utily;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class HandTools extends GestureDetector.SimpleOnGestureListener  {
    String Tag ="Tag";
    //定义滑动的最小距离
    private static final int MIN_DISTANCE=100;
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX()-e2.getX()>MIN_DISTANCE){
            Log.e(Tag,"左滑");
        }else if(e2.getX()-e1.getX()>MIN_DISTANCE){
            Log.e(Tag,"右滑");
        }else if(e1.getY()-e2.getY()>MIN_DISTANCE){
            Log.e(Tag,"上滑");
        }else if(e2.getY()-e1.getY()>MIN_DISTANCE){
            Log.e(Tag,"下滑");
        }
        return true;
    }
}
