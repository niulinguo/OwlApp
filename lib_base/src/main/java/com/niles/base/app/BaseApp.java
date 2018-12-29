package com.niles.base.app;

import com.niles.separate.application.ApplicationLike;
import com.niles.separate.application.ApplicationLikeManager;
import com.niles.separate.application.SeparateApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niles
 * Date 2018/12/29 11:09
 * Email niulinguo@163.com
 */
public abstract class BaseApp extends SeparateApplication {

    @Override
    protected void onRegisterApplicationLikeManager(ApplicationLikeManager likeManager) {
        super.onRegisterApplicationLikeManager(likeManager);

        ArrayList<ApplicationLike> appLikeList = new ArrayList<>();
        createAppLike(appLikeList);
        for (ApplicationLike appLike : appLikeList) {
            likeManager.register(appLike);
        }
    }

    protected abstract void createAppLike(List<ApplicationLike> appLikeList);
}
