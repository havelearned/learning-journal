package com.yinghua.jilijili.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.baoyz.widget.PullRefreshLayout;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Movie;

import java.util.List;

public class SeekMovie extends Fragment {
    PullRefreshLayout seek_pullRefreshLayout;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seekmovie, container, false);
        seek_pullRefreshLayout = view.findViewById(R.id.seek_pullRefreshLayout);
        recyclerView = view.findViewById(R.id.seekm_recyclerView);

       /**
        * MoviesRetrofitClient
        *                         .getInstance()
        *                         .movieService()
        *                         .getSeekMovies(content)
        *                         .enqueue(new Callback<List<Movie>>() {
        *                             @Override
        *                             public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        *                                 if (response.code() == 200) {
        *                                     List<Movie> body = response.body();
        *                                     if (body.size() > 0) {
        *                                         Bundle bundle = new Bundle();
        *                                         bundle.putSerializable("movies",(Serializable)body);
        *                                         setArguments(bundle);
        *                                         NavController navController= Navigation.findNavController(v);
        *                                         navController.navigate(R.id.action_seekFragment_to_seekMovie,bundle);
        *
        *                                         Log.e(Consts.TAG, "" + body.get(0));
        *                                     } else {
        *                                         Toast.makeText(getContext(), "没有搜索结果", Toast.LENGTH_SHORT).show();
        *                                     }
        *
        *                                     Log.e(Consts.TAG, "com.yinghua.jilijili.ui.SeekFragment_请求成功：" + response.raw() + "\n");
        *                                 } else {
        *                                     Log.e(Consts.TAG, "com.yinghua.jilijili.ui.SeekFragment_请求失败：" + response.raw());
        *                                 }
        *                             }
        *
        *                             @Override
        *                             public void onFailure(Call<List<Movie>> call, Throwable t) {
        *                                 Log.e(Consts.TAG, "com.yinghua.jilijili.ui.SeekFragment_请求失败：" + t.getMessage());
        *                             }
        *                         });
        * */

        return view;
    }
}
