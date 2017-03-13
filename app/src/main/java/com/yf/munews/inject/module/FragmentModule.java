package com.yf.munews.inject.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.yf.munews.inject.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${yf} on 2017/3/13.
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    /**
     * 拿到Fragment的对象
     *
     * @return
     */
    @FragmentScope
    @Provides
    public Activity providerActivity() {
        return mFragment.getActivity();
    }
}
