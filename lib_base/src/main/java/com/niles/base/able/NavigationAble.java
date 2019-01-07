package com.niles.base.able;

import com.alibaba.android.arouter.facade.Postcard;

/**
 * Created by Niles
 * Date 2019/1/4 18:59
 * Email niulinguo@163.com
 */
public interface NavigationAble {

    void navigation(Postcard postcard);

    void navigation(Postcard postcard, int rc);

}
