package com.yinghua.jilijili.pagding.moviepagding;

import com.google.gson.annotations.SerializedName;
import com.yinghua.jilijili.bean.Movie;

import java.util.List;

public  class Movies {

    //开始
    public int start;

    //    一页多少
    public int count;

    //    总共记录数
    public int total;


    @SerializedName("subject")
    public List<Movie> movieList;
}
