package com.yinghua.jilijili.ui.top.recommend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.yinghua.jilijili.R;
import com.yinghua.jilijili.bean.Movie;
import com.yinghua.jilijili.pagding.moviepagding.MovieDataSourceItme;
import com.yinghua.jilijili.pagding.moviepagding.MoviePageListAdapter;
import com.yinghua.jilijili.pagding.moviepagding.MovieViewMode;
import com.yinghua.jilijili.utily.Consts;

public class Recommend_movide extends Fragment {

    MoviePageListAdapter moviePageListAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend_movide, container, false);
        recyclerView = view.findViewById(R.id.Recommend_movide_RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);

        moviePageListAdapter = new MoviePageListAdapter(getContext());


        MovieViewMode movieVIewModel = new ViewModelProvider(this).get(MovieViewMode.class);
        movieVIewModel.moviePageList.observe(getViewLifecycleOwner(), new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(PagedList<Movie> movies) {
                Log.e(Consts.TAG, "数据:" + movies.toString());
                moviePageListAdapter.submitList(movies);
            }
        });
        recyclerView.setAdapter(moviePageListAdapter);


        PullRefreshLayout pullRefreshLayout = view.findViewById(R.id.pullRefreshLayout);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "无内容", Toast.LENGTH_SHORT).show();
                pullRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }
}