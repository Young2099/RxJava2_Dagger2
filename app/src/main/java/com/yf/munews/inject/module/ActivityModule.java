package com.yf.munews.inject.module;

import android.app.Activity;

import com.yf.munews.inject.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${yf} on 2017/3/10.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity providerActivity() {
        return mActivity;
    }
}
