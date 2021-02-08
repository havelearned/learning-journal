package com.yinghua.viewpager.bean;

public class Movie {
    private String mId;//电影id
    private String mDirector;//电影名称
    private String mMovieName;//导演
    private String mProtagonist;//主演
    private String mSupport;//配角
    private String mScreen; //日期

    @Override
    public String toString() {
        return "Movie{" +
                "mId='" + mId + '\'' +
                ", mDirector='" + mDirector + '\'' +
                ", mMovieName='" + mMovieName + '\'' +
                ", mProtagonist='" + mProtagonist + '\'' +
                ", mSupport='" + mSupport + '\'' +
                ", mScreen='" + mScreen + '\'' +
                '}';
    }

    public Movie() {
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmDirector() {
        return mDirector;
    }

    public void setmDirector(String mDirector) {
        this.mDirector = mDirector;
    }

    public String getmMovieName() {
        return mMovieName;
    }

    public void setmMovieName(String mMovieName) {
        this.mMovieName = mMovieName;
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

    public String getmScreen() {
        return mScreen;
    }

    public void setmScreen(String mScreen) {
        this.mScreen = mScreen;
    }
}
