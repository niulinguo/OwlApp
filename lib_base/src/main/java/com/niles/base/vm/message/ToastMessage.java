package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.niles.base.able.ToastAble;
import com.niles.base.vm.message.SingleLiveEvent;

/**
 * Created by Niles
 * Date 2019/1/4 19:03
 * Email niulinguo@163.com
 */
public class ToastMessage extends SingleLiveEvent<String> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final ToastAble toastAble) {
        super.observe(owner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (!TextUtils.isEmpty(s)) {
                    toastAble.toast(s);
                }
            }
        });
    }
}
