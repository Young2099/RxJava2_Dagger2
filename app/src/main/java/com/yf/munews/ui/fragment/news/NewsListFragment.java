package com.yf.munews.ui.fragment.news;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yf.munews.R;
import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.presenter.NewsPresenter;
import com.yf.munews.model.presenter.NewsPresenterImpl;
import com.yf.munews.model.view.NewsView;
import com.yf.munews.ui.fragment.base.BaseFragment;

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

    @Override
    protected void initInject() {

    }

    @Override
    protected void initViews(View mFragmentView) {
        presenter.attachView(this);
        presenter.getNewsData();
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
