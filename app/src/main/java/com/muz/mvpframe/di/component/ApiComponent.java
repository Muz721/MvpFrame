package com.muz.mvpframe.di.component;





import com.muz.mvpframe.di.module.ApiModule;
import com.muz.mvpframe.di.scope.ApiScope;
import com.muz.mvpframe.model.Loader;

import dagger.Component;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:26
 */
@ApiScope
@Component(dependencies = AppComponent.class, modules = ApiModule.class)
public interface ApiComponent {
Loader loader();
}
