package com.muz.mvpframe.component;

import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/**
 * @description  
 * @author  Muz
 * @date  2018/10/19 15:19
 */

public class MuzViewClickObservable extends Observable<View> {
    private final View view;

    MuzViewClickObservable(View view) {
        this.view = view;
    }

    @Override
    protected void subscribeActual(Observer<? super View> observer) {
        if (!MuzPreconditions.checkMainThread(observer)){
            return;
        }
        MuzPreconditions.checkMainThread(observer);
        Listener listener = new Listener(view, observer);
        observer.onSubscribe(listener);
        view.setOnClickListener(listener);
    }
    static final class Listener extends MainThreadDisposable implements View.OnClickListener{
        private final View view;
        private final Observer<? super View> observer;
        Listener(View view, Observer<? super View> observer) {
            this.view = view;
            this.observer = observer;
        }
        @Override
        public void onClick(View v) {
            if (!isDisposed()) {
                observer.onNext(v);
            }
        }

        @Override
        protected void onDispose() {
view.setOnClickListener(null);
        }
    }
}
