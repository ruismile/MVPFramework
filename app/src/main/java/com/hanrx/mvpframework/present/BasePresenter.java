package com.hanrx.mvpframework.present;

import java.lang.ref.WeakReference;

/**
 *
 * @param <T> 对应着Activity的UI抽象接口， View视图
 */
public abstract class BasePresenter<T> {
    //持有UI接口的弱引用
    protected WeakReference<T> mViewRef;
    /**
     * 获取数据方法
     */
    public abstract void fetch();

    public void attactView(T view) {
        mViewRef = new WeakReference<T>(view);
    }
    public void detach() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
