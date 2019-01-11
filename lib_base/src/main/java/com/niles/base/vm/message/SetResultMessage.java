package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.base.able.SetResultAble;
import com.niles.base.vm.model.SetResultParamWrap;

/**
 * Created by Niles
 * Date 2019/1/7 10:33
 * Email niulinguo@163.com
 */
public class SetResultMessage extends SingleLiveEvent<SetResultParamWrap> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final SetResultAble observer) {
        super.observe(owner, new Observer<SetResultParamWrap>() {
            @Override
            public void onChanged(@Nullable SetResultParamWrap setResultParamWrap) {
                if (setResultParamWrap != null) {
                    int resultCode = setResultParamWrap.getResultCode();
                    Intent data = setResultParamWrap.getData();
                    if (data == null) {
                        observer.setActivityResult(resultCode);
                    } else {
                        observer.setActivityResult(resultCode, data);
                    }
                }
            }
        });
    }
}
