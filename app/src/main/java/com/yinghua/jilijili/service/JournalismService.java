package com.yinghua.jilijili.service;

import com.yinghua.jilijili.bean.Journalism;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * 新闻
 *
* */
public interface JournalismService {


    @GET("get")
    Call<Journalism> requestJournalismList(@Query("channel") String channel,
                                           @Query("num") Integer num,
                                           @Query("start") Integer start,
                                           @Query("appkey") String appkey);

    @GET("get")
    Call<Journalism.ResultDTOX.ResultDTO.ListDTO> requestJournalismList2(@Query("channel") String channel,
                                                                         @Query("num") Integer num,
                                                                         @Query("start") Integer start,
                                                                         @Query("appkey") String appkey);
}
