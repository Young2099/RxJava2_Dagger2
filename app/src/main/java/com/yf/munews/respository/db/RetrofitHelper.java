package com.yf.munews.respository.db;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.respository.http.api.NewsApi;
import com.yf.munews.utils.NetWorkUtils;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;


/**
 * Created by ${yf} on 2017/3/20.
 * 注入接口的实现类，来请求数据
 */

public class RetrofitHelper {
    private NewsApi newsApi;
    /**
     * 设置缓存有效期为2天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    /**
     * +     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * +     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     * +
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    /**
     * +     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * +     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     * +
     */
    private static final String CACHE_CONTROL_AGE = "max-age=0";


    /**
     * 根据网络状况获取缓存的策略
     *
     * @return
     */
    private String getCacheControl() {
        return NetWorkUtils.isNetWorkConnected() ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }


    public RetrofitHelper(NewsApi newsApiService) {
        this.newsApi = newsApiService;
    }

    /**
     * 请求新闻类数据
     *
     * @return
     */
    public Observable<Map<String, List<NewsSummary>>> getNewsList(String type, String id, int size) {
        return newsApi.getNewsList(getCacheControl(), type, id, size);
    }
}
