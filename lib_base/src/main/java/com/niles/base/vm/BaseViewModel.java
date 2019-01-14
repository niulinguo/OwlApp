package com.niles.base.vm;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.niles.base.able.DialogAble;
import com.niles.base.able.FinishAble;
import com.niles.base.able.NavigationAble;
import com.niles.base.able.SetResultAble;
import com.niles.base.able.ToastAble;
import com.niles.base.vm.message.DialogMessage;
import com.niles.base.vm.message.FinishMessage;
import com.niles.base.vm.message.NavigationMessage;
import com.niles.base.vm.message.NavigationWithRcMessage;
import com.niles.base.vm.message.SetResultMessage;
import com.niles.base.vm.message.SimpleSetResultMessage;
import com.niles.base.vm.message.ToastMessage;
import com.niles.base.vm.model.NavigationParamWrap;
import com.niles.base.vm.model.SetResultParamWrap;

/**
 * Created by Niles
 * Date 2019/1/4 19:06
 * Email niulinguo@163.com
 */
public class BaseViewModel extends ViewModel implements
        ToastAble,
        DialogAble,
        NavigationAble,
        FinishAble,
        SetResultAble {

    public static final int RESULT_OK = Activity.RESULT_OK;
    public static final int RESULT_CANCELED = Activity.RESULT_CANCELED;
    public static final int RESULT_FIRST_USER = Activity.RESULT_FIRST_USER;

    public final ToastMessage mToastMessage = new ToastMessage();
    public final DialogMessage mDialogMessage = new DialogMessage();
    public final NavigationMessage mNavigationMessage = new NavigationMessage();
    public final NavigationWithRcMessage mNavigationWithRcMessage = new NavigationWithRcMessage();
    public final FinishMessage mFinishMessage = new FinishMessage();
    public final SetResultMessage mSetResultMessage = new SetResultMessage();
    public final SimpleSetResultMessage mSimpleSetResultMessage = new SimpleSetResultMessage();

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    }

    protected <T extends BaseViewModel> T initChildViewModel(T childViewModel) {
        childViewModel.mToastMessage.observeForever(this);
        childViewModel.mDialogMessage.observeForever(this);
        childViewModel.mNavigationMessage.observeForever(this);
        childViewModel.mNavigationWithRcMessage.observeForever(this);
        childViewModel.mFinishMessage.observeForever(this);
        childViewModel.mSetResultMessage.observeForever(this);
        childViewModel.mSimpleSetResultMessage.observeForever(this);
        return childViewModel;
    }

    @Override
    public void toast(String message) {
        mToastMessage.setValue(message);
    }

    @Override
    public void showProgressDialog() {
        mDialogMessage.setValue(true);
    }

    @Override
    public void hideProgressDialog() {
        mDialogMessage.setValue(false);
    }

    @Override
    public void navigation(Postcard postcard) {
        mNavigationMessage.setValue(postcard);
    }

    @Override
    public void navigation(Postcard postcard, int rc) {
        mNavigationWithRcMessage.setValue(new NavigationParamWrap(postcard, rc));
    }

    @Override
    public void finish() {
        mFinishMessage.setValue(null);
    }

    @Override
    public void setActivityResult(int resultCode) {
        mSimpleSetResultMessage.setValue(resultCode);
    }

    @Override
    public void setActivityResult(int resultCode, Intent data) {
        mSetResultMessage.setValue(new SetResultParamWrap());
    }
}
