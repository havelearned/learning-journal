package com.yinghua.jilijili.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.yinghua.jilijili.utily.Consts;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class JiliJiliApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        InitOkHttpClient();
        /**
         * 成功连接上网络时才能调用Okhttp
         * */
        isNetworkAvailable(getApplicationContext());


        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
       /* SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);*/

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
