package com.muz.mvpframe.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.muz.mvpframe.app.MyApplication;
import com.muz.mvpframe.label.MMKVLabel;
import com.muz.mvpframe.utils.InfoUtils;
import com.tencent.mmkv.MMKV;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * @description  fragment 基类
 * @author  Muz
 * @date  2018/10/18 16:26
 */
public abstract class BaseFragment extends SupportFragment implements BaseView{
    protected Context context;
    private Unbinder unbinder;
    protected Realm realm;
    protected boolean isInited = false;
    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(),null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder= ButterKnife.bind(this,view);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        isInited = true;
        initViewAndEvent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
            realm.close();
        MMKV.onExit();
    }
    @Override
    public void hint(String hint) {
        InfoUtils.showInfo(getContext(), hint);
    }

    /**
     * 退出登录
     */
    @Override
    public void logonFailure() {
//        MyApplication.getInstance().loginAgain();
//
//        MMKV.mmkvWithID(MMKVLabel.loginState.LOGIN_STATE_FILE_NAME_LABEL, MMKV.SINGLE_PROCESS_MODE, MMKVLabel.loginState.LOGIN_STATE_FILE_KEY_LABEL)
//                .clearAll();
//        startActivity(LoginActivity.class);
    }
    /**
     * 绑定布局
     * @return   布局
     */
    protected abstract int getLayout();

    /**
     * 初始化布局和事件
     */
    protected abstract void initViewAndEvent();
    /**
     * 打开Activity
     *
     * @param cls 目标class
     */
    public void startActivity(Class<?> cls) {
        startActivity(new Intent(getContext(), cls));
    }
}
