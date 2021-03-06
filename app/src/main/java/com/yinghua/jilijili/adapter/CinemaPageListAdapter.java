package com.yinghua.jilijili.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.LocalhostActivity;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Cinema;

import java.util.List;


/**
 * 电影院适配器
 * */
public class CinemaPageListAdapter extends RecyclerView.Adapter<CinemaPageListAdapter.CinemaViewHolder> {
    List<Cinema> cinemaList;
    private Context context;

    public CinemaPageListAdapter(List<Cinema> cinemaList, Context context) {
        this.cinemaList = cinemaList;
        this.context = context;
    }

    @NonNull
    @Override
    public CinemaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cinema, parent, false);

        return new CinemaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaViewHolder holder, int position) {

        Cinema cinema = cinemaList.get(position);
        holder.tv_Name.setText(cinema.getCCname());
        Glide.with(context).load(cinema.getC_Image()).into(holder.cinema_image);
        holder.cinema_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LocalhostActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cinemaList.size();
    }

    public class CinemaViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout cinema_layout;
        ImageView cinema_image;
        TextView tv_Name, tv_MovieName, tv_sum;

        public CinemaViewHolder(@NonNull View itemView) {
            super(itemView);

            cinema_image = itemView.findViewById(R.id.cinema_image);
            tv_Name = itemView.findViewById(R.id.tv_Name);
            tv_MovieName = itemView.findViewById(R.id.tv_MovieName);
            tv_sum = itemView.findViewById(R.id.tv_sum);
            cinema_layout=itemView.findViewById(R.id.cinema_layout);
            
        }
    }
}
