package com.yinghua.jilijili.service;


import com.yinghua.jilijili.bean.Movie;
import com.yinghua.jilijili.utily.Consts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 *
 * 电影
 *
 * */
public interface MovieService {


    @GET(Consts.DDSP_URL_MOVIE_SEEK)
    Call<List<Movie>> getSeekMovies(@Query("str")String str);

    @GET(Consts.DDSP_URL_MOVIE2)
    Call<List<Movie>> getAllMovies(@Query("start") int start,
                              @Query("count") int count);
}
