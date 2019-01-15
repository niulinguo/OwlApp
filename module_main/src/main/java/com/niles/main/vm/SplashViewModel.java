package com.niles.main.vm;

import android.databinding.ObservableField;
import android.os.CountDownTimer;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.niles.base.router.RouterPath;
import com.niles.base.router.service.LoginService;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;

/**
 * Created by Niles
 * Date 2019/1/2 09:21
 * Email niulinguo@163.com
 * <p>
 * 闪屏页 ViewModel
 */
public class SplashViewModel extends BaseViewModel {

    // 【倒计时控件】显示的字符串
    public final ObservableField<String> mCountdownText = new ObservableField<>("3");
    private final LoginService mLoginService;
    // 【倒计时控件】点击监听
    public final ClickCommand mCountdownClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            toMainAction();
        }
    };
    // 计时器
    private final CountDownTimer mCountDownTimer = new CountDownTimer(4099, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            LogUtils.e("onTick" + millisUntilFinished);
            // 页面倒计时显示
            mCountdownText.set(String.valueOf(millisUntilFinished / 1000 - 1));
        }

        @Override
        public void onFinish() {
            LogUtils.e("onFinish");
            // 倒计时结束，跳转主页面
            toMainAction();
        }
    };
    private boolean mCountDownStatus = false;

    public SplashViewModel(LoginService loginService) {
        mLoginService = loginService;
    }

    /**
     * 启动计时器
     */
    public void startCountdown() {
        if (!mCountDownStatus) {
            mCountDownStatus = true;
            mCountDownTimer.start();
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // 取消计时器
        mCountDownTimer.cancel();
        mCountDownStatus = false;
    }

    private void toMainAction() {
        if (mLoginService.hasLogin()) {
            navigation(ARouter
                    .getInstance()
                    .build(RouterPath.MainModule.Activity.MainTab));
        } else {
            navigation(ARouter
                    .getInstance()
                    .build(RouterPath.SignModule.Activity.Login));
        }
        finish();
    }
}
