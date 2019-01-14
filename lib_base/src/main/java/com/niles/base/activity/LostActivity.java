package com.niles.base.activity;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.router.RouterParamKey;
import com.niles.base.router.RouterPath;

/**
 * Created by Niles
 * Date 2019/1/14 16:58
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.BaseModule.Activity.Lost)
public class LostActivity extends FragmentContainerActivity {

    @Autowired(name = RouterParamKey.NAME)
    String mName;

    @Override
    protected Fragment createFragment() {
        return (Fragment) ARouter.getInstance()
                .build(RouterPath.BaseModule.Fragment.Lost)
                .withString(RouterParamKey.NAME, mName)
                .navigation();
    }
}
