package com.yf.munews.model.controller;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.callback.RequestCallBack;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface NewsController{
    void getNewsData(RequestCallBack<NewsSummary> data);
}
