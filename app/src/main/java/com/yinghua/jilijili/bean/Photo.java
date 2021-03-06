package com.yinghua.jilijili.bean;


import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * 图片 bean 对象
 * */
public class Photo   {
    private Integer p_id;
    private String p_name;
    private String p_photo;

    protected Photo(Parcel in) {
        if (in.readByte() == 0) {
            p_id = null;
        } else {
            p_id = in.readInt();
        }
        p_name = in.readString();
        p_photo = in.readString();
    }

    public Photo() {
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_photo() {
        return p_photo;
    }

    public void setP_photo(String p_photo) {
        this.p_photo = p_photo;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_photo='" + p_photo + '\'' +
                '}';
    }


}
