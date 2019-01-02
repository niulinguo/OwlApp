package com.niles.base;

import com.blankj.utilcode.util.Utils;
import com.niles.base.app.BaseAppLike;

/**
 * Created by Niles
 * Date 2018/12/28 18:01
 * Email niulinguo@163.com
 */
public class AppLike extends BaseAppLike {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化工具类
        Utils.init(getApplication());
    }

    @Override
    protected String getModuleName() {
        return getResources().getString(R.string.base_app_name);
    }
}
