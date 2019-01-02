package com.niles.router;

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

/**
 * Created by Niles
 * Date 2019/1/2 12:43
 * Email niulinguo@163.com
 */
@Route(path = RouterPath.RouterModule.Fragment.Lost)
public class LostFragment extends BaseFragment {

    @Autowired(name = RouterParamKey.Name)
    String mName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(String.format("%s丢失", mName));
        return textView;
    }
}
