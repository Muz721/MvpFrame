package com.muz.mvpframe.component;


import android.support.annotation.CheckResult;
import android.view.View;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @description  
 * @author  Muz
 * @date  2018/10/19 15:22
 */

public final class MuzRxView {
    @CheckResult
    @NonNull
    public static Observable<View> clicks(@NonNull View view){
        MuzPreconditions.checkNotNull(view,"view == null");
        return new MuzViewClickObservable(view).throttleFirst(1, TimeUnit.SECONDS);
    }
    @CheckResult
    @NonNull
    public static Consumer<? super Boolean> enabled(@NonNull final View view){
        MuzPreconditions.checkNotNull(view,"view == null");
        return new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                view.setEnabled(aBoolean);
            }
        };
    }
}
