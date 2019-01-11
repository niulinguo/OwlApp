package com.niles.mime.vm;

import android.databinding.ObservableField;

import com.niles.base.vm.BaseViewModel;

/**
 * Created by Niles
 * Date 2019/1/11 10:55
 * Email niulinguo@163.com
 */
public class MimeHeadViewModel extends BaseViewModel {

    public final ObservableField<String> mAvatarImageUrl = new ObservableField<>();
    public final ObservableField<String> mUsernameText = new ObservableField<>();
    public final ObservableField<String> mMobileText = new ObservableField<>();

}
