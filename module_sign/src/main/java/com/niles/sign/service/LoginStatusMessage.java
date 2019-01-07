package com.niles.sign.service;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Niles
 * Date 2019/1/7 11:37
 * Email niulinguo@163.com
 */
public class LoginStatusMessage extends MutableLiveData<Boolean> {

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull final Observer<Boolean> loginStatusObserver) {
        super.observe(owner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean loginStatus) {
                if (loginStatus != null) {
                    loginStatusObserver.onChanged(loginStatus);
                }
            }
        });
    }
}
