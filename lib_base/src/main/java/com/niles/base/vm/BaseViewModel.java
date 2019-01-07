package com.niles.base.vm;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.niles.base.vm.message.DialogMessage;
import com.niles.base.vm.message.FinishMessage;
import com.niles.base.vm.message.NavigationMessage;
import com.niles.base.vm.message.NavigationWithRcMessage;
import com.niles.base.vm.message.SetResultMessage;
import com.niles.base.vm.message.SimpleSetResultMessage;
import com.niles.base.vm.message.ToastMessage;

/**
 * Created by Niles
 * Date 2019/1/4 19:06
 * Email niulinguo@163.com
 */
public class BaseViewModel extends ViewModel {

    public static final int RESULT_OK = Activity.RESULT_OK;
    public static final int RESULT_CANCELED = Activity.RESULT_CANCELED;
    public static final int RESULT_FIRST_USER = Activity.RESULT_FIRST_USER;

    public final ToastMessage mToastMessage = new ToastMessage();
    public final DialogMessage mDialogMessage = new DialogMessage();
    public final NavigationMessage mNavigationMessage = new NavigationMessage();
    public final NavigationWithRcMessage mNavigationWithRcMessage = new NavigationWithRcMessage();
    public final FinishMessage mFinishMessage = new FinishMessage();
    public final SetResultMessage mSetResultMessage = new SetResultMessage();
    public final SimpleSetResultMessage mSimpleSetResultMessage = new SimpleSetResultMessage();

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    }
}
