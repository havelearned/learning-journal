package com.yinghua.jilijili.pagding.moviepagding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Movie;

import java.text.SimpleDateFormat;

public class MoviePageListAdapter extends PagedListAdapter<Movie, MoviePageListAdapter.MovieViewHolder> {

    private final Context context;

    public MoviePageListAdapter(Context context) {
        super(DIFF_CALLBack);
        this.context = context;
    }

    /**
     * 这个常量用于计算两个数之间的差异，使用notifyDataSetChanged方法对整个数据源进行刷新，并不高效，
     * 而如果使用Diffutil,它只需要更新数据源，并不需要刷新整个数据源
     */
    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBack = new DiffUtil.ItemCallback<Movie>() {

        //当想要检测两个对象是否嗲表同一个item是，调用这个方法进行判断
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getMId() == newItem.getMId();
        }


        //当Diffuitl想要检测两个item是否存在不一样的数据时，调用该方法进行判断
        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getMId() == newItem.getMId();
        }
    };

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_page, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = getItem(position);
        if (movie != null) {
/*

            Date date = new Date(movie.getMScreen());
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
*/
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm");
            String format = "上映日期" + simpleDateFormat.format(movie.getMScreen());
            String movieNameo = "《" + movie.getMMovieName() + "》";
            String movieU = "导演：" + movie.getMDirector() + "   ·   主演：" + movie.getMProtagonist();

            Glide.with(context).load(movie.getPhoto().getP_photo()).into(holder.imageView);
            holder.textView.setText(movieU);
            holder.textView2.setText(movieNameo);
            holder.button.setText(format);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] strarr = {movie.getMScreen() + "",
                            movie.getMProtagonist(),
                            movie.getMDirector(),
                            movie.getMMovieName(),
                            movie.getMSupport(),
                            movie.getPhoto().getP_photo(),
                            movie.getmDesc()};
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("movie",strarr);
                    NavController navController=Navigation.findNavController(v);
                    navController.navigate(R.id.testActivity,bundle);
                }
            });
        } else {
            holder.textView.setText("");
            holder.button.setText("");
            holder.textView2.setText("");
        }
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, textView2;
        Button button;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textViewDD);
            button = itemView.findViewById(R.id.button);


        }
    }
}
