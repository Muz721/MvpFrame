package com.muz.mvpframe.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;


import com.muz.mvpframe.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author Muz
 * @description
 * @date 2018/10/18 17:17
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
