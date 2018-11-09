package com.muz.mvpframe.model;


import android.text.TextUtils;
import android.util.Log;


import com.muz.mvpframe.base.BaseMvpView;
import com.muz.mvpframe.model.http.function.Fault;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

//import com.muz.progress.base.BaseMvpView;
//import com.muz.progress.model.htttp.function.Fault;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:24
 */

public abstract class CommonSubscriber<T> extends ResourceObserver<T> {
    private BaseMvpView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(@NonNull BaseMvpView view){
        this.mView = view;
    }

    protected CommonSubscriber(BaseMvpView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseMvpView view, boolean isShowErrorState){
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseMvpView view, String errorMsg, boolean isShowErrorState){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof Fault) {
            Log.e("((Fault) e).code() == 2",((Fault) e).code()+"");
            if (((Fault) e).code()== 2){
                Log.e("e instanceof Fault","e instanceof Fault");
                mView.logonFailure();
            }
            mView.showErrorMsg(e.getMessage());
        } else if(e instanceof RuntimeException){
            mView.showErrorMsg(e.getMessage());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("数据加载失败ヽ(≧Д≦)ノ");
        } else {
            mView.showErrorMsg("未知错误ヽ(≧Д≦)ノ");
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }
}
