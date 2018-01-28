package com.example.administrator.lianxi_zhoukao1_20180128.Presenter;

import com.example.administrator.lianxi_zhoukao1_20180128.Model.DataDataBean;

/**
 * Created by Administrator on 2018/1/28.
 */

public interface MainP {
     void onSuccess(DataDataBean dataDataBean);
     void onFailure(Exception  e);
}
