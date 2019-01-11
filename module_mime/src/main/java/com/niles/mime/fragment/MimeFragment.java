package com.niles.mime.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.niles.base.vm.MVVMBaseFragment;
import com.niles.mime.R;
import com.niles.mime.adapter.MimeAdapter;
import com.niles.mime.databinding.MimeFragmentHeadLayoutBinding;
import com.niles.mime.databinding.MimeFragmentLayoutBinding;
import com.niles.mime.vm.MimeItemViewModel;
import com.niles.mime.vm.MimeViewModel;
import com.niles.router.RouterPath;
import com.niles.router.service.LoginService;

import java.util.List;

/**
 * Created by Niles
 * Date 2019/1/7 14:03
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.MimeModule.Fragment.Mime)
public class MimeFragment extends MVVMBaseFragment<MimeViewModel> {

    @Autowired(name = RouterPath.SignModule.Service.Login)
    LoginService mLoginService;

    private MimeFragmentLayoutBinding mBinding;
    private MimeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.mime_fragment_layout, container, false);
        mAdapter = new MimeAdapter(null);
        mAdapter.setHeaderView(createHeadView(inflater, container));
        mBinding.rvList.setAdapter(mAdapter);
        mViewModel.mListItemData.observe(this, new Observer<List<SectionEntity<MimeItemViewModel>>>() {
            @Override
            public void onChanged(@Nullable List<SectionEntity<MimeItemViewModel>> list) {
                mAdapter.setNewData(list);
            }
        });
        return mBinding.getRoot();
    }

    private View createHeadView(LayoutInflater inflater, @Nullable ViewGroup container) {
        MimeFragmentHeadLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.mime_fragment_head_layout, container, false);
        binding.setViewModel(mViewModel.mHeadViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding.unbind();
    }

    @Override
    protected MimeViewModel createViewModel() {
        return ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                //noinspection unchecked
                return (T) new MimeViewModel(mLoginService);
            }
        }).get(MimeViewModel.class);
    }
}
