package com.niles.main;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.activity.BaseActivity;
import com.niles.base.router.RouterPath;

public class DebugMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_debug_main);
    }

    public void openSplashActivity(View view) {
        ARouter
                .getInstance()
                .build(RouterPath.MainModule.Activity.Splash)
                .navigation(this);
    }

    public void openMainTabActivity(View view) {
        ARouter
                .getInstance()
                .build(RouterPath.MainModule.Activity.MainTab)
                .navigation(this);
    }
}
