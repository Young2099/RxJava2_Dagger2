package com.yf.munews.ui.fragment.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yf.munews.R;
import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.presenter.NewsPresenter;
import com.yf.munews.model.presenter.NewsPresenterImpl;
import com.yf.munews.model.view.NewsView;
import com.yf.munews.ui.fragment.base.BaseFragment;
import com.yf.munews.utils.Constants;

import java.util.List;

import butterknife.BindView;

/**
 * Created by ${yf} on 2017/3/22.
 */

public class NewsListFragment extends BaseFragment implements NewsView {
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.news_rv)
    RecyclerView mRecyclerView;

    NewsPresenter presenter = new NewsPresenterImpl();
    private String  channelType;
    private String channelId;

    @Override
    protected void initInject() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValues();
    }

    private void initValues() {
        if(getArguments() != null){
            channelId = getArguments().getString(Constants.NEWS_ID);
            channelType = getArguments().getString(Constants.NEWS_TYPE);
        }
    }

    @Override
    protected void initViews(View mFragmentView) {
        presenter.onItemClicked(channelType,channelId);
        presenter.attachView(this);
        presenter.onCreate();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    public void showErrorMsg(String errorMessage) {

    }

    /**
     * 访问服务返回的数据
     *
     * @param data
     */
    @Override
    public void setItems(List<NewsSummary> data) {

    }
}
