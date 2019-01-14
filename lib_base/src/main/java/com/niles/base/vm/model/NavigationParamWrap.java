package com.niles.base.vm.model;

import com.alibaba.android.arouter.facade.Postcard;

/**
 * Created by Niles
 * Date 2019/1/7 10:12
 * Email niulinguo@163.com
 */
public class NavigationParamWrap {

    private Postcard mPostcard;
    private int mRc;

    public NavigationParamWrap() {
    }

    public NavigationParamWrap(Postcard postcard, int rc) {
        mPostcard = postcard;
        mRc = rc;
    }

    public Postcard getPostcard() {
        return mPostcard;
    }

    public void setPostcard(Postcard postcard) {
        mPostcard = postcard;
    }

    public int getRc() {
        return mRc;
    }

    public void setRc(int rc) {
        mRc = rc;
    }
}
