package com.yf.munews.ui.fragment.base;

import android.app.Activity;
import android.content.Context;
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

    protected View mFragmentView;
    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }


    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }


    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(),null);
            ButterKnife.bind(this, mFragmentView);
        }
        initInject();
        initViews(mFragmentView);
        return mFragmentView;
    }

    protected abstract void initInject();

    protected abstract void initViews(View mFragmentView);

    protected abstract int getLayoutId();
}
