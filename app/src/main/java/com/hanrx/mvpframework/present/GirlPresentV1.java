package com.hanrx.mvpframework.present;

import com.hanrx.mvpframework.bean.Girl;
import com.hanrx.mvpframework.model.GirlModelImlV1;
import com.hanrx.mvpframework.model.IGirlModel;
import com.hanrx.mvpframework.view.IGirlView;

import java.util.List;

/**
 * Present层
 */
public class GirlPresentV1<T> extends BasePresenter<IGirlView>{
    //持有视图层UI接口的引用   此时的视图层 activity
    IGirlView mGirlView;

    public GirlPresentV1(IGirlView mGirlView) {
        this.mGirlView = mGirlView;
    }

    /**
     * 持有模型层Modeld的引用
     */
    IGirlModel mGirlModel = new GirlModelImlV1();

    @Override
    public void fetch() {
        mGirlView.showLoading();
        if (mGirlModel != null) {
            //参数为数据回调监听
            mGirlModel.loadGirl(new IGirlModel.GirlOnLoadListener() {
                @Override
                public void onComplete(List<Girl> girls) {
                    //回调视图层
                    mGirlView.showGrils(girls);
                }
            });
        }
    }
}
