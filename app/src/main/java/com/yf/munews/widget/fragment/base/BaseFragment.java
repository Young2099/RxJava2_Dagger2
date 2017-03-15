package com.yf.munews.widget.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yf.munews.app.App;
import com.yf.munews.inject.component.DaggerFragmentComponent;
import com.yf.munews.inject.component.FragmentComponent;
import com.yf.munews.inject.module.FragmentModule;

import butterknife.ButterKnife;

/**
 * Created by ${yf} on 2017/3/8.
 */

public abstract class BaseFragment extends Fragment {

    public FragmentComponent mFragmentComponent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentComponent = DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())//fragment里面也可以拿到其实例
                .fragmentModule(new FragmentModule(this))
                .build();

    }

    protected View mFragmentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mFragmentView);
            initViews(mFragmentView);
        }
        initInject();
        return mFragmentView;
    }

    protected abstract void initInject();

    protected abstract void initViews(View mFragmentView);

    protected abstract int getLayoutId();
}
