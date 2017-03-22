package com.yf.munews.model.presenter;

import android.support.annotation.NonNull;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.callback.RequestCallBack;
import com.yf.munews.model.controller.NewsController;
import com.yf.munews.model.controller.NewsControllerImpl;
import com.yf.munews.model.view.BaseView;
import com.yf.munews.model.view.NewsView;

/**
 * Created by ${yf} on 2017/3/22.
 */

public class NewsPresenterImpl implements NewsPresenter,RequestCallBack<NewsSummary>{
    NewsView mView;

    NewsController interactor = new NewsControllerImpl();

    @Override
    public void onCreate() {

    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (NewsView) view;
    }

    @Override
    public void getNewsData() {
        interactor.getNewsData(this);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onSuccess() {

    }
}
