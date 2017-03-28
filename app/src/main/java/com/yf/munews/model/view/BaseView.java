package com.yf.munews.model.view;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface BaseView {
    void showErrorMsg(String errorMessage);

    /* 隐藏加载的Progress*/
    void hideProgress();

    void showProgress();
}
