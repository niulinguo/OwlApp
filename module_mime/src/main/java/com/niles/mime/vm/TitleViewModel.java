package com.niles.mime.vm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;

/**
 * Created by Niles
 * Date 2019/1/15 11:33
 * Email niulinguo@163.com
 */
public class TitleViewModel extends BaseViewModel {

    public final ObservableField<String> mTitleText = new ObservableField<>();
    public final ObservableField<String> mBackText = new ObservableField<>("返回");
    public final ClickCommand mBackClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            finish();
        }
    };
    public final ObservableBoolean mShowTitleBottomLine = new ObservableBoolean(true);
}
