package com.hanrx.mvpframework;


import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;


import com.hanrx.mvpframework.adapter.GirlListAdapter;
import com.hanrx.mvpframework.bean.Girl;
import com.hanrx.mvpframework.model.IGirlModel;
import com.hanrx.mvpframework.present.GirlPresentV1;
import com.hanrx.mvpframework.view.IGirlView;

import java.util.List;

/**
 * 属于视图层
 * View
 */
public class MainActivity extends BaseActivity<IGirlView, GirlPresentV1<IGirlView>> implements IGirlView {
    private ListView listView;
    private GirlPresentV1 girlPresentV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v1);
        listView= (ListView) findViewById(R.id.listview);
        mPresent.fetch();
    }

    @Override
    protected GirlPresentV1<IGirlView> createPresent() {
        return new GirlPresentV1<>(this);
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"正在拼命加载",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGrils(List<Girl> girls) {
        listView.setAdapter(new GirlListAdapter(this, girls));
    }
}
