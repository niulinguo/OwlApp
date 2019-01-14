package com.niles.base;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.niles.base.app.BaseAppLike;
import com.niles.instancepool.InstanceCreator;
import com.niles.instancepool.InstancePool;
import com.orhanobut.hawk.Hawk;

/**
 * Created by Niles
 * Date 2018/12/28 18:01
 * Email niulinguo@163.com
 */
public class AppLike extends BaseAppLike {

    @Override
    public void onCreate() {
        super.onCreate();
        // 声明该类为单例模式
        InstancePool.register(AppLike.class, new InstanceCreator<AppLike>() {
            @Override
            public AppLike createInstance() {
                return AppLike.this;
            }
        });

        // 初始化工具类
        Utils.init(getApplication());

        // 初始化 SP
        Hawk.init(getApplication())
                .build();

        // 初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(getApplication());
    }

    @Override
    protected String getModuleName() {
        return getResources().getString(R.string.base_app_name);
    }
}
