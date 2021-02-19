package com.yinghua.jilijili.pagding.moviepagding;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;

import com.yinghua.jilijili.bean.Movie;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieDataSourceItme extends ItemKeyedDataSource<Integer, Movie> {

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Movie> callback) {
        MoviesRetrofitClient.getInstance()
                .movieService()
                .getAllMovies(params.requestedInitialKey,4)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        if(response.body()!=null){
                            Log.e(Consts.TAG,"MovieDataSourceItme_请求成功:"+response.body().toString() );
                            callback.onResult(response.body(),0,16);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                            Log.e(Consts.TAG,"MovieDataSourceItme_请求成功:"+t.getMessage() );
                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Movie> callback) {
        MoviesRetrofitClient.getInstance()
                .movieService()
                .getAllMovies(params.requestedLoadSize,4)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        Log.e("TAG", "请求成功：" + response.toString());
                        if (response.body() != null) {

                            callback.onResult(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        Log.e("TAG", "请求失败：" + t.getMessage());
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Movie> callback) {

    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Movie item) {
        return null;
    }


}
