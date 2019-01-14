package com.niles.base.vm.model;

import android.content.Intent;

/**
 * Created by Niles
 * Date 2019/1/7 10:32
 * Email niulinguo@163.com
 */
public class SetResultParamWrap {

    private int mResultCode;
    private Intent mData;

    public SetResultParamWrap() {
    }

    public SetResultParamWrap(int resultCode, Intent data) {
        mResultCode = resultCode;
        mData = data;
    }

    public int getResultCode() {
        return mResultCode;
    }

    public void setResultCode(int resultCode) {
        mResultCode = resultCode;
    }

    public Intent getData() {
        return mData;
    }

    public void setData(Intent data) {
        mData = data;
    }
}
