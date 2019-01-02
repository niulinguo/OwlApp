package com.niles.main.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.activity.BaseActivity;
import com.niles.main.R;
import com.niles.main.databinding.MainActivityMainTabBinding;
import com.niles.router.RouterParamKey;
import com.niles.router.RouterPath;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.SimpleTabItemSelectedListener;

/**
 * Created by Niles
 * Date 2019/1/2 11:56
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.MainModule.Activity.MainTab)
public class MainTabActivity extends BaseActivity {

    private final String[] mTabNames = new String[]{"首页", "工作", "消息", "我的"};
    private final List<Fragment> mFragments = new ArrayList<>();
    private MainActivityMainTabBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity_main_tab);

        initFragments();
        initTab();
    }

    private void initFragments() {
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(RouterPath.HomeModule.Fragment.Home).navigation(this);
        if (homeFragment == null) {
            homeFragment = (Fragment) ARouter.getInstance().build(RouterPath.RouterModule.Fragment.Lost).withString(RouterParamKey.Name, mTabNames[0]).navigation(this);
        }
        Fragment workFragment = (Fragment) ARouter.getInstance().build(RouterPath.WorkModule.Fragment.Work).navigation(this);
        if (workFragment == null) {
            workFragment = (Fragment) ARouter.getInstance().build(RouterPath.RouterModule.Fragment.Lost).withString(RouterParamKey.Name, mTabNames[1]).navigation(this);
        }
        Fragment messageFragment = (Fragment) ARouter.getInstance().build(RouterPath.MessageModule.Fragment.Message).navigation(this);
        if (messageFragment == null) {
            messageFragment = (Fragment) ARouter.getInstance().build(RouterPath.RouterModule.Fragment.Lost).withString(RouterParamKey.Name, mTabNames[2]).navigation(this);
        }
        Fragment mimeFragment = (Fragment) ARouter.getInstance().build(RouterPath.MimeModule.Fragment.Mime).navigation(this);
        if (mimeFragment == null) {
            mimeFragment = (Fragment) ARouter.getInstance().build(RouterPath.RouterModule.Fragment.Lost).withString(RouterParamKey.Name, mTabNames[3]).navigation(this);
        }

        mFragments.add(homeFragment);
        mFragments.add(workFragment);
        mFragments.add(messageFragment);
        mFragments.add(mimeFragment);

        // 默认选中第一个
        if (homeFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main_fragment_container, homeFragment)
                    .commitAllowingStateLoss();
        }
    }

    private void initTab() {
        NavigationController navigationController = mBinding.tabMainBottom
                .material()
                .addItem(R.mipmap.main_tab_home, mTabNames[0])
                .addItem(R.mipmap.main_tab_work, mTabNames[1])
                .addItem(R.mipmap.main_tab_message, mTabNames[2])
                .addItem(R.mipmap.main_tab_mime, mTabNames[3])
                .build();

        navigationController.addSimpleTabItemSelectedListener(new SimpleTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Fragment fragment = mFragments.get(index);
                if (fragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_main_fragment_container, fragment)
                            .commitAllowingStateLoss();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
    }
}
