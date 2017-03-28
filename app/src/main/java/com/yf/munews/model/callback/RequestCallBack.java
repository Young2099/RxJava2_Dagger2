package com.yf.munews.model.callback;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface RequestCallBack<T> {
    void onFailure(String errorMessage);

    void onSuccess(T t);

    void loadBefore();
}
