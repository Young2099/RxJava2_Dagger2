package com.yf.munews.widget.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.yf.munews.R;
import com.yf.munews.widget.view.FlodDrawerLayout;

import butterknife.ButterKnife;

/**
 * Created by ${yf} on 2017/3/8.
 */

public abstract class BaseActivity extends AppCompatActivity {


    FlodDrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    private Toolbar toolbar;

    protected abstract int getLayoutId();


    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(getLayoutId());
        initToolBar();
        initView();
        initDrawerLayout();
        initStatus();
    }

    private void initStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                //将侧边栏顶部延伸至status bar
                mDrawerLayout.setFitsSystemWindows(true);
                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
                mDrawerLayout.setClipToPadding(true);
            }
        }
    }

    private void initDrawerLayout() {
        mDrawerLayout = (FlodDrawerLayout) findViewById(R.id.drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);
        //对DrawerLayout实现监听
        //// TODO: 2017/3/10  针对Drawer左侧的点击事件的响应
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
        //针对DrawerLayout点击之后做出的关闭
        mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        });

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("替换");
        setSupportActionBar(toolbar);

    }
}
