package com.niles.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.R;
import com.niles.base.router.RouterParamKey;
import com.niles.base.router.RouterPath;

/**
 * Created by Niles
 * Date 2019/1/14 16:15
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.BaseModule.Activity.FRAGMENT_CONTAINER)
public class FragmentContainerActivity extends BaseActivity {

    @Autowired(name = RouterParamKey.PATH)
    String mPath;

    @Autowired(name = RouterParamKey.PARAM_DATA)
    Bundle mParamData;

    protected Fragment createFragment() {
        Object obj = ARouter.getInstance()
                .build(mPath)
                .with(mParamData)
                .navigation();

        Fragment fragment;

        if (!(obj instanceof Fragment)) {
            fragment = (Fragment) ARouter.getInstance()
                    .build(RouterPath.BaseModule.Fragment.Lost)
                    .withString(RouterParamKey.NAME, mPath)
                    .navigation();
        } else {
            fragment = (Fragment) obj;
        }

        return fragment;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            return;
        }

        FrameLayout contentView = new FrameLayout(this);
        contentView.setId(R.id.fragment_container_view);
        setContentView(contentView);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, createFragment())
                .commitAllowingStateLoss();
    }
}
