package com.yf.munews.model.controller.news;

import com.yf.munews.model.callback.RequestCallBack;

import io.reactivex.disposables.Disposable;

/**
 * Created by ${yf} on 2017/3/27.
 */

public interface NewsController<T> {
    Disposable loadChannelData(RequestCallBack<T> callBack);
}
