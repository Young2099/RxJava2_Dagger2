package com.yf.munews.app;

import android.app.Application;

import com.yf.munews.inject.component.AppComponent;
import com.yf.munews.inject.component.DaggerAppComponent;
import com.yf.munews.inject.module.AppModule;

/**
 * Created by ${yf} on 2017/3/8.
 */

public class App extends Application {
    private static App mInstance;

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return mAppComponent;
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}