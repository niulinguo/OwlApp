package com.niles.base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.able.DialogAble;
import com.niles.base.able.FinishAble;
import com.niles.base.able.NavigationAble;
import com.niles.base.able.SetResultAble;
import com.niles.base.able.ToastAble;
import com.niles.separate.fragment.FragmentLikeManager;
import com.niles.separate.fragment.SeparateFragment;

/**
 * Created by Niles
 * Date 2018/12/29 14:10
 * Email niulinguo@163.com
 */
public abstract class BaseFragment extends SeparateFragment implements
        ToastAble,
        NavigationAble,
        DialogAble,
        FinishAble,
        SetResultAble {

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

    @Override
    public void showProgressDialog() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof DialogAble) {
                ((DialogAble) activity).showProgressDialog();
            }
        }
    }

    @Override
    public void hideProgressDialog() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof DialogAble) {
                ((DialogAble) activity).hideProgressDialog();
            }
        }
    }

    @Override
    public void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override
    public void navigation(Postcard postcard) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof NavigationAble) {
                ((NavigationAble) activity).navigation(postcard);
            }
        }
    }

    @Override
    public void navigation(Postcard postcard, int rc) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof NavigationAble) {
                ((NavigationAble) activity).navigation(postcard, rc);
            }
        }
    }

    @Override
    public void setActivityResult(int resultCode) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof SetResultAble) {
                ((SetResultAble) activity).setActivityResult(resultCode);
            }
        }
    }

    @Override
    public void setActivityResult(int resultCode, Intent data) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof SetResultAble) {
                ((SetResultAble) activity).setActivityResult(resultCode, data);
            }
        }
    }

    @Override
    public void toast(String message) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity instanceof ToastAble) {
                ((ToastAble) activity).toast(message);
            }
        }
    }
}
