package com.niles.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.niles.base.able.DialogAble;
import com.niles.base.able.FinishAble;
import com.niles.base.able.NavigationAble;
import com.niles.base.able.SetResultAble;
import com.niles.base.able.ToastAble;
import com.niles.separate.activity.ActivityLikeManager;
import com.niles.separate.activity.SeparateActivity;

/**
 * Created by Niles
 * Date 2018/12/29 12:19
 * Email niulinguo@163.com
 */
public abstract class BaseActivity extends SeparateActivity implements
        ToastAble,
        NavigationAble,
        DialogAble,
        FinishAble,
        SetResultAble {

    private AlertDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 强制竖屏显示
        if (isPortraitActivity()) {
            ScreenUtils.setPortrait(this);
        }
        // ARouter 注入
        ARouter.getInstance().inject(this);
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

    @Override
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new AlertDialog.Builder(this)
                    .setTitle("加载中...")
                    .setMessage("请稍后")
                    .create();
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void navigation(Postcard postcard) {
        postcard.navigation(this);
    }

    @Override
    public void navigation(Postcard postcard, int rc) {
        postcard.navigation(this, rc);
    }

    @Override
    public void toast(String message) {
        ToastUtils.showShort(message);
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void setActivityResult(int resultCode) {
        setResult(resultCode);
    }

    @Override
    public void setActivityResult(int resultCode, Intent data) {
        setResult(resultCode, data);
    }
}
