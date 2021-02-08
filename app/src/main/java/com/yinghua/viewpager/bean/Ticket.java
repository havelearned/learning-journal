package com.yinghua.viewpager.bean;

/**
 * @author Luojiaju
 * @description: 购票者实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
public class Ticket {
    private String tId;

    private String tCard;

    private String tPhone;

    private String tGender;

    private String tNickname;

    public Ticket() {
    }

    public Ticket(String tId, String tCard, String tPhone, String tGender, String tNickname) {
        this.tId = tId;
        this.tCard = tCard;
        this.tPhone = tPhone;
        this.tGender = tGender;
        this.tNickname = tNickname;
    }


    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettCard() {
        return tCard;
    }

    public void settCard(String tCard) {
        this.tCard = tCard;
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    public String gettGender() {
        return tGender;
    }

    public void settGender(String tGender) {
        this.tGender = tGender;
    }

    public String gettNickname() {
        return tNickname;
    }

    public void settNickname(String tNickname) {
        this.tNickname = tNickname;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tId='" + tId + '\'' +
                ", tCard='" + tCard + '\'' +
                ", tPhone='" + tPhone + '\'' +
                ", tGender='" + tGender + '\'' +
                ", tNickname='" + tNickname + '\'' +
                '}';
    }
}