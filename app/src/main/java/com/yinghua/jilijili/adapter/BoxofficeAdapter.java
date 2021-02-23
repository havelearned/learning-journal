package com.yinghua.jilijili.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.DouBan;

import java.util.ArrayList;
import java.util.List;

public class BoxofficeAdapter extends RecyclerView.Adapter<BoxofficeAdapter.MyViewHolder> {

    private List<DouBan> pdata = new ArrayList<>();
    private Context context;
    private void loadImage(String url, ImageView imageView) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageLoader imageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
                    private LruCache<String, Bitmap> mCache = new LruCache<>(10 * 1024 * 1024);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return mCache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        mCache.put(url, bitmap);
                    }
                });
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        imageLoader.get(url, imageListener);
    }

    public BoxofficeAdapter(List<DouBan> pdata, Context context) {
        this.pdata = pdata;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itme__morth_american_box_office, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DouBan douBan = pdata.get(position);
        loadImage(douBan.getSmall(), holder.iv_small);
        holder.bu_title.setText("电影名称:"+douBan.getTitle());

        String pudbates = "电影上映时间:"+douBan.getPudbates().substring(2,12);
        holder.bt_durations.setText(pudbates);


        holder.tv_average.setText("电影评分："+douBan.getAverage());
        holder.tv_directors.setText("导演:"+douBan.getDirectors());

        String durations = "电影时长:"+douBan.getDurations();
        holder.durations.setText(durations);

        holder.xiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick(douBan);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pdata.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout box_layout;
        ImageView iv_small;
        TextView bu_title,bt_durations,tv_average,tv_directors,durations;
        Button xiangqing;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            box_layout = itemView.findViewById(R.id.box_layout);
            iv_small = itemView.findViewById(R.id.iv_small);
            bu_title = itemView.findViewById(R.id.bu_title);
            bt_durations = itemView.findViewById(R.id.bt_durations);
            tv_average = itemView.findViewById(R.id.tv_average);
            tv_directors = itemView.findViewById(R.id.tv_directors);
            durations = itemView.findViewById(R.id.durations);
            xiangqing=itemView.findViewById(R.id.xiangqing);
        }
    }


    public void onclick (DouBan ban){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri parse = Uri.parse(ban.getAlt());
        intent.setData(parse);
        context.startActivity(intent);
    }
}
