package com.muz.mvpframe.base;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:26
 */

public class BaseResponse<T> {
    T data;
    private int code;
    private String info;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
