package com.yinghua.jilijili.service;

import com.yinghua.jilijili.bean.Ticket;
import com.yinghua.jilijili.utily.Consts;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRetrofitClient {
    private static MoviesRetrofitClient moviesRetrofitClient;
    private static Retrofit retrofit;



    public MoviesRetrofitClient() {
        retrofit=new Retrofit.Builder()
                .baseUrl(Consts.DDSP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized MoviesRetrofitClient getInstance(){
        if(moviesRetrofitClient==null){
            moviesRetrofitClient=new MoviesRetrofitClient();
        }

        return moviesRetrofitClient;
    }


    public TicketService ticketService(){
        return retrofit.create(TicketService.class);
    }

    public MovieService movieService(){
        return retrofit.create(MovieService.class);
    }

    public CinemaService cinemaService(){
        return retrofit.create(CinemaService.class);
    }
}
