package com.niles.mime.vm;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.DrawableRes;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ItemChildClickCommand;
import com.niles.base.vm.command.ItemClickCommand;
import com.niles.mime.R;
import com.niles.mime.model.MimeItemBodyModel;
import com.niles.mime.model.MimeItemGroupModel;
import com.niles.router.RouterPath;
import com.niles.router.service.LoginService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niles
 * Date 2019/1/9 09:37
 * Email niulinguo@163.com
 */
public class MimeViewModel extends BaseViewModel {

    public final MimeHeadViewModel mHeadViewModel = new MimeHeadViewModel();
    public final MutableLiveData<List<SectionEntity<MimeItemViewModel>>> mListItemData = new MutableLiveData<>();
    public final ItemClickCommand mItemClickCommand = new ItemClickCommand() {
        @Override
        public void onItemClick(int position) {

        }
    };
    public final ItemChildClickCommand mItemChildClickCommand = new ItemChildClickCommand() {
        @Override
        public void onItemChildClick(int position, int childID) {

        }
    };
    private final LoginService mLoginService;

    public MimeViewModel(LoginService loginService) {
        mLoginService = loginService;

        init();
    }

    private void init() {

        mHeadViewModel.mUsernameText.set("张三");
        mHeadViewModel.mMobileText.set("17610822222");
        mHeadViewModel.mAvatarImageUrl.set("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547198634638&di=501a444ee861bd8ac023af93b6316333&imgtype=0&src=http%3A%2F%2Fabc.2008php.com%2F2011_Website_appreciate%2F2011-12-30%2F20111230224943.jpg");

        ArrayList<SectionEntity<MimeItemViewModel>> value = new ArrayList<>();
        value.add(createItem("支付宝会员", R.mipmap.mime_menu_00, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("商家服务", R.mipmap.mime_menu_01, false, false, RouterPath.RouterModule.Activity.Lost));

        value.add(createGroupLine(true, true));

        value.add(createItem("账单", R.mipmap.mime_menu_02, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("总资产", R.mipmap.mime_menu_03, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("余额", R.mipmap.mime_menu_04, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("花呗", R.mipmap.mime_menu_05, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("余利宝", R.mipmap.mime_menu_06, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("银行卡", R.mipmap.mime_menu_07, false, false, RouterPath.RouterModule.Activity.Lost));

        value.add(createGroupLine(true, true));

        value.add(createItem("芝麻信用", R.mipmap.mime_menu_08, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("蚂蚁保险", R.mipmap.mime_menu_09, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("蚂蚁借呗", R.mipmap.mime_menu_10, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("网商银行", R.mipmap.mime_menu_11, false, false, RouterPath.RouterModule.Activity.Lost));

        value.add(createGroupLine(true, true));

        value.add(createItem("支付宝公益", R.mipmap.mime_menu_12, false, true, RouterPath.RouterModule.Activity.Lost));
        value.add(createItem("我的客服", R.mipmap.mime_menu_13, false, false, RouterPath.RouterModule.Activity.Lost));

        value.add(createGroupLine(true, false));
        value.add(createGroupLine(false, false));

        mListItemData.setValue(value);
    }

    private MimeItemBodyModel createItem(String name, @DrawableRes int iconRes, boolean topLine, boolean bottomLine, String path) {
        MimeItemViewModel viewModel = new MimeItemViewModel(ARouter.getInstance().build(path));
        viewModel.mTopLineShow.set(topLine);
        viewModel.mNameText.set(name);
        viewModel.mMenuIconRes.set(iconRes);
        viewModel.mBottomLineShow.set(bottomLine);
        return new MimeItemBodyModel(initChildViewModel(viewModel));
    }

    private MimeItemGroupModel createGroupLine(boolean topLine, boolean bottomLine) {
        MimeItemViewModel viewModel = new MimeItemViewModel(null);
        viewModel.mTopLineShow.set(topLine);
        viewModel.mBottomLineShow.set(bottomLine);
        return new MimeItemGroupModel("", initChildViewModel(viewModel));
    }

    private void logout() {
        mLoginService.logout();

        mNavigationMessage.setValue(ARouter
                .getInstance()
                .build(RouterPath.SignModule.Activity.Login));

        mFinishMessage.setValue(null);

        mToastMessage.setValue("请重新登录");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
