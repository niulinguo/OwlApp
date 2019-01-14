package com.niles.sign.activity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.niles.base.router.RouterPath;
import com.niles.base.router.service.LoginService;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.MVVMBaseActivity;
import com.niles.sign.R;
import com.niles.sign.databinding.SignActivityLoginBinding;
import com.niles.sign.vm.LoginViewModel;

/**
 * 登录页面
 */
@Route(path = RouterPath.SignModule.Activity.Login)
public class LoginActivity extends MVVMBaseActivity {

    // 登录服务
    @Autowired(name = RouterPath.SignModule.Service.Login)
    LoginService mLoginService;

    private SignActivityLoginBinding mBinding;
    private LoginViewModel mViewModel;

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
    }

    @Override
    protected BaseViewModel createViewModel() {
        // 初始化 ViewModel
        mViewModel = ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                //noinspection unchecked
                return (T) new LoginViewModel(mLoginService);
            }
        }).get(LoginViewModel.class);

        // 用户名初始化
        String lastUsername = mLoginService.getLastUsername();
        if (!TextUtils.isEmpty(lastUsername)) {
            mViewModel.mUserEditText.set(lastUsername);
        }

        // 密码初始化
        boolean rememberPwd = mLoginService.isRememberPwd();
        mViewModel.mRememberPwdChecked.set(rememberPwd);
        if (rememberPwd) {
            String password = mLoginService.getPassword(lastUsername);
            if (!TextUtils.isEmpty(password)) {
                mViewModel.mPasswordText.set(password);
            }
        }

        return mViewModel;
    }
}
