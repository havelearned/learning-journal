package com.yinghua.jilijili.ui.top.recommend.order;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.adapter.OrderSuccessAdapter;
import com.yinghua.jilijili.app.JiliJiliSharedPreferences;
import com.yinghua.jilijili.bean.ConfirmOrder;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuccessFragment extends Fragment {
    SharedPreferences sharedPreferences;
    PullRefreshLayout pull_success;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_success, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_success);
        pull_success = view.findViewById(R.id.pull_success);

        sharedPreferences = new JiliJiliSharedPreferences(getContext().getApplicationContext()).get();
        String tel = sharedPreferences.getString("tel", "00000000000");


        if (tel.equals("00000000000")) {
            Toast.makeText(getContext(), "请先登录", Toast.LENGTH_SHORT).show();
        } else {
            MoviesRetrofitClient.getInstance()
                    .orderforgoodsService()
                    .requestQueryCofirmOders(tel)
                    .enqueue(new Callback<List<ConfirmOrder>>() {
                        @Override
                        public void onResponse(Call<List<ConfirmOrder>> call, Response<List<ConfirmOrder>> response) {
                            if (response.body() != null) {
                                if (response.code() == 200) {
                                    Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单成功:" + response.raw());

                                    List<ConfirmOrder> body = response.body();
                                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                    recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                                    recyclerView.setAdapter(new OrderSuccessAdapter(getContext(), body));
                                } else {
                                    Toast.makeText(getContext(), "请求已完成的订单失败", Toast.LENGTH_SHORT).show();
                                    Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单失败:" + response.raw());
                                }

                            } else {
                                Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单失败:" + response.raw());
                            }
                        }

                        @Override
                        public void onFailure(Call<List<ConfirmOrder>> call, Throwable t) {
                            Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单失败:" + t.getMessage());
                        }
                    });

        }

        pull_success.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (tel.equals("00000000000")) {
                    Toast.makeText(getContext(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    MoviesRetrofitClient.getInstance()
                            .orderforgoodsService()
                            .requestQueryCofirmOders(tel)
                            .enqueue(new Callback<List<ConfirmOrder>>() {
                                @Override
                                public void onResponse(Call<List<ConfirmOrder>> call, Response<List<ConfirmOrder>> response) {
                                    if (response.body() != null) {
                                        if (response.code() == 200) {
                                            Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单成功:" + response.raw());

                                            List<ConfirmOrder> body = response.body();
                                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                                            recyclerView.setAdapter(new OrderSuccessAdapter(getContext(), body));
                                        } else {
                                            Toast.makeText(getContext(), "请求已完成的订单失败", Toast.LENGTH_SHORT).show();
                                            Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单失败:" + response.raw());
                                        }

                                    } else {
                                        Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单失败:" + response.raw());
                                    }
                                }

                                @Override
                                public void onFailure(Call<List<ConfirmOrder>> call, Throwable t) {
                                    Log.e(Consts.TAG, "SuccessFragment.onResponse_请求已完成的订单失败:" + t.getMessage());
                                }
                            });
                }
                pull_success.setRefreshing(false);
            }
        });


        return view;
    }
}