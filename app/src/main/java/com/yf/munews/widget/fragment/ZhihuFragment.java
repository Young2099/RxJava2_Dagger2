package com.yf.munews.widget.fragment;

import android.view.View;

import com.yf.munews.R;
import com.yf.munews.widget.fragment.base.BaseFragment;

/**
 * Created by ${yf} on 2017/3/14.
 */

public class ZhihuFragment extends BaseFragment {
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initViews(View mFragmentView) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu;
    }
}
