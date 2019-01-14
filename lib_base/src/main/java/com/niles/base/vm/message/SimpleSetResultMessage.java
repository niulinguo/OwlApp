package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.base.able.SetResultAble;

/**
 * Created by Niles
 * Date 2019/1/7 10:36
 * Email niulinguo@163.com
 */
public class SimpleSetResultMessage extends SingleLiveEvent<Integer> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final SetResultAble observer) {
        super.observe(owner, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer resultCode) {
                if (resultCode != null) {
                    observer.setActivityResult(resultCode);
                }
            }
        });
    }

    public void observeForever(@NonNull final SetResultAble observer) {
        super.observeForever(new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer resultCode) {
                if (resultCode != null) {
                    observer.setActivityResult(resultCode);
                }
            }
        });
    }
}
