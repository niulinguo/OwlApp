package com.niles.base.vm;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
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

        if (mViewModel == null) {
            mViewModel = createViewModel();
        }

        /*
        1、initViewModel() 方法必须在 Lifecycle.Event.ON_CREATE 之后调用才起作用(看 observe 源码)
        2、在 onCreate 方法执行完毕之后，Lifecycle.Event.ON_CREATE 才会被调用
        3、onCreate 时获取的状态为 INITIALIZED 或者 DESTROYED
         */
        getLifecycle().addObserver(new GenericLifecycleObserver() {
            @Override
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_CREATE) {
                    getLifecycle().removeObserver(this);

                    initViewModel(mViewModel);
                }
            }
        });
    }

    protected abstract VM createViewModel();

    protected void initViewModel(final VM viewModel) {
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
