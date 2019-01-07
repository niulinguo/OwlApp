package com.niles.router.service;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by Niles
 * Date 2019/1/2 16:38
 * Email niulinguo@163.com
 */
public interface LoginService extends IProvider {

    /**
     * 用户名密码登录成功
     *
     * @param username    用户名
     * @param rememberPwd 是否记住密码
     * @param password    密码
     * @param token       Token
     * @param info        登录信息
     */
    void loginByPwdSuccess(String username, boolean rememberPwd, String password, String token, String info);

    /**
     * 手机验证码登录成功
     *
     * @param mobile 手机号
     * @param token  Token
     * @param info   登录信息
     */
    void loginBySmsSuccess(String mobile, String token, String info);

    /**
     * 退出登录，清空登录信息
     */
    void logout();

    /**
     * 是否登录
     *
     * @return 是否登录
     */
    boolean hasLogin();

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    String getLastUsername();

    /**
     * 获取密码
     *
     * @param username 用户名
     * @return 密码
     */
    String getPassword(String username);

    /**
     * 获取 Token
     *
     * @return Token
     */
    String getToken();

    /**
     * 获取登录信息
     *
     * @return 登录信息
     */
    String getLoginInfo();

    /**
     * 是否记住密码
     *
     * @return 是否记住密码
     */
    boolean isRememberPwd();

    /**
     * 监听登录状态
     *
     * @param owner               生命周期
     * @param loginStatusObserver 监听器
     */
    void observeLoginStatus(@NonNull LifecycleOwner owner, @NonNull Observer<Boolean> loginStatusObserver);
}
