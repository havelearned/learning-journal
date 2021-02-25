package com.yinghua.jilijili.bean;

import java.util.Date;

/**
 * @author Luojiaju
 * @description: 订单实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/

public class Orderforgoods {
    private int oId;
    private String oTphone;
    private String oMmovieName;
    private String oCseatnumber;
    private String oTnickname;
    private String oBookingdate;
    private String newTime;


    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public Orderforgoods(String oTphone, String oMmovieName) {
        this.oTphone = oTphone;
        this.oMmovieName = oMmovieName;
    }

    public int getoId() {
        return oId;
    }

    public String getoTphone() {
        return oTphone;
    }

    public void setoTphone(String oTphone) {
        this.oTphone = oTphone;
    }

    public String getoMmovieName() {
        return oMmovieName;
    }

    public void setoMmovieName(String oMmovieName) {
        this.oMmovieName = oMmovieName;
    }

    public String getoCseatnumber() {
        return oCseatnumber;
    }

    public void setoCseatnumber(String oCseatnumber) {
        this.oCseatnumber = oCseatnumber;
    }

    public String getoTnickname() {
        return oTnickname;
    }

    public void setoTnickname(String oTnickname) {
        this.oTnickname = oTnickname;
    }

    public String getoBookingdate() {
        return oBookingdate;
    }

    public void setoBookingdate(String oBookingdate) {
        this.oBookingdate = oBookingdate;
    }

    public Orderforgoods() {
    }
}