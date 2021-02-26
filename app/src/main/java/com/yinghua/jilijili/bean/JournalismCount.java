package com.yinghua.jilijili.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JournalismCount {
    private String title;
    private String time;
    private String src;
    private String category;
    private String pic;
    private String content;
    private String url;
    private String weburl;

    public JournalismCount() {
    }

    public JournalismCount(String title, String time, String src, String category, String pic, String content, String url, String weburl) {
        this.title = title;
        this.time = time;
        this.src = src;
        this.category = category;
        this.pic = pic;
        this.content = content;
        this.url = url;
        this.weburl = weburl;
    }

    @Override
    public String toString() {
        return "JournalismCount{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", src='" + src + '\'' +
                ", category='" + category + '\'' +
                ", pic='" + pic + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", weburl='" + weburl + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }
}
