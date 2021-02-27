package com.yinghua.jilijili.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Movie;
import com.yinghua.jilijili.utily.Consts;

import java.util.List;



/**
 * 推荐完成适配器
 *
 * */
public class RecommenAdapter extends RecyclerView.Adapter<RecommenAdapter.myViewHolder> {
    Context context;
    public List<Movie> movieList;

    public RecommenAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    /**
     * 创建view是给它配置对应的view
     */
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.setData(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        if (movieList != null) {
            return movieList.size();
        }
        return 0;
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button button;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.button = itemView.findViewById(R.id.button);
        }

        public void setData(Movie movie){
            textView.setText(movie.getMMovieName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(Consts.TAG,"点击了："+movie.getMSupport());
                }
            });
        }
    }
}
