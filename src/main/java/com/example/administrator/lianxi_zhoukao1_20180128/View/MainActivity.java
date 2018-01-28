package com.example.administrator.lianxi_zhoukao1_20180128.View;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.lianxi_zhoukao1_20180128.Model.DataDataBean;
import com.example.administrator.lianxi_zhoukao1_20180128.Presenter.MainPresenter;
import com.example.administrator.lianxi_zhoukao1_20180128.R;
import com.example.administrator.lianxi_zhoukao1_20180128.View.Interface.MainView;
import com.example.administrator.lianxi_zhoukao1_20180128.View.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity  implements MainView {


    private RecyclerView main_recycleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {

        main_recycleListView = (RecyclerView) findViewById(R.id.main_recycleListView);
        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.getDataUrl();
    }

    @Override
    public void onSuccess(final DataDataBean dataDataBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DataDataBean.DataBean data = dataDataBean.getData();
                //设置布局管理器以及布局适配器
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                MyAdapter  adapter = new MyAdapter(data,MainActivity.this);
                main_recycleListView.setLayoutManager(manager);
                main_recycleListView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onFailure(Exception e) {
        System.out.println("数据出错：" + e);
    }
}
