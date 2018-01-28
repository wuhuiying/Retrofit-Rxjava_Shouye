package com.example.administrator.lianxi_zhoukao1_20180128.Presenter;

import com.example.administrator.lianxi_zhoukao1_20180128.Model.DataDataBean;
import com.example.administrator.lianxi_zhoukao1_20180128.Model.MainModel;
import com.example.administrator.lianxi_zhoukao1_20180128.View.Interface.MainView;
import com.example.administrator.lianxi_zhoukao1_20180128.View.MainActivity;

/**
 * Created by Administrator on 2018/1/28.
 */

public class MainPresenter implements MainP{

    private  MainModel mainModel;
    MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel(this);
    }


    public void getDataUrl() {
        mainModel.getDataUrl();
    }

    @Override
    public void onSuccess(DataDataBean dataDataBean) {
        //数据交互时，为防止内存泄露，设置view层数据为空
        if (mainView!=null){
            mainView.onSuccess(dataDataBean);
        }
    }

    @Override
    public void onFailure(Exception e) {
//数据交互时，为防止内存泄露，设置view层数据为空
        if (mainView != null){
            mainView.onFailure(e);
        }
    }
}
