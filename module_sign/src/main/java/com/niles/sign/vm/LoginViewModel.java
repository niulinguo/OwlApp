package com.niles.sign.vm;

import android.app.Activity;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.niles.base.AppLike;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;
import com.niles.instancepool.InstancePool;
import com.niles.router.RouterPath;
import com.niles.router.service.LoginService;

/**
 * Created by Niles
 * Date 2019/1/2 17:40
 * Email niulinguo@163.com
 */
public class LoginViewModel extends BaseViewModel {

    // 填写项-用户名
    public final ObservableField<String> mUserEditText = new ObservableField<>("");
    // 填写项-密码
    public final ObservableField<String> mPasswordText = new ObservableField<>("");
    // 勾选项-记住密码
    public final ObservableField<Boolean> mRememberPwdChecked = new ObservableField<>(false);
    // 勾选项-用户协议
    public final ObservableField<Boolean> mReadProtocolChecked = new ObservableField<>(false);
    /**
     * 注册按钮被点击
     */
    public final ClickCommand mRegisterClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };
    /**
     * 找回密码按钮被点击
     */
    public final ClickCommand mFindPwdClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

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
            final Boolean rememberPwd = mRememberPwdChecked.get();
            final String username = mUserEditText.get();
            final String password = mPasswordText.get();
            Boolean readProtocol = mReadProtocolChecked.get();
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
            if (readProtocol == null || !readProtocol) {
                mToastMessage.setValue("请阅读协议");
                return;
            }

            mDialogMessage.setValue(true);
            InstancePool.get(AppLike.class).getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // 登录成功

                    // 隐藏 Dialog
                    mDialogMessage.setValue(false);

                    // 保存登录信息
                    mLoginService.loginByPwdSuccess(username,
                            rememberPwd == null ? false : rememberPwd,
                            password,
                            password,
                            "{name:\"" + username + "\"}"
                    );

                    // 跳转主页面
                    mNavigationMessage.setValue(ARouter
                            .getInstance()
                            .build(RouterPath.MainModule.Activity.MainTab));

                    // 设置结果-登录成功
                    mSimpleSetResultMessage.setValue(Activity.RESULT_OK);

                    // 关闭页面
                    mFinishMessage.setValue(null);
                }
            }, 3000);
        }
    };

    public LoginViewModel(LoginService loginService) {
        mLoginService = loginService;
    }
}
