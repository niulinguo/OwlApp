package com.niles.sign;

import com.niles.base.app.BaseAppLike;
import com.niles.instancepool.InstanceCreator;
import com.niles.instancepool.InstancePool;

/**
 * Created by Niles
 * Date 2018/12/28 17:39
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
    }

    @Override
    protected String getModuleName() {
        return getResources().getString(R.string.sign_app_name);
    }
}
