package com.muz.mvpframe.base;

/**
 * Created by Administrator on 2018/10/24.
 */

public interface BaseView {
    void hint(String hint);
    /**
     * 退出登录
     */
    void logonFailure();
}
