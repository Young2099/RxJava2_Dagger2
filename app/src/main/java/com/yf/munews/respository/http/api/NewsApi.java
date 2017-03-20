package com.yf.munews.respository.http.api;

import com.yf.munews.model.bean.NewsSummary;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${yf} on 2017/3/20.
 */

public interface NewsApi {
    String HOST = "http://c.m.163.com/";


    /**
     * 来之网易新闻详情
     *
     * @param cacheControl
     * @param type
     * @param id
     * @param startPage
     * @return
     */
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsSummary>>> getNewsList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type,
            @Path("id") String id,
            @Path("startPage") int startPage
    );
}
