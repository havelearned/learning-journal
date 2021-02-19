package com.yinghua.jilijili.bean;

/**
 * @author Luojiaju
 * @description: 电影院实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
public class Cinema {
    private int cId;
    private String cCname;
    private String cSeatnumber;
    private String c_Image;
    private int cGalleryful;
    public void setCId(int cId) {
        this.cId = cId;
    }
    public int getCId() {
        return cId;
    }

    public void setCCname(String cCname) {
        this.cCname = cCname;
    }
    public String getCCname() {
        return cCname;
    }

    public void setCSeatnumber(String cSeatnumber) {
        this.cSeatnumber = cSeatnumber;
    }
    public String getCSeatnumber() {
        return cSeatnumber;
    }

    public void setC_Image(String c_Image) {
        this.c_Image = c_Image;
    }
    public String getC_Image() {
        return c_Image;
    }

    public void setCGalleryful(int cGalleryful) {
        this.cGalleryful = cGalleryful;
    }
    public int getCGalleryful() {
        return cGalleryful;
    }

}