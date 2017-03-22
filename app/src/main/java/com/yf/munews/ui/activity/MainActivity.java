package com.yf.munews.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.yf.munews.R;
import com.yf.munews.ui.activity.base.BaseActivity;
import com.yf.munews.ui.fragment.GankFragment;
import com.yf.munews.ui.fragment.ZhihuFragment;
import com.yf.munews.ui.fragment.news.NewsFragment;
import com.yf.munews.ui.view.FlodDrawerLayout;
import com.yf.munews.utils.Constants;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.drawer)
    FlodDrawerLayout mDrawerLayout;
    @BindView(R.id.navigation)
    NavigationView mNavigationView;

    @Inject
    GankFragment gankFragment;
    @Inject
    NewsFragment newsFragment;
    @Inject
    ZhihuFragment zhihuFragment;

    private int showFragment = Constants.NEWS;
    private int hideFragment = Constants.NEWS;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initDrawerLayout();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
        } else {
            getDefaultFragment();
        }
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    private void getDefaultFragment() {
        if (newsFragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.content, newsFragment).show(newsFragment).add(R.id.content, zhihuFragment).hide(zhihuFragment)
                    .hide(zhihuFragment).add(R.id.content, gankFragment).hide(gankFragment).commit();
        } else {
        }
    }


    private void initDrawerLayout() {
        setToolbar(mToolBar, "新垣结衣");
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open_drawer, R.string.close_drawer);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);
        //点击切换不同的Fragment
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.drawer_gold:
                            showFragment = Constants.NEWS;
                            break;
                        case R.id.drawer_zhihu:
                            showFragment = Constants.ZHIHU;
                            break;
                        case R.id.drawer_gank:
                            showFragment = Constants.GANK;
                            break;
                        case R.id.drawer_wechat:

                            break;
                        case R.id.drawer_vtex:

                            break;
                        case R.id.drawer_setting:

                            break;
                        case R.id.drawer_like:

                            break;
                        case R.id.drawer_about:

                            break;
                    }
                    mDrawerLayout.closeDrawers();
                    changeFragment(getShowFragment(showFragment), getShowFragment(hideFragment));
                    hideFragment = showFragment;
                    return true;
                }
            });
        }

    }

    private Fragment getShowFragment(int type) {
        switch (type) {
            case Constants.NEWS:
                return newsFragment;
            case Constants.ZHIHU:
                return zhihuFragment;
            case Constants.GANK:
                return gankFragment;

        }
        return newsFragment;
    }

    private void changeFragment(Fragment showFragment, Fragment hideFragment) {
        if (showFragment == hideFragment)
            return;
        getSupportFragmentManager().beginTransaction().show(showFragment).hide(hideFragment).commit();
//        getSupportFragmentManager().beginTransaction().hide(hideFragment).commit();
    }

}
