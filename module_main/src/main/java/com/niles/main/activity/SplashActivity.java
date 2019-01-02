package com.niles.main.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.activity.BaseActivity;
import com.niles.main.R;
import com.niles.main.databinding.MainActivitySplashBinding;
import com.niles.main.vm.SplashViewModel;
import com.niles.router.RouterPath;

/**
 * 闪屏页
 */
@Route(path = RouterPath.MainModule.Activity.Splash)
public class SplashActivity extends BaseActivity {

    private MainActivitySplashBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity_splash);

        // 获取 ViewModel
        SplashViewModel vm = ViewModelProviders.of(this).get(SplashViewModel.class);
        // 跳转主页面行为
        vm.mToMainAction.observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                toMainAction();
            }
        });
        // 页面绑定 ViewModel
        mBinding.setViewModel(vm);

        if (savedInstanceState == null) {
            // 开始倒计时
            vm.startCountdown();
        }
    }

    private void toMainAction() {
        // 跳转主页面
        ARouter
                .getInstance()
                .build(RouterPath.MainModule.Activity.MainTab)
                .navigation(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
    }
}
