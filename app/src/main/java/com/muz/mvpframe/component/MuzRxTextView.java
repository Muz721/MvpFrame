package com.muz.mvpframe.component;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.widget.TextView;

import io.reactivex.Observable;


/**
 * @description  
 * @author  Muz
 * @date  2018/10/19 15:18
 */

public final class MuzRxTextView {
    @CheckResult
    @NonNull
    public static Observable<CharSequence> textChanges(@NonNull TextView textView){
        MuzPreconditions.checkNotNull(textView,"view == null");
        return new MuzTextViewTextObservable(textView);
    }
    @CheckResult
    @NonNull
    public static Observable<CharSequence> textChangesAndInitSend(@NonNull TextView textView){
        MuzPreconditions.checkNotNull(textView,"view == null");
        return new MuzTextViewTextObservableAndInitSend(textView);
    }
}
