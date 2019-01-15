package com.niles.mime.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.router.RouterPath;
import com.niles.base.router.RouterUtils;
import com.niles.base.vm.MVVMBaseActivity;
import com.niles.mime.R;
import com.niles.mime.databinding.MimeActivityPersonInfoBinding;
import com.niles.mime.vm.PersonInfoViewModel;

/**
 * Created by Niles
 * Date 2019/1/15 10:50
 * Email niulinguo@163.com
 * <p>
 * 我的 - 个人信息页面
 */
@Route(path = RouterPath.MimeModule.Activity.Info)
public class PersonInfoActivity extends MVVMBaseActivity<PersonInfoViewModel> {

    private MimeActivityPersonInfoBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.mime_activity_person_info);

        mBinding.includeTitle.setViewModel(mViewModel.mTitleViewModel);

        if (savedInstanceState == null) {
            Fragment fragment = RouterUtils.createFragment(ARouter.getInstance()
                    .build(RouterPath.MimeModule.Fragment.Info));

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commitAllowingStateLoss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
        mBinding = null;
    }

    @Override
    protected PersonInfoViewModel createViewModel() {
        return ViewModelProviders.of(this).get(PersonInfoViewModel.class);
    }

    @Override
    protected boolean isPortraitActivity() {
        return false;
    }
}
