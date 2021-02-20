package com.yinghua.jilijili.utily;

import android.app.Activity;

import com.yinghua.jilijili.MainActivity;

import java.util.ArrayList;
import java.util.List;

public  class ActivityCollector {
    public static List<Activity> activitys = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activitys.add(activity);//把传入的Activity添加到List中
    }

    public static void removeActivity(Activity activity) {
        activitys.remove(activity);//根据传入的Activity来删除
    }


    public static void removeAll() {
        for (Activity activity : activitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }


    /**
     * 除了传来的Activity其他的全部删除
     * 可以传多个Activity
     * @param clazz
     */
    public static void removeAll(Class<?>... clazz) {
        boolean isExist = false;
        for (Activity act : activitys) {
            for (Class c : clazz) {
                if (act.getClass().isAssignableFrom(c)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                if (!act.isFinishing()) {
                    act.finish();
                }
            } else {
                isExist = false;
            }
        }
    }
}
