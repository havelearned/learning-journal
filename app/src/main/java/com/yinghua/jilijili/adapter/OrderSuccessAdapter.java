package com.yinghua.jilijili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.ConfirmOrder;

import java.util.List;

public class OrderSuccessAdapter extends RecyclerView.Adapter<OrderSuccessAdapter.MyViewHolder> {
    Context mContext;
    List<ConfirmOrder> mConfirmOrders;

    public OrderSuccessAdapter(Context context, List<ConfirmOrder> confirmOrders) {
        mContext = context;
        mConfirmOrders = confirmOrders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_success_order, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ConfirmOrder confirmOrder = mConfirmOrders.get(position);
        if (confirmOrder!=null){
            holder.tv_successtime.setText(confirmOrder.getCStarttime());
            holder.tv_successmovie.setText(confirmOrder.getCMoviename());
            holder.tv_pricesuccess.setText(String.valueOf(confirmOrder.getCPrien()));
            holder.tv_thonesuccess.setText(confirmOrder.getCThone());
            holder.tv_zuoweihaosuccess.setText(confirmOrder.getCZuowei());

            holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    holder.ratingBar.setRating(rating);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mConfirmOrders.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_successtime,tv_thonesuccess,tv_successmovie,tv_zuoweihaosuccess,tv_pricesuccess;
        RatingBar ratingBar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_successtime=itemView.findViewById(R.id.tv_successtime);
            tv_thonesuccess=itemView.findViewById(R.id.tv_thonesuccess);
            tv_successmovie=itemView.findViewById(R.id.tv_successmovie);
            tv_zuoweihaosuccess=itemView.findViewById(R.id.tv_zuoweihaosuccess);
            tv_pricesuccess=itemView.findViewById(R.id.tv_pricesuccess);
            ratingBar=itemView.findViewById(R.id.ratingBar);
        }
    }
}
