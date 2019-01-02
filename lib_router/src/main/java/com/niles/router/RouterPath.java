package com.niles.router;

/**
 * Created by Niles
 * Date 2018/12/29 17:41
 * Email niulinguo@163.com
 * <p>
 * 路由路径管理
 */
public interface RouterPath {

    // 主模块
    interface MainModule {

        // Activity 页面
        interface Activity {

            // 闪屏页
            String Splash = "/main/activity/splash";
            // 主TAB页面
            String MainTab = "/main/activity/main_tab";

        }

    }
}
