package com.niles.work;

import com.niles.base.app.BaseAppLike;

/**
 * Created by Niles
 * Date 2018/12/28 17:39
 * Email niulinguo@163.com
 */
public class AppLike extends BaseAppLike {

    @Override
    protected String getModuleName() {
        return getResources().getString(R.string.work_app_name);
    }
}
