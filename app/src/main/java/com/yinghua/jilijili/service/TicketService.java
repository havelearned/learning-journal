package com.yinghua.jilijili.service;

import com.yinghua.jilijili.bean.Ticket;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TicketService {


    @POST("DDSYSystem/api/userinfo")
    Call<Ticket> requestLogin(@Query("user") String user,
                            @Query("paw") String paw);
}
