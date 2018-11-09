package com.muz.mvpframe.di.component;





import com.muz.mvpframe.di.module.FragmentModule;
import com.muz.mvpframe.di.module.PageModule;
import com.muz.mvpframe.di.scope.ActivityScope;

import dagger.Component;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:26
 */
@ActivityScope
@Component(dependencies = ApiComponent.class,modules = {FragmentModule.class, PageModule.class})
public interface FragmentComponent {

}
