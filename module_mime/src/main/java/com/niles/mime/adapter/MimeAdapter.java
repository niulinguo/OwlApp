package com.niles.mime.adapter;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.niles.mime.R;
import com.niles.mime.databinding.MimeItemMimeBodyLayoutBinding;
import com.niles.mime.databinding.MimeItemMimeGroupLayoutBinding;
import com.niles.mime.vm.MimeItemViewModel;

import java.util.List;

/**
 * Created by Niles
 * Date 2019/1/8 15:04
 * Email niulinguo@163.com
 */
public class MimeAdapter extends BaseSectionQuickAdapter<SectionEntity<MimeItemViewModel>, BaseViewHolder> {
    public MimeAdapter(List<SectionEntity<MimeItemViewModel>> dataList) {
        super(R.layout.mime_item_mime_body_layout, R.layout.mime_item_mime_group_layout, dataList);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SectionEntity<MimeItemViewModel> item) {
        MimeItemMimeGroupLayoutBinding binding = DataBindingUtil.getBinding(helper.itemView);
        assert binding != null;
        binding.setViewModel(item.t);
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        return DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false).getRoot();
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionEntity<MimeItemViewModel> item) {
        MimeItemMimeBodyLayoutBinding binding = DataBindingUtil.getBinding(helper.itemView);
        assert binding != null;
        binding.setViewModel(item.t);
    }
}
