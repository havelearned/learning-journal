package com.yinghua.jilijili.pagding.moviepagding;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.yinghua.jilijili.bean.Movie;

public class MovieDataSourceFactory extends DataSource.Factory<Integer, Movie> {
    private MutableLiveData<MovieDataSource> liveDataSource = new MutableLiveData<>();//初始化

    @NonNull
    @Override
    public DataSource<Integer, Movie> create() {
        MovieDataSource dataSource = new MovieDataSource();
        liveDataSource.postValue(dataSource);
        return dataSource;
    }

}
