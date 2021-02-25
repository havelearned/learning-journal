package com.yinghua.jilijili.utily;
import java.util.Random;
import java.util.Set;

/**
 * 全局常量名
 */
public class Consts {
    public static boolean FIRST_USE = false;// false第一次进入app, true 直接来到首页
    public static boolean LOGIN_FLAG = false;// false :没有登录过 ，true 登录过
    public static String LOGIN_DATE = "null";//上次登录时间
    public static String USER_INFO = "null";//用户信息
    public static Set MOVIES_SET_ARRAY;//保存的电影信息
    public static Set TICKET_SET_ARRAY;//保存的购票者信息
    public static Set ORDER_SET_ARRAY;//保存的影片信息
    public static final String TAG = "MyApp";
    public static final int GET = 1;
    public static final int POST = 2;
    public static final int PUT = 3;
    public static final int UPDATE = 4;

    public static final int cinemaId = 0;
    public static final int movieId = 0;



    public static final String REQUEST_STEMAIL="https://api.muxiaoguo.cn/api/";

    public static final String localhost = "http://192.168.1.4:9999/";

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

    //客户端注册：
    public static final String DDSPURL_REG="api/userReg";


    //访问本地

    public static final String DDSP_LOCAURL_IP = "http://localhost:9999";
    public static final String DDSP_LOCAURL_M = "DDSYSystem/modelmovie/param";

    //服务器图片地址
    public static String getImagestr() {
        Random random = new Random(12);
        int Inte = 1;
        String[] ImageStr = new String[999];
        for (int i = 1; i <= 12; i++) {
            ImageStr[i] = "http://jilijili.fun/image/" + i + ".jpg";
            Inte = random.nextInt(12);
            System.out.println(ImageStr[i]);
        }

        return ImageStr[Inte];
    }


}
