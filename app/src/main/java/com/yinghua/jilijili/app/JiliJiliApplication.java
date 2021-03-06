package com.yinghua.jilijili.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.ArraySet;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.yinghua.jilijili.utily.Consts;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * app 全局配置
 *
 *InitOkHttpClient（） 成功连接上网络时才能调用Okhttp
 *
 * isNetworkAvailable（） 判断是否有网
 */
public class JiliJiliApplication extends Application {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate() {
        super.onCreate();


        InitOkHttpClient();


        isNetworkAvailable(getApplicationContext());
    }

    private void InitOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor(Consts.TAG)) //日志
                .connectTimeout(10000L, TimeUnit.MILLISECONDS) //连接超时/微秒
                .readTimeout(10000L, TimeUnit.MICROSECONDS) //读取超时 /微秒
                .build();
        OkHttpUtils okHttpUtils = OkHttpUtils.initClient(okHttpClient);


    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            Log.e(Consts.TAG, "网络出现异常");
            Toast.makeText(context, "网络出现异常", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        Log.e(Consts.TAG, "网络可用");
                        Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show();
                        return true;
                    } else {
                        Log.e(Consts.TAG, "网络不可用");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
