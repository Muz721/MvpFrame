package com.muz.mvpframe.di.module;

import android.content.Context;


import com.muz.mvpframe.model.Loader;
import com.muz.mvpframe.model.http.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Muz
 * @description
 * @date 2018/10/18 17:08
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    Loader provideLoader(Api api) {
        return new Loader(api);
    }
}
