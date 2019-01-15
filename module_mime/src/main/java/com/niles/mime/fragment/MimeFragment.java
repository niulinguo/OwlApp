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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.niles.base.router.RouterPath;
import com.niles.base.router.service.LoginService;
import com.niles.base.vm.MVVMBaseFragment;
import com.niles.mime.R;
import com.niles.mime.adapter.MimeAdapter;
import com.niles.mime.databinding.MimeFragmentHeadLayoutBinding;
import com.niles.mime.databinding.MimeFragmentLayoutBinding;
import com.niles.mime.vm.MimeItemViewModel;
import com.niles.mime.vm.MimeViewModel;

import java.util.List;

/**
 * Created by Niles
 * Date 2019/1/7 14:03
 * Email niulinguo@163.com
 * <p>
 * 我的页面
 */
@Route(path = RouterPath.MimeModule.Fragment.Mime)
public class MimeFragment extends MVVMBaseFragment<MimeViewModel> {

    @Autowired(name = RouterPath.SignModule.Service.Login)
    LoginService mLoginService;

    private MimeFragmentLayoutBinding mBinding;
    private MimeAdapter mAdapter;
    private View mRootView;

    private static MimeAdapter createAdapter(final MimeViewModel viewModel, @NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        MimeAdapter adapter = new MimeAdapter(null);
        adapter.setHeaderView(createHeadView(viewModel, inflater, container));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                viewModel.mItemClickCommand.onItemClick(position);
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                viewModel.mItemChildClickCommand.onItemChildClick(position, view.getId());
            }
        });
        return adapter;
    }

    private static View createHeadView(MimeViewModel viewModel, LayoutInflater inflater, @Nullable ViewGroup container) {
        MimeFragmentHeadLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.mime_fragment_head_layout, container, false);
        binding.setViewModel(viewModel.mHeadViewModel);
        return binding.getRoot();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            mBinding = DataBindingUtil.bind(mRootView);
            return mRootView;
        }

        mBinding = DataBindingUtil.inflate(inflater, R.layout.mime_fragment_layout, container, false);
        mBinding.includeTitle.setViewModel(mViewModel.mTitleViewModel);

        mAdapter = createAdapter(mViewModel, inflater, container);
        mBinding.rvList.setAdapter(mAdapter);

        mViewModel.mListItemData.observe(this, new Observer<List<SectionEntity<MimeItemViewModel>>>() {
            @Override
            public void onChanged(@Nullable List<SectionEntity<MimeItemViewModel>> list) {
                mAdapter.setNewData(list);
            }
        });

        return mRootView = mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding.unbind();
        mBinding = null;
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
