package com.niles.mime.vm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.alibaba.android.arouter.facade.Postcard;
import com.niles.base.vm.BaseViewModel;
import com.niles.base.vm.command.ClickCommand;

/**
 * Created by Niles
 * Date 2019/1/8 15:40
 * Email niulinguo@163.com
 * <p>
 * 我的页面 - Item Menu
 *
 * @see com.niles.mime.adapter.MimeAdapter
 */
public class MimeItemViewModel extends BaseViewModel {

    public final ObservableBoolean mTopLineShow = new ObservableBoolean(false);
    public final ObservableBoolean mBottomLineShow = new ObservableBoolean(true);
    public final ObservableInt mMenuIconRes = new ObservableInt();
    public final ObservableField<String> mNameText = new ObservableField<>("");
    private final Postcard mPostcard;
    public final ClickCommand mClickCommand = new ClickCommand() {
        @Override
        public void onClick() {
            if (mPostcard != null) {
                navigation(mPostcard);
            }
        }
    };

    public MimeItemViewModel(Postcard postcard) {
        mPostcard = postcard;
    }
}
