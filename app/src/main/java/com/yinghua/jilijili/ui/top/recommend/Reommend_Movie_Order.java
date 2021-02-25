package com.yinghua.jilijili.ui.top.recommend;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Observable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.provider.ContactsContract;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yinghua.jilijili.LoginActivity;
import com.yinghua.jilijili.OrderActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.app.JiliJiliSharedPreferences;
import com.yinghua.jilijili.bean.Orderforgoods;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reommend_Movie_Order extends Fragment {
    JiliJiliSharedPreferences preferences;
    SharedPreferences sharedPreferences;
    Button ll_order;
    TextView login_deal,to_login;
    AlertDialog alertDialog;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reommend__movie__order, container, false);

        View itme_order = LayoutInflater.from(getContext()).inflate(R.layout.itme_order, null);
        ll_order = view.findViewById(R.id.ll_order);
        to_login=itme_order.findViewById(R.id.to_login);
        login_deal=itme_order.findViewById(R.id.login_deal);

        //itme_order 点击事件
        itmeOrderViewOnClick();

//        ImageButton button = view.findViewById(R.id.zhifubao);


        //如果已经登录可以直接购买如果没有登录需要去登录页面
        preferences = new JiliJiliSharedPreferences(getActivity().getApplicationContext());
        sharedPreferences = preferences.get();
        String tel = sharedPreferences.getString("tel", "0000000000");
        String ticketNickname = sharedPreferences.getString("ticketNickname", "请登录");
        if (tel.equals("0000000000")) {
            Log.e(Consts.TAG, "未登录需要去登录");
            //对话框
            alertOrder(container, view, itme_order);
        } else {
            Log.e(Consts.TAG, "登录可以购买");
            //跳转到订单页面,带上电影参数
            ll_order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = getActivity().getIntent();
                    String[] movies = intent.getStringArrayExtra("movie");
                    ArraySet<String> arraySet = new ArraySet<>();
                    arraySet.add(movies[3]);//电影名称
                    arraySet.add(movies[5]);//图片地址*/
                    preferences.save(movies[3], arraySet);//保存了当前用户下单数据

                    //根据手机号进行保存
                    MoviesRetrofitClient.getInstance()
                            .orderforgoodsService()
                            .requestOder(movies[3], ticketNickname, tel)
                            .enqueue(new Callback<Orderforgoods>() {
                                @Override
                                public void onResponse(Call<Orderforgoods> call, Response<Orderforgoods> response) {
                                    if (response.code() == 200) {
                                        Log.e(Consts.TAG, "请求成功：" + response.raw());
                                        Orderforgoods body = response.body();
                                    } else {
                                        Log.e(Consts.TAG, "请求失败：" + response.raw());
                                    }
                                }

                                @Override
                                public void onFailure(Call<Orderforgoods> call, Throwable t) {
                                    Log.e(Consts.TAG, "请求失败：" + t.getMessage());
                                }
                            });

                    intent.putExtra("movies", movies);
                    intent.setClass(getContext(), OrderActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }

        return view;
    }

    private void itmeOrderViewOnClick() {
        //其他方式登录
        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();//关闭对话框
                Intent intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();

            }
        });

        //肌哩肌哩使用条框
        login_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri parse = Uri.parse("http://jilijili.fun/clause.html");
                intent.setData(parse);
                getContext().startActivity(intent);
            }
        });
    }

    private void alertOrder(ViewGroup container, View view, View itme_order) {
        ll_order.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //对话框
                alertDialog = new AlertDialog.Builder(getActivity())
                        .setCancelable(false) //周围不可取消
                        .setView(itme_order)
                        .create();
                alertDialog.show();

                return true;
            }
        });

        //关闭对话框
        itme_order.findViewById(R.id.login_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              alertDialog.dismiss();
            }
        });
    }


}