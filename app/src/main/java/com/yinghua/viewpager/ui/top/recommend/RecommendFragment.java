package com.yinghua.viewpager.ui.top.recommend;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yinghua.viewpager.MainActivity;
import com.yinghua.viewpager.R;
import com.yinghua.viewpager.adapter.RecommenAdapter;
import com.yinghua.viewpager.bean.Movie;
import com.yinghua.viewpager.service.MovieService;
import com.yinghua.viewpager.utily.Consts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.recyclerview.widget.LinearLayoutManager.*;


public class RecommendFragment extends Fragment  {

    Context context;
    RecyclerView recyclerView;
    private RecommendViewModel mViewModel;


    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context =getContext();

        //获取layout
        View root = inflater.inflate(R.layout.fragment_top_recommend, container, false);

        recyclerView = root.findViewById(R.id.recommend_recyclerView);
        Retrofit.Builder build = new Retrofit.Builder()
                .baseUrl(Consts.DDSP_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit r = build.build();
        MovieService movieService = r.create(MovieService.class);
        Call<List<Movie>> allMovies = movieService.getAllMovies();

//        layoutManager.setLayoutManager();

        allMovies.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                Toast.makeText(context, "成功了", Toast.LENGTH_SHORT).show();
                List<Movie> body = response.body();




                //LinearLayoutManager(this)里面的参数，第二个参数表示水平布局，第三个参数表示是否反转，效果呈现
                recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

                //设置水平分割线
                recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
                //recyclerVie需要设置样式的,就是和控件一样需要设置宽高之类的
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(new RecommenAdapter(body));

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(context, "失败了", Toast.LENGTH_SHORT).show();
            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        // TODO: Use the ViewModel

    }



}