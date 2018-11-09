package com.muz.mvpframe.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @description  统一activity生命周期处理
 * @author  Muz
 * @date  2018/10/18 16:26
 */
public final class ActivityLifecycleManager implements Application.ActivityLifecycleCallbacks{
    /**
     * Activity集合，用于彻底退出应用
     */
    private List<Activity> activities = new ArrayList<>();
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        addActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        removeActivity(activity);
    }
    /**
     * 向Activity集合中添加元素
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
        Log.e("add=","add");
    }
    /**
     * 从Activity集合中移除元素
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        if (activities != null) {
            activities.remove(activity);
        }
    }
    /**
     * 返回登录
     */
    public void loginAgain() {
        Log.e("activities=","返回登录");
        for (Activity activity : activities) {
            Log.e("activities=","activities");
            if (activity != null) {
                Log.e("loginAgain=","loginAgain");
                activity.finish();
            }
        }
    }
}
