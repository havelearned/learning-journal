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

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Journalism;
import com.yinghua.jilijili.bean.Movie;

import java.util.List;
import java.util.Random;

public class StrrnaKingAdapter extends RecyclerView.Adapter<StrrnaKingAdapter.myViewHolder> {
    Context context;
    List<Journalism.ResultDTOX.ResultDTO.ListDTO> list;
    public StrrnaKingAdapter(Context context, List<Journalism.ResultDTOX.ResultDTO.ListDTO> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 创建view是给它配置对应的view
     */
    @Override
    public StrrnaKingAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //LayoutInflater.from(parent.getContext()).inflate(R.layout.item_journalism, parent, false)}
        return new StrrnaKingAdapter.myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jou, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull StrrnaKingAdapter.myViewHolder holder, int position) {
        Journalism.ResultDTOX.ResultDTO.ListDTO listDTO = list.get(position);
        if (listDTO!=null){
            holder.tv_title.setText("新闻："+listDTO.getTitle());
            holder.tv_time.setText("时间"+listDTO.getTime());
            holder.tv_src.setText("来源："+listDTO.getSrc());
            holder.tv_category.setText("类别"+listDTO.getCategory());
            Glide.with(context).load(listDTO.getPic()).into(holder.iv_jImage);
        }
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_time, tv_src, tv_category;
        ImageView iv_jImage;
        LinearLayout linearLayout1;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_time= itemView.findViewById(R.id.tv_time);
            tv_src= itemView.findViewById(R.id.tv_src);
            tv_category=itemView.findViewById(R.id.tv_category);
            iv_jImage= itemView.findViewById(R.id.iv_jImage);
            linearLayout1= itemView.findViewById(R.id.linearLayout1);

        }

    }
}
