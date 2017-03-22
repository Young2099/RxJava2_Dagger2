package com.yf.munews.respository.db;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.respository.http.api.NewsApi;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by ${yf} on 2017/3/20.
 * 注入接口的实现类，来请求数据
 */

public class RetrofitHelper {
    private NewsApi newsApi;

    public RetrofitHelper(NewsApi newsApiService) {
        this.newsApi = newsApiService;
    }

    /**
     * 请求新闻类数据
     *
     * @return
     */
    public Observable<Map<String, List<NewsSummary>>> getNewsList() {
        return newsApi.getNewsList("cache", "1", "1", 1);
    }
}
