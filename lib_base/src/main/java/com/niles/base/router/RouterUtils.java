package com.niles.base.router;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Niles
 * Date 2019/1/15 12:08
 * Email niulinguo@163.com
 * <p>
 * 路由工具类
 */
public class RouterUtils {

    /**
     * 查找 Fragment，如果没有，返回 Lose Fragment
     */
    public static Fragment createFragment(Postcard postcard) {
        Object obj = postcard.navigation();

        Fragment fragment;

        if (!(obj instanceof Fragment)) {
            fragment = (Fragment) ARouter.getInstance()
                    .build(RouterPath.BaseModule.Fragment.Lost)
                    .withString(RouterParamKey.NAME, postcard.getPath())
                    .navigation();
        } else {
            fragment = (Fragment) obj;
        }

        return fragment;
    }
}
