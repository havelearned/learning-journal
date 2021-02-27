package com.yinghua.jilijili.bean; /**
 * Copyright 2021 json.cn
 */
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Auto-generated: 2021-02-13 22:18:7
 *  电影对象
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Movie {

    @SerializedName("mId")
    private int mId;

    @SerializedName("mMovieName")
    private String mMovieName;

    @SerializedName("mDirector")
    private String mDirector;

    @SerializedName("mProtagonist")
    private String mProtagonist;

    @SerializedName("mSupport")
    private String mSupport;

    @SerializedName("mScreen")
    private Date mScreen;

    @SerializedName("photo")
    private Photo photo;

    @SerializedName("mDesc")
    private String mDesc;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmMovieName() {
        return mMovieName;
    }

    public void setmMovieName(String mMovieName) {
        this.mMovieName = mMovieName;
    }

    public String getmDirector() {
        return mDirector;
    }

    public void setmDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    public String getmProtagonist() {
        return mProtagonist;
    }

    public void setmProtagonist(String mProtagonist) {
        this.mProtagonist = mProtagonist;
    }

    public String getmSupport() {
        return mSupport;
    }

    public void setmSupport(String mSupport) {
        this.mSupport = mSupport;
    }

    public Date getmScreen() {
        return mScreen;
    }

    public void setmScreen(Date mScreen) {
        this.mScreen = mScreen;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public void setMId(int mId) {
        this.mId = mId;
    }
    public int getMId() {
        return mId;
    }

    public void setMMovieName(String mMovieName) {
        this.mMovieName = mMovieName;
    }
    public String getMMovieName() {
        return mMovieName;
    }

    public void setMDirector(String mDirector) {
        this.mDirector = mDirector;
    }
    public String getMDirector() {
        return mDirector;
    }

    public void setMProtagonist(String mProtagonist) {
        this.mProtagonist = mProtagonist;
    }
    public String getMProtagonist() {
        return mProtagonist;
    }

    public void setMSupport(String mSupport) {
        this.mSupport = mSupport;
    }
    public String getMSupport() {
        return mSupport;
    }

    public void setMScreen(Date mScreen) {
        this.mScreen = mScreen;
    }
    public Date getMScreen() {
        return mScreen;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
    public Photo getPhoto() {
        return photo;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "mId=" + mId +
                ", mMovieName='" + mMovieName + '\'' +
                ", mDirector='" + mDirector + '\'' +
                ", mProtagonist='" + mProtagonist + '\'' +
                ", mSupport='" + mSupport + '\'' +
                ", mScreen=" + mScreen +
                ", photo=" + photo +
                ", mDesc='" + mDesc + '\'' +
                '}';
    }
}