package com.yinghua.jilijili.bean;

/**
 * @author Luojiaju
 * @description: 订单实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
public class Orderforgoods {
    private String oId;

    private String oTid;

    private String oMid;

    private String oCid;

    private String oTphone;

    private String oTcard;

    private String oMmovieName;

    private String oCseatnumber;

    private String oTnickname;

    private String oBookingdate;

    private String oExpire;

    private String oStartTime;

    public Orderforgoods() {
    }

    public Orderforgoods(String oId, String oTid, String oMid, String oCid, String oTphone, String oTcard, String oMmovieName, String oCseatnumber, String oTnickname, String oBookingdate, String oExpire, String oStartTime) {
        this.oId = oId;
        this.oTid = oTid;
        this.oMid = oMid;
        this.oCid = oCid;
        this.oTphone = oTphone;
        this.oTcard = oTcard;
        this.oMmovieName = oMmovieName;
        this.oCseatnumber = oCseatnumber;
        this.oTnickname = oTnickname;
        this.oBookingdate = oBookingdate;
        this.oExpire = oExpire;
        this.oStartTime = oStartTime;

    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getoTid() {
        return oTid;
    }

    public void setoTid(String oTid) {
        this.oTid = oTid;
    }

    public String getoMid() {
        return oMid;
    }

    public void setoMid(String oMid) {
        this.oMid = oMid;
    }

    public String getoCid() {
        return oCid;
    }

    public void setoCid(String oCid) {
        this.oCid = oCid;
    }

    public String getoTphone() {
        return oTphone;
    }

    public void setoTphone(String oTphone) {
        this.oTphone = oTphone;
    }

    public String getoTcard() {
        return oTcard;
    }

    public void setoTcard(String oTcard) {
        this.oTcard = oTcard;
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

    public String getoExpire() {
        return oExpire;
    }

    public void setoExpire(String oExpire) {
        this.oExpire = oExpire;
    }

    public String getoStartTime() {
        return oStartTime;
    }

    public void setoStartTime(String oStartTime) {
        this.oStartTime = oStartTime;
    }


    @Override
    public String toString() {
        return "Orderforgoods{" +
                "oId='" + oId + '\'' +
                ", oTid='" + oTid + '\'' +
                ", oMid='" + oMid + '\'' +
                ", oCid='" + oCid + '\'' +
                ", oTphone='" + oTphone + '\'' +
                ", oTcard='" + oTcard + '\'' +
                ", oMmovieName='" + oMmovieName + '\'' +
                ", oCseatnumber='" + oCseatnumber + '\'' +
                ", oTnickname='" + oTnickname + '\'' +
                ", oBookingdate='" + oBookingdate + '\'' +
                ", oExpire='" + oExpire + '\'' +
                ", oStartTime='" + oStartTime + '\'' +
                '}';
    }
}