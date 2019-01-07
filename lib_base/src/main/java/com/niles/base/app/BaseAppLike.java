package com.niles.base.app;

import android.content.res.Resources;
import android.os.Handler;

import com.blankj.utilcode.util.LogUtils;
import com.niles.base.BuildConfig;
import com.niles.separate.application.AbsApplicationLike;

/**
 * Created by Niles
 * Date 2018/12/29 11:13
 * Email niulinguo@163.com
 */
public abstract class BaseAppLike extends AbsApplicationLike {

    protected final String TAG = getClass().getSimpleName();
    private final Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            LogUtils.dTag(TAG, "【" + getModuleName() + "】已加载");
        }
    }

    protected abstract String getModuleName();

    protected Resources getResources() {
        return getApplication().getResources();
    }

    public Handler getHandler() {
        return mHandler;
    }
}
