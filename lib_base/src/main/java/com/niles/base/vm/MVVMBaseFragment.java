package com.niles.base.vm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.niles.base.fragment.BaseFragment;

/**
 * Created by Niles
 * Date 2019/1/9 09:32
 * Email niulinguo@163.com
 */
public abstract class MVVMBaseFragment<VM extends BaseViewModel> extends BaseFragment {

    protected VM mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }
}
