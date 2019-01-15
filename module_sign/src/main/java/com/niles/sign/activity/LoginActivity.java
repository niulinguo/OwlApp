package com.niles.sign.activity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.niles.base.router.RouterPath;
import com.niles.base.router.service.LoginService;
import com.niles.base.vm.MVVMBaseActivity;
import com.niles.sign.R;
import com.niles.sign.databinding.SignActivityLoginBinding;
import com.niles.sign.vm.LoginViewModel;

/**
 * 登录页面
 */
@Route(path = RouterPath.SignModule.Activity.Login)
public class LoginActivity extends MVVMBaseActivity<LoginViewModel> {

    // 登录服务
    @Autowired(name = RouterPath.SignModule.Service.Login)
    LoginService mLoginService;

    private SignActivityLoginBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.sign_activity_login);
        mBinding.setViewModel(mViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
        mBinding = null;
    }

    @Override
    protected LoginViewModel createViewModel() {
        return ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                //noinspection unchecked
                return (T) new LoginViewModel(mLoginService);
            }
        }).get(LoginViewModel.class);
    }
}
