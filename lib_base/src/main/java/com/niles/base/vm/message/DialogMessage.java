package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.base.able.DialogAble;

/**
 * Created by Niles
 * Date 2019/1/7 10:01
 * Email niulinguo@163.com
 */
public class DialogMessage extends MutableLiveData<Boolean> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final DialogAble observer) {
        super.observe(owner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean open) {
                if (open == null) {
                    return;
                }
                if (open) {
                    observer.showProgressDialog();
                } else {
                    observer.hideProgressDialog();
                }
            }
        });
    }

    public void observeForever(@NonNull final DialogAble observer) {
        super.observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean open) {
                if (open == null) {
                    return;
                }
                if (open) {
                    observer.showProgressDialog();
                } else {
                    observer.hideProgressDialog();
                }
            }
        });
    }
}
