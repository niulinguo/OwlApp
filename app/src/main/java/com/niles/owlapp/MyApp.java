package com.niles.owlapp;

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
        appLikeList.add(new com.niles.router.AppLike());
        appLikeList.add(new com.niles.home.AppLike());
        appLikeList.add(new com.niles.main.AppLike());
        appLikeList.add(new com.niles.message.AppLike());
        appLikeList.add(new com.niles.mime.AppLike());
        appLikeList.add(new com.niles.sign.AppLike());
        appLikeList.add(new com.niles.work.AppLike());
    }
}
