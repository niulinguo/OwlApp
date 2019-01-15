package com.niles.sign.service;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.niles.base.router.RouterPath;
import com.niles.base.router.service.LoginService;
import com.orhanobut.hawk.Hawk;

/**
 * Created by Niles
 * Date 2019/1/2 16:33
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.SignModule.Service.Login)
public class LoginServiceImpl implements LoginService {

    private static final String SP_KEY_SIGN_REMEMBER_PWD = "SP_KEY_SIGN_REMEMBER_PWD";
    private static final String SP_KEY_SIGN_USERNAME = "SP_KEY_SIGN_USERNAME";
    private static final String SP_KEY_SIGN_PASSWORD = "SP_KEY_SIGN_PASSWORD";
    private static final String SP_KEY_SIGN_TOKEN = "SP_KEY_SIGN_TOKEN";
    private static final String SP_KEY_SIGN_LOGIN_INFO = "SP_KEY_SIGN_LOGIN_INFO";
    private final MutableLiveData<Boolean> mLoginStatusMessage = new MutableLiveData<>();
    private boolean mRememberPwd;
    private String mUsername;
    private String mPassword;
    private String mToken;
    private String mLoginInfo;

    @Override
    public void init(Context context) {
        mRememberPwd = Hawk.get(SP_KEY_SIGN_REMEMBER_PWD, false);
        mUsername = Hawk.get(SP_KEY_SIGN_USERNAME, null);
        mPassword = Hawk.get(SP_KEY_SIGN_PASSWORD, null);
        mToken = Hawk.get(SP_KEY_SIGN_TOKEN, null);
        mLoginInfo = Hawk.get(SP_KEY_SIGN_LOGIN_INFO, null);
    }

    @Override
    public void loginByPwdSuccess(String username, boolean rememberPwd, String password, String token, String info) {
        mUsername = username;
        Hawk.put(SP_KEY_SIGN_USERNAME, username);

        mRememberPwd = rememberPwd;
        Hawk.put(SP_KEY_SIGN_REMEMBER_PWD, rememberPwd);

        mPassword = password;
        Hawk.put(SP_KEY_SIGN_PASSWORD, password);

        mToken = token;
        Hawk.put(SP_KEY_SIGN_TOKEN, token);

        mLoginInfo = info;
        Hawk.put(SP_KEY_SIGN_LOGIN_INFO, info);

        mLoginStatusMessage.setValue(true);
    }

    @Override
    public void loginBySmsSuccess(String mobile, String token, String info) {
        mUsername = mobile;
        Hawk.put(SP_KEY_SIGN_USERNAME, mobile);

        mToken = token;
        Hawk.put(SP_KEY_SIGN_TOKEN, token);

        mLoginInfo = info;
        Hawk.put(SP_KEY_SIGN_LOGIN_INFO, info);

        mLoginStatusMessage.setValue(true);
    }

    @Override
    public void logout() {
        mLoginStatusMessage.setValue(false);

        mToken = null;
        Hawk.delete(SP_KEY_SIGN_TOKEN);

        mLoginInfo = null;
        Hawk.delete(SP_KEY_SIGN_LOGIN_INFO);
    }

    @Override
    public boolean hasLogin() {
        return !TextUtils.isEmpty(mToken);
    }

    @Override
    public String getLastUsername() {
        return mUsername;
    }

    @Override
    public String getPassword(String username) {
        return mPassword;
    }

    @Override
    public String getToken() {
        return mToken;
    }

    @Override
    public String getLoginInfo() {
        return mLoginInfo;
    }

    @Override
    public boolean isRememberPwd() {
        return mRememberPwd;
    }

    @Override
    public void observeLoginStatus(@NonNull LifecycleOwner owner, @NonNull Observer<Boolean> loginStatusObserver) {
        mLoginStatusMessage.observe(owner, loginStatusObserver);
    }
}
