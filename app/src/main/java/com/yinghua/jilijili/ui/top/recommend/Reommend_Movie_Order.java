package com.yinghua.jilijili.ui.top.recommend;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yinghua.jilijili.LoginActivity;
import com.yinghua.jilijili.OrderActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.app.JiliJiliSharedPreferences;
import com.yinghua.jilijili.bean.Orderforgoods;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.core.content.ContextCompat.getSystemService;

public class Reommend_Movie_Order extends Fragment {
    JiliJiliSharedPreferences preferences;
    SharedPreferences sharedPreferences;
    Button ll_order;
    TextView login_deal, to_login;
    AlertDialog alertDialog;
    Intent intent;
    Context context=getContext();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reommend__movie__order, container, false);

        View itme_order = LayoutInflater.from(getContext()).inflate(R.layout.itme_order, null);
        ll_order = view.findViewById(R.id.ll_order);
        to_login = itme_order.findViewById(R.id.to_login);
        login_deal = itme_order.findViewById(R.id.login_deal);

        //itme_order 点击事件
        itmeOrderViewOnClick();

//        ImageButton button = view.findViewById(R.id.zhifubao);


        //如果已经登录可以直接购买如果没有登录需要去登录页面
        preferences = new JiliJiliSharedPreferences(getActivity().getApplicationContext());
        sharedPreferences = preferences.get();
        String tel = sharedPreferences.getString("tel", "0000000000");
        String ticketNickname = sharedPreferences.getString("ticketNickname", "请登录");

        //获取参数
        intent = getActivity().getIntent();
        String[] movies = intent.getStringArrayExtra("movie");
        ArraySet<String> arraySet = new ArraySet<>();

        if (tel.equals("0000000000")) {
            Log.e(Consts.TAG, "未登录需要去登录");
            //对话框
            alertOrder(container, view, itme_order);
        } else {
            Log.e(Consts.TAG, "登录可以购买");
            //跳转到订单页面,带上电影参数
            ll_order.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
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
                    //发送通知
                    sendBroadcasMsg();

                    intent.putExtra("movies", movies);
                    intent.setClass(getContext(), OrderActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    return true;
                }
            });
        }

        return view;
    }

    //发送通知
    private void sendBroadcasMsg() {

        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        /**
         * 这里需要注意，8.0以上需要创建 Channel 渠道
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("测试渠道", getString(R.string.app_name),
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(getContext(),"测试渠道");
        } else {
            builder = new NotificationCompat.Builder(getContext());
        }

        String[] movies = intent.getStringArrayExtra("movie");
        String str = "尊敬的用户购买了：《" + movies[3] + "》的电影票，请在“我的订单”中查看";

        //Ticker是状态栏显示的提示
        builder.setTicker("肌哩肌哩");
        //第一行内容  通常作为通知栏标题
        builder.setContentTitle("订单通知");
        //第二行内容 通常是通知正文
        builder.setContentText(str);
        //第三行内容 通常是内容摘要什么的 在低版本机器上不一定显示
        builder.setSubText("请注意查看");
        //ContentInfo 在通知的右侧 时间的下面 用来展示一些其他信息
        builder.setContentInfo("这里显示ContentInfo");
        //number设计用来显示同种通知的数量和ContentInfo的位置一样，如果设置了ContentInfo则number会被隐藏
        builder.setNumber(2);
        //true：点击通知栏，通知消失
        builder.setAutoCancel(true);
        //通知时间
        builder.setWhen(System.currentTimeMillis());
        //系统状态栏显示的小图标
        builder.setSmallIcon(R.drawable.app_title_semil);
        //下拉显示的大图标
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_app_title));
        /**
         * 这里的Intent可以携带参数传递到跳转的Activity，后面会专门解释
         */
        Intent intent = new Intent(getContext(), OrderActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getContext(), 1, intent, 0);
        //点击跳转的intent
        builder.setContentIntent(pIntent);
        //通知默认的声音 震动 呼吸灯
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        /**
         * 第一个参数为id，如果id相同则该通知会更新；
         */
        notificationManager.notify(123, notification);
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