package com.niles.base.vm;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.niles.base.activity.BaseActivity;

/**
 * Created by Niles
 * Date 2019/1/4 18:56
 * Email niulinguo@163.com
 */
public abstract class MVVMBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseViewModel viewModel = createViewModel();
        observeMessage(viewModel);
    }

    protected abstract BaseViewModel createViewModel();

    protected void observeMessage(BaseViewModel viewModel) {
        viewModel.mToastMessage.observe(this, this);
        viewModel.mDialogMessage.observe(this, this);
        viewModel.mNavigationMessage.observe(this, this);
        viewModel.mNavigationWithRcMessage.observe(this, this);
        viewModel.mFinishMessage.observe(this, this);
        viewModel.mSetResultMessage.observe(this, this);
        viewModel.mSimpleSetResultMessage.observe(this, this);
    }
}