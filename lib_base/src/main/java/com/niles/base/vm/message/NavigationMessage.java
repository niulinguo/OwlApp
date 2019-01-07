package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.niles.base.able.NavigationAble;

/**
 * Created by Niles
 * Date 2019/1/7 10:03
 * Email niulinguo@163.com
 */
public class NavigationMessage extends SingleLiveEvent<Postcard> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final NavigationAble observer) {
        super.observe(owner, new Observer<Postcard>() {
            @Override
            public void onChanged(@Nullable Postcard postcard) {
                if (postcard != null) {
                    observer.navigation(postcard);
                }
            }
        });
    }
}
