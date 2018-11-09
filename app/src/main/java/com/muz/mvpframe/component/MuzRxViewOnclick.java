package com.muz.mvpframe.component;

import android.support.annotation.NonNull;
import android.util.Log;


import com.muz.mvpframe.base.BaseView;

import io.reactivex.observers.ResourceObserver;

/**
 * 点击事件错误
 * @param <T>         可放到CommonSubscriber
 *           这样写是为了区分，后面可能合并到一起
 */

public abstract class MuzRxViewOnclick<T> extends ResourceObserver<T> {
    public BaseView view;//显示错误信息  或者  用户错误相关处理操作
    public MuzRxViewOnclick(@NonNull BaseView view){
        this.view =view;
    }


    @Override
    public void onError(Throwable e) {
if (view == null){
    return;
}
if (e instanceof NullPointerException){
    Log.e("MuzRxViewOnclick=",e.getMessage());
}else if(e instanceof IllegalAccessException){
    Log.e("MuzRxViewOnclick=",e.getMessage());
}
//TODO   处理点击错误      上传错误日志
    }

    @Override
    public void onComplete() {

    }
}
