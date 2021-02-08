package com.yinghua.viewpager.bean;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yinghua.viewpager.utily.ValidateUtil;


/**
 * 网络访问返回的对象
 * */

public class CommonResult {
    private String statr;//状态
    private String msg;//描述
    private String token;//临时标记，表示用户登录了
    private JSONObject date;// 数据对象
    private JSONArray row;//列表
    private JSONArray rows;//列表
    private JSONArray value;//列表
    private JSONArray values;//列表
    private int total;//array的数量

    /*JSONArray转换成String*/
    public String getRowString(){
        return ValidateUtil.isJaValid(row) ? JSON.toJSONString(row):"";
    }
    public String getRowsString(){
        return ValidateUtil.isJaValid(rows) ? JSON.toJSONString(rows):"";
    }
    public String getValueString(){
        return ValidateUtil.isJaValid(value) ? JSON.toJSONString(value):"";
    }
    public String getValuesString(){
        return ValidateUtil.isJaValid(values) ? JSON.toJSONString(values):"";
    }


    public String getStatr() {
        return statr;
    }

    public void setStatr(String statr) {
        this.statr = statr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JSONObject getDate() {
        return date;
    }

    public void setDate(JSONObject date) {
        this.date = date;
    }

    public JSONArray getRow() {
        return row;
    }

    public void setRow(JSONArray row) {
        this.row = row;
    }

    public JSONArray getRows() {
        return rows;
    }

    public void setRows(JSONArray rows) {
        this.rows = rows;
    }

    public JSONArray getValue() {
        return value;
    }

    public void setValue(JSONArray value) {
        this.value = value;
    }

    public JSONArray getValues() {
        return values;
    }

    public void setValues(JSONArray values) {
        this.values = values;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
