package com.niles.main;

import com.niles.base.app.BaseApp;
import com.niles.separate.application.ApplicationLike;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/12/28 17:56
 * Email niulinguo@163.com
 */
public class MyApp extends BaseApp {

    @Override
    protected void createAppLike(List<ApplicationLike> appLikeList) {
        appLikeList.add(new com.niles.base.AppLike());
        appLikeList.add(new AppLike());
    }
}
