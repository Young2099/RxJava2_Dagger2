package com.yf.munews.model.view.news;

import com.yf.munews.model.view.BaseView;

import java.util.List;

import greendao.NewsChannelTable;

/**
 * Created by ${yf} on 2017/3/27.
 * 加载首页频道title
 *
 */

public interface NewsView extends BaseView {
    void initChannelTable(List<NewsChannelTable> list);
}
