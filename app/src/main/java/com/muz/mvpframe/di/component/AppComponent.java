package com.muz.mvpframe.di.component;





import com.muz.mvpframe.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:26
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
}
