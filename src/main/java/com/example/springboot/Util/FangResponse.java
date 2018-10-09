package com.example.springboot.Util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangyushuai@fang.com on 2018/9/26.
 */
public class FangResponse implements Serializable {

    private final static long serialVersionUID = 1L;

    private int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    private String msg;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "lz",timezone = "GMT+8")
    private Date timestamp;
    @JsonIgnore
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    public Date getTime() {
        return new Date();
    }

    public void setTime(Date time) {
        this.timestamp = time;
    }

    public FangResponse(int code, String msg, Object data) {
        super();
        this.status = code;
        this.msg = msg;
        this.data = data;
    }

    public static FangResponse buildSuccess(Object data) {
        return new FangResponse(200, "success", data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
