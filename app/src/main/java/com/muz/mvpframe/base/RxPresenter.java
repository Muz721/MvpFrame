package com.muz.mvpframe.base;





import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @description  基于Rx的Presenter封装,控制订阅的生命周期
 * @author  Muz
 * @date  2018/10/18 16:24
 */
public class RxPresenter<T extends BaseMvpView> implements BasePresenter<T> {

    protected T view;
    protected CompositeDisposable compositeDisposable;
    protected void unSubscribe(){
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }
    protected void addSubscribe(Disposable subscription) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
        unSubscribe();
    }


}
