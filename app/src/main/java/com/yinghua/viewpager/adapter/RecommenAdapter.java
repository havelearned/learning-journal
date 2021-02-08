package com.yinghua.viewpager.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yinghua.viewpager.MainActivity;
import com.yinghua.viewpager.R;
import com.yinghua.viewpager.bean.Movie;
import com.yinghua.viewpager.utily.Consts;

import java.util.List;

import static com.yinghua.viewpager.R.color.black;

public class RecommenAdapter extends RecyclerView.Adapter<RecommenAdapter.myViewHolder> {
    private List<Movie> movieList;

    public RecommenAdapter(List<Movie> movies) {
        this.movieList = movies;
    }


    /**
     * 创建view是给它配置对应的view
     */
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test, parent, false);
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
                    Log.e(Consts.TAG,"点击了："+movie.getMMovieName());
                }
            });
        }
    }
}
