package com.yf.munews.inject.module;

import android.util.Log;

import com.yf.munews.app.App;
import com.yf.munews.respository.db.RetrofitHelper;
import com.yf.munews.respository.http.api.NewsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${yf} on 2017/3/10.
 * 依赖注入需要提供的实体类
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
        Log.e("tag","111111");
    }

    /**
     * 提供依赖的方法
     *
     * @return
     */
    @Provides
    @Singleton
    App providerApplicationContext() {
        return application;
    }


    @Provides
    @Singleton
    RetrofitHelper providerRetrofitHelper(NewsApi newsApi){
        return  new RetrofitHelper(newsApi);
    }
}
