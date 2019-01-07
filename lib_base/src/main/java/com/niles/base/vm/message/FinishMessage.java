package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.base.able.FinishAble;

/**
 * Created by Niles
 * Date 2019/1/7 10:35
 * Email niulinguo@163.com
 */
public class FinishMessage extends SingleLiveEvent<Void> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final FinishAble observer) {
        super.observe(owner, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                observer.finish();
            }
        });
    }
}
