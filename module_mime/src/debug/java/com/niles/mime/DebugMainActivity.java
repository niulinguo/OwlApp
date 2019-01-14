package com.niles.mime;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.activity.BaseActivity;
import com.niles.base.router.RouterParamKey;
import com.niles.base.router.RouterPath;

public class DebugMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mime_activity_debug_main);
    }

    public void onMimeClicked(View view) {
        ARouter.getInstance()
                .build(RouterPath.BaseModule.Activity.FRAGMENT_CONTAINER)
                .withString(RouterParamKey.PATH, RouterPath.MimeModule.Fragment.Mime)
                .navigation(this);
    }
}
