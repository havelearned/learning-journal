package com.yinghua.jilijili.ui.top.recommend.order;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.adapter.OrderAdapter;
import com.yinghua.jilijili.app.JiliJiliSharedPreferences;
import com.yinghua.jilijili.bean.Orderforgoods;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UndoneFragment extends Fragment {
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    PullRefreshLayout xl_pull;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getActivity().getIntent();
        String[] movies = intent.getStringArrayExtra("movies");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_undone2, container, false);
        sharedPreferences = new JiliJiliSharedPreferences(getContext().getApplicationContext()).get();
        String tel = sharedPreferences.getString("tel", "00000000000");
        recyclerView = view.findViewById(R.id.order_recyclerView);
        xl_pull = view.findViewById(R.id.xl_pull);
        xl_pull.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (tel.equals("00000000000")) {
                    Toast.makeText(getContext(), "未知错误前联系管理员", Toast.LENGTH_SHORT).show();
                } else {
                    MoviesRetrofitClient.getInstance()
                            .orderforgoodsService()
                            .requestQueryOders(tel)
                            .enqueue(new Callback<List<Orderforgoods>>() {
                                @Override
                                public void onResponse(Call<List<Orderforgoods>> call, Response<List<Orderforgoods>> response) {
                                    if (response.code() == 200) {
                                        Log.e(Consts.TAG, "请求成功：" + response.raw());

                                        List<Orderforgoods> orders = response.body();
                                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                        recyclerView.setAdapter(new OrderAdapter(getContext(), orders));
                                    } else {
                                        Log.e(Consts.TAG, "请求失败：" + response.raw());
                                    }
                                }
                                @Override
                                public void onFailure(Call<List<Orderforgoods>> call, Throwable t) {
                                    Log.e(Consts.TAG, "请求失败：" + t.getMessage());
                                }
                            });
                }
                xl_pull.setRefreshing(false);
            }
        });
        if (tel.equals("00000000000")) {
            Toast.makeText(getContext(), "未知错误前联系管理员", Toast.LENGTH_SHORT).show();
        } else {
            MoviesRetrofitClient.getInstance()
                    .orderforgoodsService()
                    .requestQueryOders(tel)
                    .enqueue(new Callback<List<Orderforgoods>>() {
                        @Override
                        public void onResponse(Call<List<Orderforgoods>> call, Response<List<Orderforgoods>> response) {
                            if (response.code() == 200) {
                                Log.e(Consts.TAG, "请求成功：" + response.raw());

                                List<Orderforgoods> orders = response.body();
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                recyclerView.setAdapter(new OrderAdapter(getContext(), orders));
                            } else {
                                Log.e(Consts.TAG, "请求失败：" + response.raw());
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Orderforgoods>> call, Throwable t) {
                            Log.e(Consts.TAG, "请求失败：" + t.getMessage());
                        }
                    });

        }


        return view;
    }
}