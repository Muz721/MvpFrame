package com.muz.mvpframe.di.module;

import android.app.Activity;


import com.muz.mvpframe.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:27
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }
    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return activity;
    }
}
