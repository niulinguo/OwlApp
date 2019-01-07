package com.niles.sign.vm;

import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.niles.base.AppLike;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;
import com.niles.base.vm.model.NavigationParamWrap;
import com.niles.instancepool.InstancePool;
import com.niles.router.RouterParamKey;
import com.niles.router.RouterPath;
import com.niles.router.service.LoginService;

/**
 * Created by Niles
 * Date 2019/1/2 17:40
 * Email niulinguo@163.com
 */
public class LoginViewModel extends BaseViewModel {

    private static final int RC_REGISTER = 1;
    private static final int RC_FIND_PWD = 2;
    private static final int RC_USER_PROTOCOL = 3;

    // 填写项-用户名
    public final ObservableField<String> mUserEditText = new ObservableField<>("");
    // 填写项-密码
    public final ObservableField<String> mPasswordText = new ObservableField<>("");
    // 勾选项-记住密码
    public final ObservableBoolean mRememberPwdChecked = new ObservableBoolean(false);
    // 勾选项-用户协议
    public final ObservableBoolean mReadProtocolChecked = new ObservableBoolean(false);
    /**
     * 注册按钮被点击
     */
    public final ClickCommand mRegisterClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            NavigationParamWrap paramWrap = new NavigationParamWrap();
            paramWrap.setRc(RC_REGISTER);
            paramWrap.setPostcard(ARouter
                    .getInstance()
                    .build(RouterPath.SignModule.Activity.REGISTER)
                    .withString(RouterParamKey.NAME, mUserEditText.get())
                    .withString(RouterParamKey.PASSWORD, mPasswordText.get())
            );
            // 跳转到注册页面-有结果跳转
            mNavigationWithRcMessage.setValue(paramWrap);
        }
    };
    /**
     * 找回密码按钮被点击
     */
    public final ClickCommand mFindPwdClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            NavigationParamWrap paramWrap = new NavigationParamWrap();
            paramWrap.setRc(RC_FIND_PWD);
            paramWrap.setPostcard(ARouter
                    .getInstance()
                    .build(RouterPath.SignModule.Activity.FIND_PW)
                    .withString(RouterParamKey.NAME, mUserEditText.get())
                    .withString(RouterParamKey.PASSWORD, mPasswordText.get())
            );
            // 跳转到注册页面-有结果跳转
            mNavigationWithRcMessage.setValue(paramWrap);
        }
    };
    /**
     * 登录服务
     */
    private final LoginService mLoginService;
    /**
     * 登录按钮被点击
     */
    public final ClickCommand mLoginClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            final boolean rememberPwd = mRememberPwdChecked.get();
            final String username = mUserEditText.get();
            final String password = mPasswordText.get();
            boolean readProtocol = mReadProtocolChecked.get();
            LogUtils.eTag("login", "username:" + username + "\n" +
                    "password:" + password + "\n" +
                    "remember:" + rememberPwd + "\n" +
                    "read:" + readProtocol);

            // 检查用户名
            if (TextUtils.isEmpty(username)) {
                mToastMessage.setValue("请填写用户名");
                return;
            }

            // 检查密码
            if (TextUtils.isEmpty(password)) {
                mToastMessage.setValue("请填写密码");
                return;
            }

            // 检查用户协议
            if (!readProtocol) {
                mToastMessage.setValue("请阅读协议");
                return;
            }

            mDialogMessage.setValue(true);
            InstancePool.get(AppLike.class).getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onLoginSuccess(username, rememberPwd, password, password, "{name:\"" + username + "\"}");
                }
            }, 3000);
        }
    };

    public LoginViewModel(LoginService loginService) {
        mLoginService = loginService;
    }

    /**
     * 登录成功
     *
     * @param username    用户名
     * @param rememberPwd 记住密码
     * @param password    密码
     * @param token       Token
     * @param loginInfo   登录信息
     */
    private void onLoginSuccess(String username, boolean rememberPwd, String password, String token, String loginInfo) {
        // 隐藏 Dialog
        mDialogMessage.setValue(false);

        // 保存登录信息
        mLoginService.loginByPwdSuccess(username,
                rememberPwd,
                password,
                token,
                loginInfo
        );

        // 跳转主页面
        mNavigationMessage.setValue(ARouter
                .getInstance()
                .build(RouterPath.MainModule.Activity.MainTab));

        // 设置结果-登录成功
        mSimpleSetResultMessage.setValue(RESULT_OK);

        // 关闭页面
        mFinishMessage.setValue(null);
    }

    /**
     * 找回密码成功
     */
    private void onFindPwdSuccess() {

    }

    /**
     * 注册成功
     */
    private void onRegisterSuccess() {
        mFinishMessage.setValue(null);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case RC_FIND_PWD: {
                if (resultCode == RESULT_OK) {
                    onFindPwdSuccess();
                }
                break;
            }
            case RC_REGISTER: {
                if (resultCode == RESULT_OK) {
                    onRegisterSuccess();
                }
                break;
            }
            case RC_USER_PROTOCOL: {
                break;
            }
            default: {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
