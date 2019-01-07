package com.niles.base.able;

import android.content.Intent;

/**
 * Created by Niles
 * Date 2019/1/7 10:26
 * Email niulinguo@163.com
 */
public interface SetResultAble {

    void setActivityResult(int resultCode);

    void setActivityResult(int resultCode, Intent data);
}
