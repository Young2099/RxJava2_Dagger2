package com.yf.munews.inject.module;

import com.yf.munews.ui.fragment.GankFragment;
import com.yf.munews.ui.fragment.NewsFragment;
import com.yf.munews.ui.fragment.ZhihuFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${yf} on 2017/3/16.
 */
@Module
public class PageModules {

    @Provides
    @Singleton
    GankFragment providerGankFragment() {
        return new GankFragment();
    }

    @Provides
    @Singleton
    NewsFragment providerNewsFragment() {
        return new NewsFragment();
    }

    @Provides
    @Singleton
    ZhihuFragment providerZhihuFragment() {
        return new ZhihuFragment();
    }
}
