package com.muz.mvpframe.component;


import android.os.Looper;
import android.support.annotation.NonNull;

import io.reactivex.Observer;

/**
 * @description  
 * @author  Muz
 * @date  2018/10/19 15:18
 */

public class MuzPreconditions {

    public static void checkNotNull(Object object,@NonNull String message){
if (object == null){
    throw new NullPointerException(message);
}
    }
    public static Boolean checkMainThread(Observer<?> observer){
        if (Looper.myLooper() != Looper.getMainLooper()) {
            observer.onError(new IllegalAccessException(
                    "Expected to be called on the main thread but was " + Thread.currentThread().getName()
            ));

            return false;
        }
        return true;
    }
}
