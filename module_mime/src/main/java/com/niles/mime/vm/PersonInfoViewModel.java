package com.niles.mime.vm;

import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;

/**
 * Created by Niles
 * Date 2019/1/15 10:50
 * Email niulinguo@163.com
 */
public class PersonInfoViewModel extends BaseViewModel {

    public final TitleViewModel mTitleViewModel;

    /**
     * 个人主页 - 点击监听
     */
    public final ClickCommand mPersonPageClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    /**
     * 身份认证 - 点击监听
     */
    public final ClickCommand mIdentifySignClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    /**
     * 我的二维码 - 点击监听
     */
    public final ClickCommand mMimeQCodeClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    /**
     * 淘宝会员名 - 点击监听
     */
    public final ClickCommand mUsernameClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    /**
     * 我的收货地址 - 点击监听
     */
    public final ClickCommand mAddressClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    /**
     * 我的发票抬头 - 点击监听
     */
    public final ClickCommand mInvoiceClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    /**
     * 邀请有礼 - 点击监听
     */
    public final ClickCommand mInviteClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    /**
     * 我的收藏 - 点击监听
     */
    public final ClickCommand mCollectClickCommand = new ClickCommand() {
        @Override
        public void onClick() {

        }
    };

    public PersonInfoViewModel() {
        mTitleViewModel = initChildViewModel(new TitleViewModel());

        mTitleViewModel.mTitleText.set("个人信息");
        mTitleViewModel.mBackText.set("我的");
        mTitleViewModel.mShowTitleBottomLine.set(true);
    }
}
