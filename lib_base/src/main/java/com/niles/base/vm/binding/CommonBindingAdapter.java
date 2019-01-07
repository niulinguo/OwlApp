package com.niles.base.vm.binding;

import android.databinding.BindingAdapter;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.niles.base.BuildConfig;
import com.niles.base.vm.command.ClickCommand;

/**
 * Created by Niles
 * Date 2018/12/29 18:13
 * Email niulinguo@163.com
 */
public class CommonBindingAdapter {

    private static long sLastClickTime;

    @BindingAdapter("common:onClick")
    public static void onClick(View view, final ClickCommand clickCommand) {
        view.setClickable(true);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currTime = System.currentTimeMillis();
                if (currTime - sLastClickTime > 1000) {
                    sLastClickTime = currTime;
                    try {
                        clickCommand.onClick();
                    } catch (Exception e) {
                        // 点击异常
                        if (BuildConfig.DEBUG) {
                            LogUtils.eTag("onClick", e);
                        }
                    }
                } else {
                    // 一秒内重复点击
                    if (BuildConfig.DEBUG) {
                        LogUtils.eTag("onClick", "重复点击");
                    }
                }
            }
        });
    }
}
