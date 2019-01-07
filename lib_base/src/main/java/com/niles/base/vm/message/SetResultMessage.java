package com.niles.base.vm.message;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.niles.base.able.SetResultAble;
import com.niles.base.vm.model.ActivityResultModel;

/**
 * Created by Niles
 * Date 2019/1/7 10:33
 * Email niulinguo@163.com
 */
public class SetResultMessage extends SingleLiveEvent<ActivityResultModel> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final SetResultAble observer) {
        super.observe(owner, new Observer<ActivityResultModel>() {
            @Override
            public void onChanged(@Nullable ActivityResultModel activityResultModel) {
                if (activityResultModel != null) {
                    int resultCode = activityResultModel.getResultCode();
                    Intent data = activityResultModel.getData();
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
