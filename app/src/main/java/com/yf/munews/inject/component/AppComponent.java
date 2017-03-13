package com.yf.munews.inject.component;

import com.yf.munews.app.App;
import com.yf.munews.inject.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ${yf} on 2017/3/10.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    App getContext();
}