package com.yf.munews.model.presenter.impl.news;

import com.yf.munews.model.controller.impl.NewsControllerImpl;
import com.yf.munews.model.presenter.impl.BasePresenterImpl;
import com.yf.munews.model.presenter.news.NewsPresenter;
import com.yf.munews.model.view.news.NewsView;

import java.util.List;

import javax.inject.Inject;

import greendao.NewsChannelTable;

/**
 * Created by ${yf} on 2017/3/27.
 */

public class NewsPresenterImpl extends BasePresenterImpl<NewsView, List<NewsChannelTable>> implements NewsPresenter {

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
        mDisposable = newsController.loadChannelData(this);
    }

    @Override
    public void onSuccess(List<NewsChannelTable> newsChannelTables) {
        super.onSuccess(newsChannelTables);
        mView.initChannelTable(newsChannelTables);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mView = null;
    }
}
