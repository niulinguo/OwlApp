package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.base.able.NavigationAble;
import com.niles.base.vm.model.PostcardWrapModel;

/**
 * Created by Niles
 * Date 2019/1/7 10:13
 * Email niulinguo@163.com
 */
public class NavigationWithRcMessage extends SingleLiveEvent<PostcardWrapModel> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final NavigationAble observer) {
        super.observe(owner, new Observer<PostcardWrapModel>() {
            @Override
            public void onChanged(@Nullable PostcardWrapModel postcardWrapModel) {
                if (postcardWrapModel != null) {
                    observer.navigation(postcardWrapModel.getPostcard(), postcardWrapModel.getRc());
                }
            }
        });
    }
}
