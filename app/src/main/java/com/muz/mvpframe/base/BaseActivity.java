package com.muz.mvpframe.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;


import com.muz.mvpframe.app.MyApplication;
import com.muz.mvpframe.label.MMKVLabel;
import com.muz.mvpframe.utils.InfoUtils;
import com.tencent.mmkv.MMKV;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author Muz
 * @description activity 基类
 * @date 2018/10/18 16:26
 */
public abstract class BaseActivity extends SupportActivity implements BaseView {
    private Unbinder unbinder;
    protected Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        onViewCreated();
        unbinder = ButterKnife.bind(this);
        realm = Realm.getDefaultInstance();
        initViewAndEvent();
    }

    /**
     * @param toolbar toolbar
     * @param title   标题
     */
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    protected void onViewCreated() {

    }

    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void startActivityFinish(Class<?> cls) {
        startActivity(new Intent(this, cls));
        finish();
    }
    /**
     * 绑定布局
     *
     * @return 布局
     */
    protected abstract int getLayout();

    /**
     * 初始化布局和事件
     */
    protected abstract void initViewAndEvent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        Log.e("onDestroy", "onDestroy");
        if (realm != null) {
            realm.close();
        }
        MMKV.onExit();
    }

    @Override
    public void hint(String hint) {
        InfoUtils.showInfo(this, hint);
    }

    /**
     * 退出登录
     */
    @Override
    public void logonFailure() {
        MyApplication.getInstance().loginAgain();
        /**
         * 清除数据库数据
         */
//        realm.beginTransaction();
//        realm.deleteAll();
//        realm.commitTransaction();
        /**
         * 删除数据库                       使用这个方法        清除数据库数据会导致Activity不存在但realm还没有关闭，造成realm使用RxJava2赋值时，控件为null的错误
         */
        if (realm != null) {
            while (!realm.isClosed()) {
                realm.close();
            }
        }
        MyApplication.getInstance().realmDelete();
        MMKV.mmkvWithID(MMKVLabel.loginState.LOGIN_STATE_FILE_NAME_LABEL, MMKV.SINGLE_PROCESS_MODE, MMKVLabel.loginState.LOGIN_STATE_FILE_KEY_LABEL)
                .clearAll();
//        startActivity(LoginActivity.class); 退出到登录界面
    }
}
