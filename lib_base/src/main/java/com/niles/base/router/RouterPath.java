package com.niles.base.router;

/**
 * Created by Niles
 * Date 2018/12/29 17:41
 * Email niulinguo@163.com
 * <p>
 * 路由路径管理
 */
public interface RouterPath {

    // 基础模块
    interface BaseModule {

        // Fragment 页面
        interface Fragment {

            // Fragment 404
            String Lost = "/base/fragment/lost";
        }

        // Activity 页面
        interface Activity {

            // Activity 404
            String Lost = "/base/activity/lost";

            // Fragment 容器
            String FRAGMENT_CONTAINER = "/base/activity/fragment_container";
        }
    }

    // 首页模块
    interface HomeModule {

        // Fragment 页面
        interface Fragment {

            // 首页
            String Home = "/home/fragment/home";
        }
    }

    // 工作模块
    interface WorkModule {

        // Fragment 页面
        interface Fragment {

            // 工作页
            String Work = "/work/fragment/work";
        }
    }

    // 消息模块
    interface MessageModule {

        // Fragment 页面
        interface Fragment {

            // 消息页
            String Message = "/message/fragment/message";
        }
    }

    // 我的模块
    interface MimeModule {

        // Activity 页面
        interface Activity {

            // 设置页面
            String Setting = "/mime/activity/setting";

            // 我的信息
            String Info = "/mime/activity/info";
        }

        // Fragment 页面
        interface Fragment {

            // 我的页
            String Mime = "/mime/fragment/mime";

            // 我的信息
            String Info = "/mime/fragment/info";
        }
    }

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

    // 认证模块
    interface SignModule {

        // Activity 页面
        interface Activity {

            // 登录页面
            String Login = "/sign/activity/login";

            // 注册页面
            String REGISTER = "/sign/activity/register";

            // 找回密码页面
            String FIND_PW = "/sign/activity/find_pw";

            // 用户协议页面
            String USER_PROTOCOL = "/sign/activity/user_protocol";
        }

        // 服务
        interface Service {

            // 登录服务
            String Login = "/sign/service/login";
        }
    }
}
