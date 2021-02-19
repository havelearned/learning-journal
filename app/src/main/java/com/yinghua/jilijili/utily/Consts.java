package com.yinghua.jilijili.utily;

import java.util.Random;

/**
 * 全局常量名
 */
public class Consts {

    public static final String TAG = "MyApp";

    public static final int GET = 1;
    public static final int POST = 2;
    public static final int PUT = 3;
    public static final int UPDATE = 4;

    public static final int cinemaId = 0;
    public static final int movieId = 0;

    //访问服务器获取数据
    public static final String DDSP_URL = "http://121.196.106.152:9999/";

    public static final String DDSP_URL_MOVIE2 = "DDSYSystem/modelmovie/param";//获取影片

    public static final String DDSP_URL_MOVIE = "http://121.196.106.152:9999/DDSYSystem/modelmmovie";//获取影片
    public static final String DDSP_URL_CINEMA = "http://121.196.106.152:9999/DDSYSystem/modelcinema";//获取电影院
    public static final String DDSP_URL_ORDERFORGOODS = "http://121.196.106.152:9999/DDSYSystem/modelorderforgoodsService";//获取订单
    public static final String DDSP_URL_TICKET = "http://121.196.106.152:9999/DDSYSystem/modelticket";//获取购票者信息


    //获取单个影片信息
    public static final String DDSP_URL_GETMOVIE = "http://121.196.106.152:9999/DDSYSystem/modelmovie/param";

    //获取单个电影院信息
    public static final String DDSP_URL_GETCINEMA = "DDSYSystem/modelcinema/param";


    //访问本地

    public static final String DDSP_LOCAURL_IP = "http://localhost:9999";
    public static final String DDSP_LOCAURL_M = "DDSYSystem/modelmovie/param";

    //服务器图片地址
    public static String getImagestr() {
        Random random = new Random(12);
        int Inte=1;
        String[] ImageStr = new String[999];
        for (int i = 1; i <= 12; i++) {
            ImageStr[i] = "http://jilijili.fun/image/" + i + ".jpg";
             Inte= random.nextInt(12);
            System.out.println(ImageStr[i]);
        }

        return ImageStr[Inte];
    }


}
