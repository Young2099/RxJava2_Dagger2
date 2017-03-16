package com.yf.munews.widget.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.yf.munews.R;
import com.yf.munews.widget.fragment.GankFragment;
import com.yf.munews.widget.fragment.NewsFragment;
import com.yf.munews.widget.fragment.ZhihuFragment;
import com.yf.munews.widget.view.FlodDrawerLayout;

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
        getDefaultFragment();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    private void getDefaultFragment() {
//        if (mNewsFragment == null) {
        Log.e("TAG", "ldldldl");
//            FragmentManager manager = getSupportFragmentManager();
//            FragmentTransaction transaction = manager.beginTransaction();
//            transaction.replace(R.id.content, mNewsFragment).commit();
//        }
    }


    private void initDrawerLayout() {
        setToolbar(mToolBar, "新垣结衣");
        mDrawerLayout = (FlodDrawerLayout) findViewById(R.id.drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open_drawer, R.string.close_drawer);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);
        //对DrawerLayout实现监听

        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.drawer_zhihu:

                            break;
                        case R.id.drawer_gank:

                            break;
                        case R.id.drawer_wechat:

                            break;
                        case R.id.drawer_gold:

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
                    return false;
                }
            });
        }
    }

}
