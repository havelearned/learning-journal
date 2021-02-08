package com.yinghua.viewpager.bean;

import com.google.gson.annotations.SerializedName;

public class Movie {
    private String mDirector;

    private int mId;

    private String mMovieName;

    private String mProtagonist;

    private long mScreen;

    private String mSupport;

    public void setMDirector(String mDirector) {
        this.mDirector = mDirector;
    }
    public String getMDirector() {
        return mDirector;
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

    public void setMProtagonist(String mProtagonist) {
        this.mProtagonist = mProtagonist;
    }
    public String getMProtagonist() {
        return mProtagonist;
    }

    public void setMScreen(long mScreen) {
        this.mScreen = mScreen;
    }
    public long getMScreen() {
        return mScreen;
    }

    public void setMSupport(String mSupport) {
        this.mSupport = mSupport;
    }
    public String getMSupport() {
        return mSupport;
    }
}
