package com.yinghua.jilijili.service;

import com.yinghua.jilijili.bean.ConfirmOrder;
import com.yinghua.jilijili.bean.Orderforgoods;
import com.yinghua.jilijili.bean.Ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 *
 * 订单
 *
 * */
public interface OrderforgoodsService {



    /**
     * 查询所有确认的订单
     */
    @POST("DDSYSystem/ordesconfirm")
    Call<List<ConfirmOrder>> requestQueryCofirmOders(@Query("thone") String thone);

    /**
     * 添加确认的订单
     */
    @POST("DDSYSystem/ordesconfirm/insert")
    Call<Boolean> requestConfirmOder(@Query("movieName") String movieName,
                                           @Query("newTime") String newTime,
                                           @Query("zuoWei") String zuoWei,
                                           @Query("startTime") String startTime,
                                           @Query("prien") int prien,
                                           @Query("thone") String thone);


    /**
     * 创建订单
     */
    @POST("DDSYSystem/createoder")
    Call<Orderforgoods> requestOder(@Query("moviename") String moviename,
                                    @Query("tnickname") String tnickname,
                                    @Query("tphone") String tphone);


    /**
     * 手机查询订单
     */
    @POST("DDSYSystem/oders")
    Call<List<Orderforgoods>> requestQueryOders(@Query("thone") String thone);


    /**
     * 删除订单
     */
    @POST("DDSYSystem/odersid")
    Call<Integer> requestDeleteOders(@Query("id") Integer id);


}
