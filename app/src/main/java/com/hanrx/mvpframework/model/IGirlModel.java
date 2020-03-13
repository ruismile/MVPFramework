package com.hanrx.mvpframework.model;

import com.hanrx.mvpframework.bean.Girl;

import java.util.List;

/**
 * 监听数据返回
 */
public interface IGirlModel {
    void loadGirl(GirlOnLoadListener girlOnLoadlitener);
    interface GirlOnLoadListener {
        void onComplete(List<Girl> girls);
    }
}
