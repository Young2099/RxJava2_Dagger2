package com.yf.munews.model.controller.impl;

import com.yf.munews.app.NewsChannelTableManager;
import com.yf.munews.model.callback.RequestCallBack;
import com.yf.munews.model.controller.news.NewsController;

import java.util.List;

import javax.inject.Inject;

import greendao.NewsChannelTable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * Created by ${yf} on 2017/3/27.
 */

public class NewsControllerImpl implements NewsController<List<NewsChannelTable>> {

    @Inject
    public NewsControllerImpl() {
    }

    @Override
    public Disposable loadChannelData(RequestCallBack<List<NewsChannelTable>> callBack) {
        Observable.create(new ObservableOnSubscribe<List<NewsChannelTable>>() {

            @Override
            public void subscribe(ObservableEmitter<List<NewsChannelTable>> e) throws Exception {
                NewsChannelTableManager.initDB();
                e.onNext(NewsChannelTableManager.loadChannelsMine());
                e.onComplete();
            }
        }).subscribe();
        return null;
    }
}
