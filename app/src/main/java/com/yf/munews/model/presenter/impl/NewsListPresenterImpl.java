package com.yf.munews.model.presenter.impl;

import android.support.annotation.NonNull;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.callback.RequestCallBack;
import com.yf.munews.model.controller.impl.NewsListControllerImpl;
import com.yf.munews.model.presenter.news.NewsListPresenter;
import com.yf.munews.model.view.BaseView;
import com.yf.munews.model.view.news.NewsListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by ${yf} on 2017/3/22.
 */

public class NewsListPresenterImpl implements NewsListPresenter, RequestCallBack<List<NewsSummary>> {
    private NewsListView mView;
    private Disposable disposable;
    private String channelType;
    private String channelId;
    private int startPage = 20;
    private NewsListControllerImpl newsController;

    @Inject
    public NewsListPresenterImpl(NewsListControllerImpl newsController) {
        this.newsController = newsController;
    }

    @Override
    public void onCreate() {
        if (mView != null) {
            loadNewsData();
        }
    }

    /**
     * 获取数据方法
     */
    private void loadNewsData() {
       disposable = newsController.getNewsData(channelType, channelId, startPage, this);
    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (NewsListView) view;
    }

    @Override
    public void onDestroy() {
        if(!disposable.isDisposed() && disposable != null){
            disposable.dispose();
        }
    }


    @Override
    public void onFailure(String localizedMessage) {

    }

    @Override
    public void onSuccess(List<NewsSummary> newsSummaries) {

    }

    @Override
    public void onItemClicked(String channelType, String channelId) {
        this.channelType = channelType;
        this.channelId = channelId;
    }
}
