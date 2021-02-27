package com.yinghua.jilijili.service;

import com.yinghua.jilijili.bean.Cinema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * 电影院
 *
 * */
public interface CinemaService {
    @GET("/DDSYSystem/modelcinema")
    Call<List<Cinema>> getAllCinema();
}
