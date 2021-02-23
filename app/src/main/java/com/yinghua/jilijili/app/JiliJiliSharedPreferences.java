package com.yinghua.jilijili.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;
import android.util.Log;

import com.yinghua.jilijili.R;
import com.yinghua.jilijili.utily.Consts;

import java.util.Set;

public class JiliJiliSharedPreferences {
    private Context context;
    String dataName="null";
    public SharedPreferences JiliJiliSharedPreferences;

    public JiliJiliSharedPreferences(Context context) {
        this.context = context;
        dataName= context.getResources().getString(R.string.app_name);
    }


    public boolean save(String key, boolean flag) {

        SharedPreferences spf = context.getSharedPreferences(dataName, Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = spf.edit();
        edit.putBoolean(key, flag);
        edit.apply();
        Log.e(Consts.TAG,dataName+" xml文件保存了："+key+":"+flag);

        return flag;
    }

    public String save(String key, String value) {

        SharedPreferences spf = context.getSharedPreferences(dataName, Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = spf.edit();
        edit.putString(key, value);
        edit.apply();
        Log.e(Consts.TAG,dataName+" xml文件保存了："+key+":"+value);

        return value;
    }

    public int save(String key, int value) {

        SharedPreferences spf = context.getSharedPreferences(dataName, Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = spf.edit();
        edit.putInt(key, value);
        edit.apply();

        Log.e(Consts.TAG,dataName+" xml文件保存了："+key+":"+value);
        return value;
    }

    public Set save(String key, Set values) {

        SharedPreferences spf = context.getSharedPreferences(dataName, Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = spf.edit();
        edit.putStringSet(key, values);
        edit.apply();
        Log.e(Consts.TAG,dataName+" xml文件保存了："+key+":"+values);
        return values;
    }


    public SharedPreferences get() {

        JiliJiliSharedPreferences = context.getSharedPreferences(dataName, Context.MODE_PRIVATE);
        return JiliJiliSharedPreferences;
    }


    public void remove(String key) {

        SharedPreferences spf = context.getSharedPreferences(dataName, Context.MODE_PRIVATE);
        spf.edit().remove(key).apply();
        Log.e(Consts.TAG,dataName+"xml文件删除了："+key);
    }


    public void remove(String... key) {

        SharedPreferences spf = context.getSharedPreferences(dataName, Context.MODE_PRIVATE);
        if (key.length <= 1) {
            spf.edit().remove(key[0]).apply();
            Log.e(Consts.TAG,dataName+"xml文件删除了："+key[0]);

        }else {
            for (String s : key) {
                spf.edit().remove(s).apply();
                Log.e(Consts.TAG,dataName+"xml文件删除了："+s);
            }
        }
    }
}
