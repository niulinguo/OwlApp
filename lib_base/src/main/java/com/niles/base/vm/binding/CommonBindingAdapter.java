package com.niles.base.vm.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.niles.base.BuildConfig;
import com.niles.base.vm.command.ClickCommand;
import com.niles.base.vm.command.RefreshCommand;

/**
 * Created by Niles
 * Date 2018/12/29 18:13
 * Email niulinguo@163.com
 */
public class CommonBindingAdapter {

    /**
     * 最后一次点击时间
     * 用于防止重复点击
     */
    private static long sLastClickTime;

    @BindingAdapter("common:onClick")
    public static void onClick(View view, final ClickCommand clickCommand) {
        view.setClickable(true);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currTime = System.currentTimeMillis();
                // 防止一秒内重复点击
                if (currTime - sLastClickTime > 1000) {
                    sLastClickTime = currTime;
                    try {
                        clickCommand.onClick();
                    } catch (Exception e) {
                        // 点击异常
                        if (BuildConfig.DEBUG) {
                            LogUtils.eTag("onClick", e);
                        }
                    }
                } else {
                    // 一秒内重复点击
                    if (BuildConfig.DEBUG) {
                        LogUtils.eTag("onClick", "重复点击");
                    }
                }
            }
        });
    }

    @BindingAdapter("common:onRefresh")
    public static void onRefresh(SwipeRefreshLayout swipeRefreshLayout, final RefreshCommand refreshCommand) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshCommand.onRefresh();
            }
        });
    }

    @BindingAdapter(value = {"common:url", "common:placeholderRes"}, requireAll = false)
    public static void url(final ImageView imageView, String url, @DrawableRes int placeholderRes) {
        if (!TextUtils.isEmpty(url)) {
            //使用Glide框架加载图片
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(new RequestOptions().placeholder(placeholderRes))
                    .into(imageView);
        }
    }
}
