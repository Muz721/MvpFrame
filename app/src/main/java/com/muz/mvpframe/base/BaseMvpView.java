package com.muz.mvpframe.base;


/**
 * @description  view基类
 * @author  Muz
 * @date  2018/10/18 16:25
 */
public interface BaseMvpView {
    /**
     * 请求失败                   统一处理
     *
     * @param msg 失败信息
     */
    void showErrorMsg(String msg);

    /**
     * 请求失败  加载
     */
    void stateError();

    /**
     * 登录失效
     */
    void logonFailure();
}
