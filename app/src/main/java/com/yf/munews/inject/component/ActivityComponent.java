package com.yf.munews.inject.component;

import android.app.Activity;

import com.yf.munews.inject.module.ActivityModule;
import com.yf.munews.inject.scope.ActivityScope;

import dagger.Component;

/**
 * Created by ${yf} on 2017/3/14.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity getActivity();
}
