package com.niles.main.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.os.CountDownTimer;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Niles
 * Date 2019/1/2 09:21
 * Email niulinguo@163.com
 * <p>
 * 闪屏页 ViewModel
 */
public class SplashViewModel extends ViewModel {

    // 【跳转主页面】
    public final MutableLiveData<Void> mToMainAction = new MutableLiveData<>();
    // 【倒计时控件】显示的字符串
    public final ObservableField<String> mCountdownText = new ObservableField<>();
    // 【倒计时控件】点击监听
    public final View.OnClickListener mCountdownClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mToMainAction.postValue(null);
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
            mToMainAction.postValue(null);
        }
    };

    /**
     * 启动计时器
     */
    public void startCountdown() {
        mCountDownTimer.start();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // 取消计时器
        mCountDownTimer.cancel();
    }
}
