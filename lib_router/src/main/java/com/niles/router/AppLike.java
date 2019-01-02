package com.niles.router;

import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.app.BaseAppLike;

/**
 * Created by Niles
 * Date 2018/12/29 14:08
 * Email niulinguo@163.com
 */
public class AppLike extends BaseAppLike {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(getApplication());
    }

    @Override
    protected String getModuleName() {
        return getResources().getString(R.string.router_app_name);
    }
}
