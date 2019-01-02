package com.niles.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ScreenUtils;
import com.niles.separate.activity.ActivityLikeManager;
import com.niles.separate.activity.SeparateActivity;

/**
 * Created by Niles
 * Date 2018/12/29 12:19
 * Email niulinguo@163.com
 */
public abstract class BaseActivity extends SeparateActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 强制竖屏显示
        if (isPortraitActivity()) {
            ScreenUtils.setPortrait(this);
        }
    }

    @Override
    protected void onRegisterActivityLikeManager(ActivityLikeManager likeManager) {
        super.onRegisterActivityLikeManager(likeManager);

    }

    /**
     * 是否强制竖屏
     */
    protected boolean isPortraitActivity() {
        return true;
    }
}
