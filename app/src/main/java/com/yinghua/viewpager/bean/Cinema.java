package com.yinghua.viewpager.bean;

/**
 * @author Luojiaju
 * @description: 电影院实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
public class Cinema {
    private String cId;

    private String cCname;

    private String cSeatnumber;

    private String cGalleryful;

    public Cinema() {
    }

    public Cinema(String cId, String cCname, String cSeatnumber, String cGalleryful) {
        this.cId = cId;
        this.cCname = cCname;
        this.cSeatnumber = cSeatnumber;
        this.cGalleryful = cGalleryful;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcCname() {
        return cCname;
    }

    public void setcCname(String cCname) {
        this.cCname = cCname;
    }

    public String getcSeatnumber() {
        return cSeatnumber;
    }

    public void setcSeatnumber(String cSeatnumber) {
        this.cSeatnumber = cSeatnumber;
    }

    public String getcGalleryful() {
        return cGalleryful;
    }

    public void setcGalleryful(String cGalleryful) {
        this.cGalleryful = cGalleryful;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cId='" + cId + '\'' +
                ", cCname='" + cCname + '\'' +
                ", cSeatnumber='" + cSeatnumber + '\'' +
                ", cGalleryful='" + cGalleryful + '\'' +
                '}';
    }
}