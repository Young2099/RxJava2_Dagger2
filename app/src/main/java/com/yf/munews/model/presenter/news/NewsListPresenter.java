package com.yf.munews.model.presenter.news;

import com.yf.munews.model.presenter.BasePresenter;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface NewsListPresenter extends BasePresenter {

    void onItemClicked(String channelType, String channelId);
}
