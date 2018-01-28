package com.example.administrator.lianxi_zhoukao1_20180128.Util;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2018/1/28.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //1.  用于全局配置初始化Fresco 图片加载
        Fresco.initialize(this);
    }
}
