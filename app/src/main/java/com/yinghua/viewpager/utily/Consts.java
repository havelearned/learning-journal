package com.yinghua.viewpager.utily;

/**
 * 全局常量名
 */
public class Consts {
    public static final int GET = 1;
    public static final int POST = 2;
    public static final int PUT = 3;
    public static final int UPDATE = 4;

    public static final int cinemaId = 0;
    public static final int movieId = 0;

    //访问服务器获取数据
    public static final String DDSP_URL = "http://121.196.106.152:9999/DDSYSystem/";
    public static final String DDSP_URL_MOVIE = "http://121.196.106.152:9999/DDSYSystem/modelmmovie";//获取影片
    public static final String DDSP_URL_CINEMA = "http://121.196.106.152:9999/DDSYSystem/modelcinema";//获取电影院
    public static final String DDSP_URL_ORDERFORGOODS = "http://121.196.106.152:9999/DDSYSystem/modelorderforgoodsService";//获取订单
    public static final String DDSP_URL_TICKET = "http://121.196.106.152:9999/DDSYSystem/modelticket";//获取购票者信息


    //获取单个影片信息
    public static final String DDSP_URL_GETMOVIE = "http://121.196.106.152:9999/DDSYSystem/modelmovie/param";

    //获取单个电影院信息
    public static final String DDSP_URL_GETCINEMA = "http://121.196.106.152:9999/DDSYSystem/modelcinema/param";

}
