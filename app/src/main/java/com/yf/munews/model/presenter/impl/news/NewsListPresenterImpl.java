package com.yf.munews.model.presenter.impl.news;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.controller.impl.NewsListControllerImpl;
import com.yf.munews.model.presenter.impl.BasePresenterImpl;
import com.yf.munews.model.presenter.news.NewsListPresenter;
import com.yf.munews.model.view.news.NewsListView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ${yf} on 2017/3/22.
 */

public class NewsListPresenterImpl extends BasePresenterImpl<NewsListView, List<NewsSummary>> implements NewsListPresenter {
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
        mDisposable = newsController.getNewsData(channelType, channelId, startPage, this);
    }


    @Override
    public void onSuccess(List<NewsSummary> t) {
        super.onSuccess(t);
        mView.setItems(t);
    }

    @Override
    public void onItemClicked(String channelType, String channelId) {
        this.channelType = channelType;
        this.channelId = channelId;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mView = null;
    }
}
