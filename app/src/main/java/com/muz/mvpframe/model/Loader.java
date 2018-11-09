package com.muz.mvpframe.model;


import android.text.TextUtils;
import android.util.Log;


import com.muz.mvpframe.model.http.Api;

import java.util.LinkedHashMap;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author Muz
 * @description
 * @date 2018/10/18 17:13
 */

public class Loader extends ObjectLoader {
    private Api api;

    @Inject
    public Loader(Api api) {
        this.api = api;
    }

}
