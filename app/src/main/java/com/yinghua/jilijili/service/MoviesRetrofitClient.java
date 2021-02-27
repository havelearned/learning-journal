package com.yinghua.jilijili.service;

import com.yinghua.jilijili.utily.Consts;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 链式调用 retrofit2
 * */
public class MoviesRetrofitClient {
    private static MoviesRetrofitClient moviesRetrofitClient;
    private static Retrofit retrofit;


    public MoviesRetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Consts.DDSP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public MoviesRetrofitClient(String emailIP) {
        retrofit = new Retrofit.Builder()
                .baseUrl(emailIP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized MoviesRetrofitClient getInstance() {
            moviesRetrofitClient = new MoviesRetrofitClient();
        return moviesRetrofitClient;
    }

    public static synchronized MoviesRetrofitClient getInstance(String emailIP) {
        moviesRetrofitClient = new MoviesRetrofitClient(emailIP);
        return moviesRetrofitClient;
    }


    public JournalismService mJournalismService(){
        return retrofit.create(JournalismService.class);
    }

    public OrderforgoodsService orderforgoodsService() {
        return retrofit.create(OrderforgoodsService.class);
    }

    public TicketService ticketService() {
        return retrofit.create(TicketService.class);
    }

    public MovieService movieService() {
        return retrofit.create(MovieService.class);
    }

    public CinemaService cinemaService() {
        return retrofit.create(CinemaService.class);
    }
}
