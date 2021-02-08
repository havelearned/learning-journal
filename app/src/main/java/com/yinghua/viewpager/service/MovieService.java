package com.yinghua.viewpager.service;


import com.yinghua.viewpager.bean.Movie;
import com.yinghua.viewpager.utily.Consts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET(Consts.DDSP_URL_MOVIE2)
    Call<List<Movie>> getAllMovies();
}
