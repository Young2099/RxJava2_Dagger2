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
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${yf} on 2017/3/27.
 */

public class NewsControllerImpl implements NewsController<List<NewsChannelTable>> {

    private Disposable disposable;

    @Inject
    public NewsControllerImpl() {
    }

    @Override
    public Disposable loadChannelData(final RequestCallBack<List<NewsChannelTable>> callBack) {
        Observable.create(new ObservableOnSubscribe<List<NewsChannelTable>>() {

            @Override
            public void subscribe(ObservableEmitter<List<NewsChannelTable>> e) throws Exception {
                NewsChannelTableManager.initDB();
                e.onNext(NewsChannelTableManager.loadChannelsMine());
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<NewsChannelTable>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(List<NewsChannelTable> newsChannelTables) {
                        callBack.onSuccess(newsChannelTables);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure("加载失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return disposable;
    }
}
