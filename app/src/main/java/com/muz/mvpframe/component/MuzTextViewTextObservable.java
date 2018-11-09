package com.muz.mvpframe.component;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/**
 * @author Muz
 * @description
 * @date 2018/10/19 15:28
 */

public class MuzTextViewTextObservable extends Observable<CharSequence> {
    TextView textView;

    MuzTextViewTextObservable(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void subscribeActual(Observer<? super CharSequence> observer) {//不限制线程
        Listener listener = new Listener(textView, observer);
        observer.onSubscribe(listener);
        textView.addTextChangedListener(listener);
    }

    static final class Listener extends MainThreadDisposable implements TextWatcher {
        private final TextView textView;
        private final Observer<? super CharSequence> observer;

        Listener(TextView textView, Observer<? super CharSequence> observer) {
            this.textView = textView;
            this.observer = observer;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            observer.onNext(s);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

        @Override
        protected void onDispose() {
            textView.removeTextChangedListener(this);
        }
    }
}
