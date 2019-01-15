package com.niles.mime.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.niles.base.router.RouterPath;
import com.niles.base.vm.MVVMBaseFragment;
import com.niles.mime.R;
import com.niles.mime.databinding.MimeFragmentPersonInfoBinding;
import com.niles.mime.vm.PersonInfoViewModel;

/**
 * Created by Niles
 * Date 2019/1/15 10:52
 * Email niulinguo@163.com
 * <p>
 * 我的 - 个人信息页面
 */
@Route(path = RouterPath.MimeModule.Fragment.Info)
public class PersonInfoFragment extends MVVMBaseFragment<PersonInfoViewModel> {

    private MimeFragmentPersonInfoBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.mime_fragment_person_info, container, false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding.unbind();
        mBinding = null;
    }

    @Override
    protected PersonInfoViewModel createViewModel() {
        FragmentActivity activity = getActivity();
        ViewModelProvider viewModelProvider;
        if (activity != null) {
            viewModelProvider = ViewModelProviders.of(activity);
        } else {
            viewModelProvider = ViewModelProviders.of(this);
        }
        return viewModelProvider.get(PersonInfoViewModel.class);
    }
}
