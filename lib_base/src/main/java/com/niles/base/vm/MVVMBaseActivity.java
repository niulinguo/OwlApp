package com.niles.base.vm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.niles.base.activity.BaseActivity;

/**
 * Created by Niles
 * Date 2019/1/4 18:56
 * Email niulinguo@163.com
 */
public abstract class MVVMBaseActivity<VM extends BaseViewModel> extends BaseActivity {

    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = createViewModel();
        initViewModel(mViewModel);
    }

    protected abstract VM createViewModel();

    protected void initViewModel(BaseViewModel viewModel) {
        viewModel.mToastMessage.observe(this, this);
        viewModel.mDialogMessage.observe(this, this);
        viewModel.mNavigationMessage.observe(this, this);
        viewModel.mNavigationWithRcMessage.observe(this, this);
        viewModel.mFinishMessage.observe(this, this);
        viewModel.mSetResultMessage.observe(this, this);
        viewModel.mSimpleSetResultMessage.observe(this, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }
}