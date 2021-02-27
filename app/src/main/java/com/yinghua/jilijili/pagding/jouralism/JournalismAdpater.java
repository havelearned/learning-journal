package com.yinghua.jilijili.pagding.jouralism;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.WEBActivity;
import com.yinghua.jilijili.bean.Journalism;

import java.util.List;

public class JournalismAdpater extends PagedListAdapter<Journalism,JournalismAdpater.MyViewHolder> {
    public Context context;
    public JournalismAdpater(Context context) {
        super(new DiffUtil.ItemCallback<Journalism>() {
            @Override
            public boolean areItemsTheSame(@NonNull Journalism oldItem, @NonNull Journalism newItem) {
                return oldItem.getRequestId().equals(newItem.getRequestId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Journalism oldItem, @NonNull Journalism newItem) {
                return oldItem.getRequestId().equals(newItem.getRequestId());
            }
        });
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jou,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(position!=39){
            Journalism item = getItem(position);
            if (item!=null){
                List<Journalism.ResultDTOX.ResultDTO.ListDTO> list = item.getResult().getResult().getList();
                Journalism.ResultDTOX.ResultDTO.ListDTO listDTO = list.get(position);
                holder.tv_title.setText("新闻："+listDTO.getTitle());
                holder.tv_time.setText("时间："+listDTO.getTime());
                holder.tv_src.setText("来源："+listDTO.getSrc());
                holder.tv_category.setText("类别："+listDTO.getCategory());
                Glide.with(context).load(listDTO.getPic()).into(holder.iv_jImage);

                holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(context, WEBActivity.class);
                        intent.putExtra("title",listDTO.getTitle());
                        intent.putExtra("content",listDTO.getContent());
                        context.startActivity(intent);
                    }
                });

            }
        }else{
            holder.tv_title.setText("新闻：无内容");
            holder.tv_time.setText("时间：无内容");
            holder.tv_src.setText("来源：无内容");
            holder.tv_category.setText("类别：无内容");
            return;
        }

    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_time, tv_src, tv_category;
        ImageView iv_jImage;
        LinearLayout linearLayout1;
        public MyViewHolder(@NonNull View itemView) {
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
