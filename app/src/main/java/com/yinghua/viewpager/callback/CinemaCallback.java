package com.yinghua.viewpager.callback;

import com.yinghua.viewpager.bean.Cinema;

import java.util.List;

/**
 * 网络访问类类的回调接口
 * */
public interface CinemaCallback {
    /**
     * 但凡调用这个类，就必须执行的方法
     *
     * @param string
     */
    List<Cinema> onSuccess(List<Cinema> string);
}
