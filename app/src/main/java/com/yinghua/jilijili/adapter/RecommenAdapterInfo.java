/*
package com.yinghua.jilijili.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yinghua.jilijili.R;

public class RecommenAdapterInfo    extends RecyclerView.Adapter<RecommenAdapterInfo.InfoViewHolder>  {
    private Context context;

    public RecommenAdapterInfo(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InfoViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_movie_info_info,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        holder.textView1.setText("11");
        holder.textView2.setText("11");
        holder.textView3.setText("11");
        holder.textView4.setText("11");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1,textView2,textView3,textView4;


        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView.findViewById(R.id.image_Movie_info_info);

            textView1.findViewById(R.id.text1_Movie_info_info);
            textView2.findViewById(R.id.text2_Movie_info_info);

            textView3.findViewById(R.id.text3_Movie_info_in);
            textView4.findViewById(R.id.brief);
        }
    }
}
*/
