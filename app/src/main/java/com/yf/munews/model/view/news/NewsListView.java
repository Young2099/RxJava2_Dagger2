package com.yf.munews.model.view.news;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.view.BaseView;

import java.util.List;

/**
 * Created by ${yf} on 2017/3/22.
 */

public interface NewsListView extends BaseView {
    void setItems(List<NewsSummary> items);
}
