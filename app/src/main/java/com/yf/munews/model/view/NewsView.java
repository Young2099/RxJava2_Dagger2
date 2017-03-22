package com.yf.munews.model.view;

import com.yf.munews.model.bean.NewsSummary;

import java.util.List;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface NewsView extends BaseView{
    void setItems(List<NewsSummary> items);
}
