package com.niles.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.separate.fragment.FragmentLikeManager;
import com.niles.separate.fragment.SeparateFragment;

/**
 * Created by Niles
 * Date 2018/12/29 14:10
 * Email niulinguo@163.com
 */
public abstract class BaseFragment extends SeparateFragment {

    @Override
    protected void onRegisterFragmentLike(FragmentLikeManager likeManager) {
        super.onRegisterFragmentLike(likeManager);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ARouter 注入
        ARouter.getInstance().inject(this);
    }
}
