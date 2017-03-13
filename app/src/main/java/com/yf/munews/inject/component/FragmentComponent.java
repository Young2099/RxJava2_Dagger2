package com.yf.munews.inject.component;

import android.app.Activity;

import com.yf.munews.inject.module.FragmentModule;
import com.yf.munews.inject.scope.FragmentScope;

import dagger.Component;

/**
 * Created by ${yf} on 2017/3/13.
 */
@FragmentScope
@Component(modules = {FragmentModule.class})
public interface FragmentComponent {

    Activity getActivity();
}
