package com.muz.mvpframe.base;


/**
 * @description  Presenter基类
 * @author  Muz
 * @date  2018/10/18 16:25
 */
public interface BasePresenter<T extends BaseMvpView> {
    void attachView(T view);

    void detachView();
}
