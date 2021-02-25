/**
 * Copyright 2021 json.cn
 */
package com.yinghua.jilijili.bean;
import java.util.List;

/**
 * Auto-generated: 2021-02-23 16:45:25
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Email {

    private int code;
    private String msg;
    private List<String> data;
    private String mail_id;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
    public List<String> getData() {
        return data;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }
    public String getMail_id() {
        return mail_id;
    }

}