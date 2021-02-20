package com.yinghua.jilijili.pagding.moviepagding;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.yinghua.jilijili.bean.Movie;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDataSource extends PositionalDataSource<Movie> {
    int start = 0;
    public static int PGE = 10;

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Movie> callback) {
        MoviesRetrofitClient.getInstance()
                .movieService()
                .getAllMovies(start, PGE)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        if (response.body() != null) {

                            Log.e(Consts.TAG, "loadInitial_请求成功" + response.raw());
                            System.out.println(response.toString());
                            callback.onResult(response.body(),0);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        t.printStackTrace();
                        Log.e(Consts.TAG, "请求失败了" + t.getMessage());
                    }
                });
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Movie> callback) {

        MoviesRetrofitClient.getInstance()
                .movieService()
                .getAllMovies(0, PGE)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        if (response.body() != null) {
                            Log.e(Consts.TAG, "loadInitial_请求成功" + response.raw());
                            callback.onResult(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        Log.e(Consts.TAG, "请求失败了" + t.getMessage());
                    }
                });
    }
}
