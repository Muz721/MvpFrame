package com.muz.mvpframe.model.http.function;

/**
 * @description  统一处理错误
 * @author  Muz
 * @date  2018/10/18 16:49
 */

public class Fault extends RuntimeException {
    private int code;

    public Fault(int code, String message){
        super(message);
        this.code = code;
    }

    public int code() {
        return code;
    }
}
