package com.hanrx.mvpframework.view;

import com.hanrx.mvpframework.bean.Girl;

import java.util.List;

public interface IGirlView {
    /**
     * ui业务逻辑，加载进度条
     */
    void showLoading();

    void showGrils(List<Girl> girls);
}
