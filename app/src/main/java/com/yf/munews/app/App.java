package com.yf.munews.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.yf.munews.BuildConfig;
import com.yf.munews.inject.component.AppComponent;
import com.yf.munews.inject.component.DaggerAppComponent;
import com.yf.munews.inject.module.AppModule;
import com.yf.munews.inject.module.HttpModule;
import com.yf.munews.inject.module.PageModules;
import com.yf.munews.respository.http.api.NewsApi;
import com.yf.munews.utils.Constants;

import de.greenrobot.dao.query.QueryBuilder;
import greendao.DaoMaster;
import greendao.DaoSession;
import greendao.NewsChannelTableDao;

/**
 * Created by ${yf} on 2017/3/8.
 */

public class App extends Application {
    private static App mInstance;
    private NewsApi newsApi;
    private static DaoSession mDaoSession;

    public static AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(mInstance))
                    .httpModule(new HttpModule())
                    .pageModules(new PageModules())
                    .build();
        }
        return mAppComponent;
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        setUpDataBase();
    }

    private void setUpDataBase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
        QueryBuilder.LOG_SQL = BuildConfig.DEBUG;
        QueryBuilder.LOG_VALUES = BuildConfig.DEBUG;
    }

    public static NewsChannelTableDao getNewsChannelTableDao() {
        return mDaoSession.getNewsChannelTableDao();
    }
}
