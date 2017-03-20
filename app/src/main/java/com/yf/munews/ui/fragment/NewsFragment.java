package com.yf.munews.ui.fragment;

import android.view.View;

import com.yf.munews.R;
import com.yf.munews.ui.fragment.base.BaseFragment;

/**
 * Created by ${yf} on 2017/3/14.
 */

public class NewsFragment extends BaseFragment {
    //注入实例
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initViews(View mFragmentView) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }
}
