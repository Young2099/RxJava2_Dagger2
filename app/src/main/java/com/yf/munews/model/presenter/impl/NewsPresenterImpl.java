package com.yf.munews.model.presenter.impl;

import android.support.annotation.NonNull;

import com.yf.munews.model.callback.RequestCallBack;
import com.yf.munews.model.controller.impl.NewsControllerImpl;
import com.yf.munews.model.presenter.news.NewsPresenter;
import com.yf.munews.model.view.BaseView;
import com.yf.munews.model.view.news.NewsView;

import javax.inject.Inject;

import greendao.NewsChannelTable;

/**
 * Created by ${yf} on 2017/3/27.
 */

public class NewsPresenterImpl implements NewsPresenter,RequestCallBack<NewsChannelTable>{

    private NewsView mView;
    private NewsControllerImpl newsController;

    @Inject
    public NewsPresenterImpl(NewsControllerImpl newsController) {
        this.newsController = newsController;
    }

    @Override
    public void onCreate() {
        loadNewsChannel();
    }

    /**
     * 加载初始化数据
     */
    private void loadNewsChannel() {
        newsController.loadChannelData(this);
    }

    @Override
    public void attachView(@NonNull BaseView view) {
        this.mView = (NewsView) view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onFailure(String errorMessage) {

    }

    @Override
    public void onSuccess(NewsChannelTable newsChannelTable) {

    }
}
