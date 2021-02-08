package com.yinghua.viewpager.utily;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.yinghua.viewpager.bean.Cinema;
import com.yinghua.viewpager.bean.Movie;
import com.yinghua.viewpager.callback.CinemaCallback;
import com.yinghua.viewpager.ui.top.recommend.RecommendFragment;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络数据获取
 *
 * 获取服务器信息进行封装
 * */
public  class Networkdataacquisition  {

    public Networkdataacquisition(){
    };

    /**
     * 从服务器获取Movie的所有的信息
     *
     */
    public void NetListMovie(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build();

        Request request =new Request.Builder()
                .url(Consts.DDSP_URL_MOVIE)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //如果失败了
                Log.e("TAG","必败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //如果成功了
                String string = response.body().string();
                List<Movie> movies = JSON.parseArray(string, Movie.class);
                Log.e("Cinema",string+"\n"
                +movies.toString());
            }
        });
    }
}
