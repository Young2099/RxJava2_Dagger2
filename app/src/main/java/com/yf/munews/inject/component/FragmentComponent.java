package com.yf.munews.inject.component;

import android.app.Activity;

import com.yf.munews.inject.module.FragmentModule;
import com.yf.munews.inject.scope.FragmentScope;
import com.yf.munews.ui.fragment.GankFragment;
import com.yf.munews.ui.fragment.news.NewsFragment;
import com.yf.munews.ui.fragment.ZhihuFragment;

import dagger.Component;

/**
 * Created by ${yf} on 2017/3/13.
 */
@FragmentScope
@Component(dependencies = {AppComponent.class}, modules = {FragmentModule.class})
public interface FragmentComponent {

    Activity getActivity();

    void inject(GankFragment gankFragment);

    void inject(ZhihuFragment zhihuFragment);

    void inject(NewsFragment newsFragment);

}
