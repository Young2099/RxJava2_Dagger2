package com.yf.munews.ui.fragment.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yf.munews.R;
import com.yf.munews.model.presenter.impl.NewsPresenterImpl;
import com.yf.munews.model.view.news.NewsView;
import com.yf.munews.ui.adapter.NewsPagerAdapter;
import com.yf.munews.ui.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import greendao.NewsChannelTable;

/**
 * Created by ${yf} on 2017/3/14.
 */

public class NewsFragment extends BaseFragment implements NewsView{

    String[] tabTitle = new String[]{"头条", "科技", "财经", "军事"};
    List<Fragment> mFragments = new ArrayList<>();

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @Inject
    NewsPresenterImpl newsPresenter;

    //注入实例
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initViews(View view) {
        newsPresenter.attachView(this);
        newsPresenter.onCreate();
        initFragments();
    }

    private void initFragments() {
        mFragments.clear();
        List<String> channelName = new ArrayList<>();
        if (tabTitle != null) {
            for (String title : tabTitle) {
                NewsListFragment fragment = new NewsListFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString(Constants.NEWS_ID, channelTable.getNewsChannelId());
//                bundle.putString(Constants.NEWS_TYPE, channelTable.getNewsChannelType());
//                bundle.putInt(Constants.CHANNEL_POSITION, channelTable.getNewsChannelIndex());
                mFragments.add(fragment);
                channelName.add(title);
            }
        }
        NewsPagerAdapter adapter = new NewsPagerAdapter(getChildFragmentManager(), mFragments, channelName);
        mViewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void showErrorMsg(String errorMessage) {

    }

    @Override
    public void initChannelTable(List<NewsChannelTable> list) {

    }
}
