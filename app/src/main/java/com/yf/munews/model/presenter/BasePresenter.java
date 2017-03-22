package com.yf.munews.model.presenter;

import android.support.annotation.NonNull;

import com.yf.munews.model.view.BaseView;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface BasePresenter {
    void onCreate();

    void attachView(@NonNull BaseView view);

}
