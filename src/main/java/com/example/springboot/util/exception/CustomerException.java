package com.example.springboot.util.exception;

/**
 * Created by wangyushuai@fang.com on 2018/9/26.
 * 自定义异常类
 */
public class CustomerException extends Exception {
    private int status;
    private String msg;
    private String error;
    private String path;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
