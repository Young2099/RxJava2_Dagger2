package com.yf.munews.model.presenter;

import android.support.annotation.NonNull;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.callback.RequestCallBack;
import com.yf.munews.model.controller.NewsController;
import com.yf.munews.model.controller.NewsControllerImpl;
import com.yf.munews.model.view.BaseView;
import com.yf.munews.model.view.NewsView;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by ${yf} on 2017/3/22.
 */

public class NewsPresenterImpl implements NewsPresenter, RequestCallBack<List<NewsSummary>> {
    NewsView mView;
    Disposable disposable;
    NewsController controller = new NewsControllerImpl();
    private String channelType;
    private String channelId;
    private int startPage = 20;

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
        disposable = controller.getNewsData(channelType, channelId, startPage, this);
    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (NewsView) view;
    }


    @Override
    public void onFailure() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onItemClicked(String channelType, String channelId) {
        this.channelType = channelType;
        this.channelId = channelId;
    }
}
