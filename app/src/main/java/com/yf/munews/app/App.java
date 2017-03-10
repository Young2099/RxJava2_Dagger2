package com.yf.munews.app;

import android.app.Application;

import com.yf.munews.inject.component.AppComponent;

/**
 * Created by ${yf} on 2017/3/8.
 */

public class App extends Application {
    private static App mInstance;

    public static AppComponent getAppComponent() {
        if (mAppComponent == null) {
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
