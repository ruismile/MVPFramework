package com.hanrx.mvpframework;

import android.app.Activity;
import android.os.Bundle;

import com.hanrx.mvpframework.present.BasePresenter;

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends Activity {
    protected T mPresent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresent = createPresent();
        mPresent.attactView((V) this);
    }

    @Override
    protected void onDestroy() {
        mPresent.detach();
        super.onDestroy();
    }

    /**
     * 子类去实现具体的构建过程
     * @return
     */
    protected abstract T createPresent();
}
