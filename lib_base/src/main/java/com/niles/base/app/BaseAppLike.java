package com.niles.base.app;

import android.content.res.Resources;

import com.niles.separate.application.AbsApplicationLike;

import timber.log.Timber;

/**
 * Created by Niles
 * Date 2018/12/29 11:13
 * Email niulinguo@163.com
 */
public abstract class BaseAppLike extends AbsApplicationLike {

    protected final String TAG = getClass().getName();

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.tag(TAG).d("【" + getModuleName() + "】已加载");
    }

    protected abstract String getModuleName();

    protected Resources getResources() {
        return getApplication().getResources();
    }
}
