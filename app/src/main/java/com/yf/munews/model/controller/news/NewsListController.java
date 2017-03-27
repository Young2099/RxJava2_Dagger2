package com.yf.munews.model.controller.news;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.callback.RequestCallBack;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface NewsListController {
    Disposable getNewsData(String channelType, String channelId, int startPage, RequestCallBack<List<NewsSummary>> data);
}
