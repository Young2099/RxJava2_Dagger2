package com.yf.munews.ui.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.yf.munews.app.App;
import com.yf.munews.inject.component.ActivityComponent;
import com.yf.munews.inject.component.DaggerActivityComponent;
import com.yf.munews.inject.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by ${yf} on 2017/3/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    Activity activity;

    protected abstract int getLayoutId();


    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initStatus();
        initInject();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected abstract void initInject();

    private void initStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public void setToolbar(Toolbar mToolBar, String title) {
        mToolBar.setTitle(title);
        setSupportActionBar(mToolBar);
    }

}
