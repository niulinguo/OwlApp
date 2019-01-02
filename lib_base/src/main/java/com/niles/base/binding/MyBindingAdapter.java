package com.niles.base.binding;

import android.databinding.BindingAdapter;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.niles.base.BuildConfig;

/**
 * Created by Niles
 * Date 2018/12/29 18:13
 * Email niulinguo@163.com
 */
public class MyBindingAdapter {

    private static long sLastClickTime;

    @BindingAdapter("my:onClick")
    public static void onClick(View view, final View.OnClickListener listener) {
        view.setClickable(true);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currTime = System.currentTimeMillis();
                if (currTime - sLastClickTime > 1000) {
                    sLastClickTime = currTime;
                    try {
                        listener.onClick(v);
                    } catch (Exception e) {
                        // 点击异常
                        if (BuildConfig.DEBUG) {
                            LogUtils.eTag("click", e);
                        }
                    }
                } else {
                    // 一秒内重复点击
                    if (BuildConfig.DEBUG) {
                        LogUtils.eTag("click", "重复点击");
                    }
                }
            }
        });
    }
}
