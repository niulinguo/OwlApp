package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.base.able.NavigationAble;
import com.niles.base.vm.model.NavigationParamWrap;

/**
 * Created by Niles
 * Date 2019/1/7 10:13
 * Email niulinguo@163.com
 */
public class NavigationWithRcMessage extends SingleLiveEvent<NavigationParamWrap> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final NavigationAble observer) {
        super.observe(owner, new Observer<NavigationParamWrap>() {
            @Override
            public void onChanged(@Nullable NavigationParamWrap navigationParamWrap) {
                if (navigationParamWrap != null) {
                    observer.navigation(navigationParamWrap.getPostcard(), navigationParamWrap.getRc());
                }
            }
        });
    }

    public void observeForever(@NonNull final NavigationAble observer) {
        super.observeForever(new Observer<NavigationParamWrap>() {
            @Override
            public void onChanged(@Nullable NavigationParamWrap navigationParamWrap) {
                if (navigationParamWrap != null) {
                    observer.navigation(navigationParamWrap.getPostcard(), navigationParamWrap.getRc());
                }
            }
        });
    }
}
