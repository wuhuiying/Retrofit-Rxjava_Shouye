package com.example.administrator.lianxi_zhoukao1_20180128.Model;

import android.util.Log;

import com.example.administrator.lianxi_zhoukao1_20180128.Presenter.MainP;
import com.example.administrator.lianxi_zhoukao1_20180128.Presenter.MainPresenter;
import com.example.administrator.lianxi_zhoukao1_20180128.Util.RetrofitHelper;
import com.example.administrator.lianxi_zhoukao1_20180128.Util.UtilApi;
import com.google.gson.Gson;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/28.
 */

public class MainModel {
   MainP mainP;

    public MainModel(MainP mainP) {
        this.mainP = mainP;
    }

    public void getDataUrl() {
        RetrofitHelper.getApiService(UtilApi.USER_A).get(UtilApi.USER_B)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                   mainP.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(String s) {
                        Gson gson = new Gson();
                        DataDataBean dataDataBean = gson.fromJson(s, DataDataBean.class);
                        mainP.onSuccess(dataDataBean);
                    }
                });
    }
}
