package com.yinghua.jilijili.pagding.jouralism;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;

import com.yinghua.jilijili.bean.Journalism;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JournalismDataSource extends PositionalDataSource<Journalism> {
    private static Integer start = 0;
    private static Integer PAGE=10;


    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Journalism> callback) {
        MoviesRetrofitClient
                .getInstance("https://way.jd.com/jisuapi/")
                .mJournalismService()
                .requestJournalismList("头条", 1000, start, "4e69e20b3c7f735e7a6ba1ad250c4ef3")
                .enqueue(new Callback<Journalism>() {
                    @Override
                    public void onResponse(Call<Journalism> call, Response<Journalism> response) {
                        Log.e(Consts.TAG, "请求：" + response.raw());
                        if (response.body() != null) {
                            if (response.code() == 200) {
                                Journalism body = response.body();
                                List<Journalism> journalisms=new ArrayList<>();
                                journalisms.add(body);

                                callback.onResult(journalisms, params.requestedStartPosition);
                            }
                        } else {
                            Log.e(Consts.TAG, "请求失败：" + response.raw());
                        }
                    }

                    @Override
                    public void onFailure(Call<Journalism> call, Throwable t) {
                        Log.e(Consts.TAG, "请求失败：" + t.getMessage());
                    }
                });
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Journalism> callback) {
        MoviesRetrofitClient
                .getInstance("https://way.jd.com/jisuapi/")
                .mJournalismService()
                .requestJournalismList("头条", 1000, start, "4e69e20b3c7f735e7a6ba1ad250c4ef3")
                .enqueue(new Callback<Journalism>() {
                    @Override
                    public void onResponse(Call<Journalism> call, Response<Journalism> response) {
                        Log.e(Consts.TAG, "请求：" + response.raw());
                        if (response.body() != null) {
                            if (response.code() == 200) {
                                Journalism body = response.body();
                                List<Journalism> journalisms=new ArrayList<>();
                                journalisms.add(body);
                                start+=10;
                                callback.onResult(journalisms);
                            }
                        } else {
                            Log.e(Consts.TAG, "请求失败：" + response.raw());
                        }
                    }

                    @Override
                    public void onFailure(Call<Journalism> call, Throwable t) {
                        Log.e(Consts.TAG, "请求失败：" + t.getMessage());
                    }
                });
    }
}
