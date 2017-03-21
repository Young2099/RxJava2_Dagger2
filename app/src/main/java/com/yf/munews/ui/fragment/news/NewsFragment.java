package com.yf.munews.ui.fragment.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yf.munews.R;
import com.yf.munews.ui.adapter.NewsPagerAdapter;
import com.yf.munews.ui.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${yf} on 2017/3/14.
 */

public class NewsFragment extends BaseFragment {

    String[] tabTitle = new String[]{"日报", "主题", "专栏", "热门"};
    List<Fragment> fragments = new ArrayList<Fragment>();

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    NewsPagerAdapter newsPagerAdapter;

    //注入实例
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initViews(View view) {
        fragments.add(new DailyFragment());
        fragments.add(new ThemeFragment());
        newsPagerAdapter = new NewsPagerAdapter(getChildFragmentManager(), fragments);
        mViewPager.setAdapter(newsPagerAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[1]));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText(tabTitle[0]);
        mTabLayout.getTabAt(1).setText(tabTitle[1]);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }
}
