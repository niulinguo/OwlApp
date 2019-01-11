package com.niles.mime.vm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.niles.base.vm.BaseViewModel;

/**
 * Created by Niles
 * Date 2019/1/8 15:40
 * Email niulinguo@163.com
 */
public class MimeItemViewModel extends BaseViewModel {

    public final ObservableBoolean mTopLineShow = new ObservableBoolean(false);
    public final ObservableBoolean mBottomLineShow = new ObservableBoolean(true);
    public final ObservableField<String> mNameText = new ObservableField<>("");

}
