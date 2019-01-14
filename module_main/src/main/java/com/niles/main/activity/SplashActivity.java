package com.niles.main.activity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.niles.base.router.RouterPath;
import com.niles.base.router.service.LoginService;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.MVVMBaseActivity;
import com.niles.main.R;
import com.niles.main.databinding.MainActivitySplashBinding;
import com.niles.main.vm.SplashViewModel;

/**
 * 闪屏页
 */
@Route(path = RouterPath.MainModule.Activity.Splash)
public class SplashActivity extends MVVMBaseActivity {

    @Autowired(name = RouterPath.SignModule.Service.Login)
    LoginService mLoginService;

    private MainActivitySplashBinding mBinding;
    private SplashViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity_splash);

        // 页面绑定 ViewModel
        mBinding.setViewModel(mViewModel);

        // 开始倒计时
        mViewModel.startCountdown();
    }

    @Override
    protected BaseViewModel createViewModel() {
        // 获取 ViewModel
        mViewModel = ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                //noinspection unchecked
                return (T) new SplashViewModel(mLoginService);
            }
        }).get(SplashViewModel.class);

        return mViewModel;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
    }
}
