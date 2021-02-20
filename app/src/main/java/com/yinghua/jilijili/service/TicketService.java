package com.yinghua.jilijili.service;

import com.yinghua.jilijili.bean.Ticket;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TicketService {


    @POST("DDSYSystem/api/userinfo")
    Call<Ticket> requestLogin(@Query("user") String user,
                            @Query("paw") String paw);


    @POST("DDSYSystem/api/userinfo")
    Call<Integer> requesEmailtLogin(@Query("user") String user,
                              @Query("paw") String paw);
//
//    ?tCard=1&tPhone=234234&tGender=男&tNickname=23123
    @POST("DDSYSystem/api/userReg")
    Call<Integer> requestReg(@Query("tCard") String tCard,
                             @Query("tPhone") String tPhone,
                             @Query("tGender") String tGender,
                             @Query("tNickname") String tNickname
    );
}
