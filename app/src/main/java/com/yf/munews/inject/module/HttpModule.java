package com.yf.munews.inject.module;

import com.yf.munews.BuildConfig;
import com.yf.munews.inject.qualifier.GankUrl;
import com.yf.munews.inject.qualifier.NewsUrl;
import com.yf.munews.inject.qualifier.ZhihuUrl;
import com.yf.munews.respository.http.api.GankApi;
import com.yf.munews.respository.http.api.NewsApi;
import com.yf.munews.respository.http.api.ZhihuApi;
import com.yf.munews.utils.FileUtils;
import com.yf.munews.utils.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ${yf} on 2017/3/20.
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    @ZhihuUrl
    Retrofit providerZhihu(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ZhihuApi.HOST);
    }

    @Singleton
    @Provides
    @NewsUrl
    Retrofit providerNews(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, NewsApi.HOST);
    }

    @Singleton
    @Provides
    @GankUrl
    Retrofit providerGank(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, GankApi.HOST);
    }

    /**
     * 创建builder的单例模式很
     *
     * @param builder
     * @return
     */
    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        //debug模式下的log
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        //配置缓存的路径
        File cacheFile = new File(FileUtils.getCacheFile() + "/NetCache");
        //设置缓存的大小
        final Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        //设置拦截头
        Interceptor cachInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetWorkUtils.isNetWorkConnected()) {
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetWorkUtils.isNetWorkConnected()) {
                    int maxAge = 0;
                    //有网络，不缓存，最大保存时常为0
                    response.newBuilder().header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    //无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        //设置缓存
        builder.addNetworkInterceptor(cachInterceptor);
        builder.addInterceptor(cachInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    /**
     * 将适配的请求的地址加入retrofit里面去
     *
     * @param retrofit
     * @return
     */
    @Singleton
    @Provides
    ZhihuApi provideZhihuService(@ZhihuUrl Retrofit retrofit) {
        return retrofit.create(ZhihuApi.class);
    }

    @Singleton
    @Provides
    NewsApi providerNewsApi(@NewsUrl Retrofit retrofit) {
        return retrofit.create(NewsApi.class);
    }

    @Singleton
    @Provides
    GankApi providerGankApi(@GankUrl Retrofit retrofit) {
        return retrofit.create(GankApi.class);
    }


    /**
     * 创建Retrofit的适配器
     *
     * @param builder
     * @param client
     * @param url
     * @return
     */
    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
