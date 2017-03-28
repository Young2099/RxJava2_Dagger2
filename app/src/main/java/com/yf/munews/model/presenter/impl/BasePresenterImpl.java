package com.yf.munews.model.presenter.impl;

import android.support.annotation.NonNull;

import com.yf.munews.model.callback.RequestCallBack;
import com.yf.munews.model.presenter.BasePresenter;
import com.yf.munews.model.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * Created by ${yf} on 2017/3/28.
 */

public abstract class BasePresenterImpl<T extends BaseView, E> implements BasePresenter,RequestCallBack<E> {

    protected Disposable mDisposable;
    protected T mView;

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (T) view;
    }

    @Override
    public void onDestroy() {
        if (!mDisposable.isDisposed() && mDisposable != null) {
            mDisposable.dispose();
        }
    }

    @Override
    public void onFailure(String errorMessage) {
        mView.hideProgress();
        mView.showErrorMsg(errorMessage);
    }

    @Override
    public void onSuccess(E t) {
        mView.hideProgress();
    }

    @Override
    public void loadBefore() {
        mView.showProgress();
    }
}
