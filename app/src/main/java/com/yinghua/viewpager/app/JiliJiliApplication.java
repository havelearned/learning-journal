package com.yinghua.viewpager.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.yinghua.viewpager.utily.Consts;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 *
 */
public class JiliJiliApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        InitOkHttpClient();
        /**
         * 成功连接上网络时才能调用Okhttp
         * */
        boolean networkAvailable = isNetworkAvailable(getApplicationContext());
    }

    private  void InitOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor(Consts.TAG)) //日志
                .connectTimeout(10000L, TimeUnit.MILLISECONDS) //连接超时/微秒
                .readTimeout(10000L, TimeUnit.MICROSECONDS) //读取超时 /微秒
                .build();
        OkHttpUtils okHttpUtils = OkHttpUtils.initClient(okHttpClient);



    }


    /**
     * 判断是否有网
     */
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
                        Toast.makeText(context, "请打开网络数据", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
