package com.yf.munews.widget.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import com.yf.munews.R;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }
}
