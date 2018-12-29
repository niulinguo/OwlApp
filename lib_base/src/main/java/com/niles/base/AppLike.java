package com.niles.base;

import com.niles.base.app.BaseAppLike;

import timber.log.Timber;

/**
 * Created by Niles
 * Date 2018/12/28 18:01
 * Email niulinguo@163.com
 */
public class AppLike extends BaseAppLike {

    public AppLike() {
        // 初始化 Log
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected String getModuleName() {
        return "基础库";
    }
}
