package com.yinghua.jilijili.bean;


/**
 * 豆瓣api bean
 * */
public class DouBan {
    private String id; //id
    private String title; //电影名称
    private String small; //图片
    private String average; //评分
    private String pudbates; //上映时间
    private String durations; //时长
    private String alt;//豆瓣详情页
    private String directors;//导演

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getPudbates() {
        return pudbates;
    }

    public void setPudbates(String pudbates) {
        this.pudbates = pudbates;
    }

    public String getDurations() {
        return durations;
    }

    public void setDurations(String durations) {
        this.durations = durations;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public DouBan(String id, String title, String small, String average, String pudbates, String durations, String alt, String directors) {
        this.id = id;
        this.title = title;
        this.small = small;
        this.average = average;
        this.pudbates = pudbates;
        this.durations = durations;
        this.alt = alt;
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "DouBan{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", small='" + small + '\'' +
                ", average='" + average + '\'' +
                ", pudbates='" + pudbates + '\'' +
                ", durations='" + durations + '\'' +
                ", alt='" + alt + '\'' +
                ", directors='" + directors + '\'' +
                '}';
    }
}
