package com.yinghua.jilijili.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.app.JiliJiliSharedPreferences;
import com.yinghua.jilijili.bean.Orderforgoods;
import com.yinghua.jilijili.service.MoviesRetrofitClient;
import com.yinghua.jilijili.utily.Consts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 订单未完成适配器
 *
 * */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    View thisView;
    Context mContext;
    List<Orderforgoods> mOrderforgoods;

    public OrderAdapter(Context context, List<Orderforgoods> orderforgoods) {
        mContext = context;
        mOrderforgoods = orderforgoods;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.itme_order_recycleview, parent, false);

        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Orderforgoods orderforgoods = mOrderforgoods.get(position);
        if (orderforgoods != null) {
            JiliJiliSharedPreferences jiliJiliSharedPreferences = new JiliJiliSharedPreferences(mContext.getApplicationContext());
            SharedPreferences sharedPreferences = jiliJiliSharedPreferences.get();
            Set<String> stringSet = sharedPreferences.getStringSet(orderforgoods.getoMmovieName(), new ArraySet<>());
            if (!stringSet.isEmpty()) {
                List<String> list = new ArrayList<>(stringSet);
                if (list.get(0).contains("http")) {
                    Glide.with(mContext).load(list.get(0)).into(holder.iv_image);
                } else {
                    Glide.with(mContext).load(list.get(1)).into(holder.iv_image);
                }
            } else {
                System.out.println("set集合为空");
            }
        }

        String v = "下单时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        String movie = "电影：" + orderforgoods.getoMmovieName();
        String start = "时间：" + orderforgoods.getoBookingdate();
        String zuiwei = "座位号：" + orderforgoods.getoCseatnumber();
        holder.vt_time.setText(v);
        Glide.with(mContext).load("https://api.pwmqr.com/qrcode/create/?url=jilijili.fun").into(holder.erweima);
        holder.vt_movie.setText(movie); //电影名称
        holder.tv_start_time.setText(start);//开始时间
        holder.vt_zuoweihao.setText(zuiwei);//座位号
        holder.bt_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                        .setTitle("完成订单")
                        .setMessage("确定之后，这个订单将移入已完成的订单!")
                        .create();
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //添加到已完成的订单中
                        InsertCofirmOrder(orderforgoods, v);
                        deleteConfirmOrder(orderforgoods);
                        dialog.dismiss();//关闭对话框
                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                    }
                });
                alertDialog.show();

            }
        });

        //取消
        holder.bt_undone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(mContext).inflate(R.layout.itme_clrer, null);
                AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                        .setTitle("取消订单")
                        .setView(inflate)
                        .create();

                ImageView imageView = inflate.findViewById(R.id.imageView4);

                inflate.findViewById(R.id.itme_clrer).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();//关闭对话框
                    }
                });
                inflate.findViewById(R.id.itme_comfirm).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteConfirmOrder(orderforgoods);
                        if (thisView != null) {
                            ViewGroup parent = (ViewGroup) thisView.getParent();
                            parent.removeAllViews();
                            Toast.makeText(mContext, "退款成功，请下拉刷新", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(mContext, "请联系管理员", Toast.LENGTH_SHORT).show();
                        }

                        alertDialog.dismiss();//关闭对话框
                    }
                });
                Glide.with(mContext).load("http://jilijili.fun/indexImage/cler.gif").into(imageView);
                alertDialog.show();
            }
        });

        holder.erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.ereWeiCodeFragment);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mOrderforgoods.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        ImageView iv_image, erweima;
        TextView vt_time, vt_movie, vt_zuoweihao, tv_start_time, tv_sum, bt_undone;
        Button bt_confirm;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            erweima = itemView.findViewById(R.id.erweima);
            vt_time = itemView.findViewById(R.id.vt_time);
            vt_movie = itemView.findViewById(R.id.vt_movie);
            vt_zuoweihao = itemView.findViewById(R.id.vt_zuoweihao);
            tv_start_time = itemView.findViewById(R.id.tv_start_time);
            tv_sum = itemView.findViewById(R.id.tv_sum);
            bt_undone = itemView.findViewById(R.id.bt_undone);
            bt_confirm = itemView.findViewById(R.id.bt_confirm);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            thisView = itemView;
        }
    }


    private void deleteConfirmOrder(Orderforgoods orderforgoods) {
        MoviesRetrofitClient.getInstance()
                .orderforgoodsService()
                .requestDeleteOders(orderforgoods.getoId())
                .enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        Log.e(Consts.TAG, "OrderAdapter:删除订单请求：" + response.raw() + "");
                        if (response.code() == 200) {
                            if (response.body() > 0) {
                                Log.e(Consts.TAG, "OrderAdapter:删除订单id：" + orderforgoods.getoId() + "  成功");
                            } else {
                                Log.e(Consts.TAG, "OrderAdapter:删除订单id：" + orderforgoods.getoId() + "  失败");
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.e(Consts.TAG, "OrderAdapter:删除订单请求失败：" + t.getMessage());
                    }
                });
    }

    private void InsertCofirmOrder(Orderforgoods orderforgoods, View v) {
        MoviesRetrofitClient.getInstance()
                .orderforgoodsService()
                .requestConfirmOder(orderforgoods.getoMmovieName(),
                        orderforgoods.getoBookingdate(),
                        orderforgoods.getoCseatnumber(),
                        orderforgoods.getoBookingdate(),
                        99,
                        orderforgoods.getoTphone())
                .enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.code() == 200) {
                            Log.e(Consts.TAG, "OrderAdapter.onResponse:请求成功：" + response.raw());
                            ViewGroup parent = (ViewGroup) v.getParent();
                            parent.removeAllViews();
                            Toast.makeText(mContext, "订单已完成", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(Consts.TAG, "OrderAdapter.onResponse:请求失败：" + response.raw());
                            Toast.makeText(mContext, "系统错误请联系管理员", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.e(Consts.TAG, "OrderAdapter.onResponse:请求失败：" + t.getMessage());
                        Toast.makeText(mContext, "系统错误请联系管理员", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
