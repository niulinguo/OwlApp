package com.niles.mime.vm;

import android.arch.lifecycle.MutableLiveData;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.niles.base.vm.BaseViewModel;
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
    private final LoginService mLoginService;

    public MimeViewModel(LoginService loginService) {
        mLoginService = loginService;
    }

    public void start() {

        mHeadViewModel.mUsernameText.set("张三");
        mHeadViewModel.mMobileText.set("17610822222");
        mHeadViewModel.mAvatarImageUrl.set("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547198634638&di=501a444ee861bd8ac023af93b6316333&imgtype=0&src=http%3A%2F%2Fabc.2008php.com%2F2011_Website_appreciate%2F2011-12-30%2F20111230224943.jpg");

        ArrayList<SectionEntity<MimeItemViewModel>> value = new ArrayList<>();
        value.add(createItem("支付宝会员", false, true));
        value.add(createItem("商家服务", false, false));

        value.add(createGroupLine(true, true));

        value.add(createItem("账单", false, true));
        value.add(createItem("总资产", false, true));
        value.add(createItem("余额", false, true));
        value.add(createItem("花呗", false, true));
        value.add(createItem("余利宝", false, true));
        value.add(createItem("银行卡", false, false));

        value.add(createGroupLine(true, true));

        value.add(createItem("芝麻信用", false, true));
        value.add(createItem("蚂蚁保险", false, true));
        value.add(createItem("蚂蚁借呗", false, true));
        value.add(createItem("网商银行", false, false));

        value.add(createGroupLine(true, true));

        value.add(createItem("支付宝公益", false, true));
        value.add(createItem("我的客服", false, false));

        value.add(createGroupLine(true, false));
        value.add(createGroupLine(false, false));

        mListItemData.setValue(value);
    }

    private MimeItemBodyModel createItem(String name, boolean topLine, boolean bottomLine) {
        MimeItemViewModel model = new MimeItemViewModel();
        model.mTopLineShow.set(topLine);
        model.mNameText.set(name);
        model.mBottomLineShow.set(bottomLine);
        return new MimeItemBodyModel(model);
    }

    private MimeItemGroupModel createGroupLine(boolean topLine, boolean bottomLine) {
        MimeItemViewModel model = new MimeItemViewModel();
        model.mTopLineShow.set(topLine);
        model.mBottomLineShow.set(bottomLine);
        return new MimeItemGroupModel("", model);
    }

    private void logout() {
        mLoginService.logout();

        mNavigationMessage.setValue(ARouter
                .getInstance()
                .build(RouterPath.SignModule.Activity.Login));

        mFinishMessage.setValue(null);

        mToastMessage.setValue("请重新登录");
    }
}
