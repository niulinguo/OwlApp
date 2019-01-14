package com.niles.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.niles.base.router.RouterParamKey;
import com.niles.base.router.RouterPath;

/**
 * Created by Niles
 * Date 2019/1/2 12:43
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.BaseModule.Fragment.Lost)
public class LostFragment extends BaseFragment {

    @Autowired(name = RouterParamKey.NAME)
    String mName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(String.format("%s丢失", mName));
        return textView;
    }
}
