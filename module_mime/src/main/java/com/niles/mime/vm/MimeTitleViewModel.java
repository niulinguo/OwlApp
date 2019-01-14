package com.niles.mime.vm;

import android.databinding.ObservableField;

import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.router.RouterPath;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;

/**
 * Created by Niles
 * Date 2019/1/14 14:59
 * Email niulinguo@163.com
 */
public class MimeTitleViewModel extends BaseViewModel {

    public final ObservableField<String> mTitleText = new ObservableField<>("我的");
    public final ObservableField<String> mSettingText = new ObservableField<>("设置");
    public final ClickCommand mSettingClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            navigation(ARouter
                    .getInstance()
                    .build(RouterPath.MimeModule.Activity.Setting));
        }
    };

}
