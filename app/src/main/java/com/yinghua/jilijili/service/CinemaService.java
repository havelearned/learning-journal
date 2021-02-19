package com.yinghua.jilijili.service;

import com.yinghua.jilijili.bean.Cinema;
import com.yinghua.jilijili.utily.Consts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CinemaService {
    @GET("/DDSYSystem/modelcinema")
    Call<List<Cinema>> getAllCinema();
}
