package com.example.administrator.lianxi_zhoukao1_20180128.View.Interface;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2018/1/28.
 */

public interface ApiService {
    /**
     * Get基本请求,这里从Call改为Observable被观察者
     * @param url
     * @return
     */
    @GET
    public Observable<String> get(@Url String url);

}
