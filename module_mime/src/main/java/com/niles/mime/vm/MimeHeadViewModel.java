package com.niles.mime.vm;

import android.databinding.ObservableField;

import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.router.RouterPath;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;

/**
 * Created by Niles
 * Date 2019/1/11 10:55
 * Email niulinguo@163.com
 */
public class MimeHeadViewModel extends BaseViewModel {

    public final ObservableField<String> mAvatarImageUrl = new ObservableField<>();
    public final ObservableField<String> mUsernameText = new ObservableField<>();
    public final ObservableField<String> mMobileText = new ObservableField<>();
    public final ClickCommand mClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            navigation(ARouter
                    .getInstance()
                    .build(RouterPath.MimeModule.Activity.Info));
        }
    };

}
