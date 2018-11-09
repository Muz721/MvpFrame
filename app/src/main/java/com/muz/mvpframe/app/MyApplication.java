package com.muz.mvpframe.app;

import android.app.Application;
import android.util.Log;


import com.muz.mvpframe.di.component.ActivityComponent;
import com.muz.mvpframe.di.component.ApiComponent;
import com.muz.mvpframe.di.component.AppComponent;
import com.muz.mvpframe.di.component.DaggerActivityComponent;
import com.muz.mvpframe.di.component.DaggerApiComponent;
import com.muz.mvpframe.di.component.DaggerAppComponent;
import com.muz.mvpframe.di.component.DaggerFragmentComponent;
import com.muz.mvpframe.di.component.FragmentComponent;
import com.muz.mvpframe.di.module.ApiModule;
import com.tencent.mmkv.MMKV;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * @author Muz
 * @description
 * @date 2018/10/18 16:27
 */

public class MyApplication extends Application {

    /**
     * Application实例
     */
    private static MyApplication application;

    /**
     * Application实例
     */
    public static MyApplication getInstance() {
        return application;
    }

    private static AppComponent appComponent;
    private RealmConfiguration realmConfiguration;
    private ActivityLifecycleManager activityLifecycleManager;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 验证ID
     */
    private String sessionId;
    /**
     * 商店id
     */
    private String shopId;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        activityLifecycleManager = new ActivityLifecycleManager();
        registerActivityLifecycleCallbacks(activityLifecycleManager);
        /**
         * dagger2
         */
        if (appComponent == null) {
            appComponent = DaggerAppComponent.create();
        }
        /**
         * 数据库
         */
        Realm.init(this);
        realmConfiguration = new RealmConfiguration.Builder()
                .name("cloudgatherbeautiful.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        /**
         * MMKV
         */
        MMKV.initialize(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private ApiComponent getApiComponent() {
        return DaggerApiComponent.builder()
                .appComponent(getAppComponent())
                .apiModule(new ApiModule())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .apiComponent(getApiComponent())
                .build();
    }

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .apiComponent(getApiComponent())
                .build();
    }

    public void loginAgain() {
        Log.e("loginAgain=","activityLifecycleManager");
        activityLifecycleManager.loginAgain();
    }

    public void realmDelete() {
        Realm.deleteRealm(realmConfiguration);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

}
