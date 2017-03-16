package com.yf.munews.inject.component;

import com.yf.munews.app.App;
import com.yf.munews.inject.module.AppModule;
import com.yf.munews.inject.module.PageModules;
import com.yf.munews.widget.fragment.GankFragment;
import com.yf.munews.widget.fragment.NewsFragment;
import com.yf.munews.widget.fragment.ZhihuFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ${yf} on 2017/3/10.
 */
@Singleton
@Component(modules = {AppModule.class, PageModules.class})
public interface AppComponent {
    App getContext();

    NewsFragment getNewsFragment();
    GankFragment getGankFragment();
    ZhihuFragment getZhihuFragment();

}
