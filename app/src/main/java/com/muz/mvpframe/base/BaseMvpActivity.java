package com.muz.mvpframe.base;

import android.app.Dialog;


import com.muz.mvpframe.di.module.ActivityModule;

import javax.inject.Inject;


/**
 * @description  MVP 模式基类
 * @author  Muz
 * @date  2018/10/18 16:25
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseMvpView {
    @Inject
    protected T mPresenter;
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    /**
     * 网络请求时的等待对话框
     */
    private Dialog dialog = null;
    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }
    /**
     * 请求失败
     * @param msg    失败信息
     */
    @Override
    public void showErrorMsg(String msg) {
        hint(msg);
        closeWaitDialog();
    }

    @Override
    public void stateError() {
        closeWaitDialog();
        //finish();
    }



    protected abstract void initInject();
    /**
     * 显示等待对话框
     *
     * @param message 提示信息
     */
    public void showWaitDialog(String message) {

    }

    /**
     * 关闭等待对话框
     */
    public void closeWaitDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
