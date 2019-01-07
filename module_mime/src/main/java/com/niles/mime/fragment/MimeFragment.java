package com.niles.mime.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.niles.base.fragment.BaseFragment;
import com.niles.router.RouterPath;
import com.niles.router.service.LoginService;

/**
 * Created by Niles
 * Date 2019/1/7 14:03
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.MimeModule.Fragment.Mime)
public class MimeFragment extends BaseFragment {

    @Autowired(name = RouterPath.SignModule.Service.Login)
    LoginService mLoginService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        if (mLoginService.hasLogin()) {
            String lastUsername = mLoginService.getLastUsername();
            textView.setText(String.format("%s已登录", lastUsername));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logout();
                }
            });
        } else {
            textView.setText(String.valueOf("未登录"));
        }
        return textView;
    }

    private void logout() {
        mLoginService.logout();

        navigation(ARouter
                .getInstance()
                .build(RouterPath.SignModule.Activity.Login));

        finish();

        toast("请重新登录");
    }
}
