package com.niles.mime.model;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.niles.mime.vm.MimeItemViewModel;

/**
 * Created by Niles
 * Date 2019/1/9 13:44
 * Email niulinguo@163.com
 */
public class MimeItemGroupModel extends SectionEntity<MimeItemViewModel> {

    public MimeItemGroupModel(String header, MimeItemViewModel mimeItemViewModel) {
        super(true, header);
        t = mimeItemViewModel;
    }
}
