package com.yf.munews.model.controller;

import com.yf.munews.model.bean.NewsSummary;
import com.yf.munews.model.callback.RequestCallBack;
import com.yf.munews.respository.db.RetrofitHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by ${yf} on 2017/3/22.
 */

public class NewsControllerImpl implements NewsController {
    @Inject
    RetrofitHelper retrofitHelper;

    @Override
    public Disposable getNewsData(String channelType, final String channelId, final int startPage, RequestCallBack<List<NewsSummary>> callback) {
        return retrofitHelper.getNewsList(channelType, channelId, startPage)
                .flatMap(new Function<Map<String, List<NewsSummary>>, ObservableSource<NewsSummary>>() {
                    @Override
                    public ObservableSource<NewsSummary> apply(@NonNull Map<String, List<NewsSummary>> stringListMap) throws Exception {
                        if (channelId.endsWith("北京")) {

                            return Observable.fromIterable(stringListMap.get("北京"));
                        }
                        return Observable.fromIterable(stringListMap.get(channelId));
                    }
                })
                .map(new Function<NewsSummary, NewsSummary>() {
                    @Override
                    public NewsSummary apply(@NonNull NewsSummary newsSummary) throws Exception {
                        try {
                            //根据时间排序
                            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                                    .parse(newsSummary.getPtime());
                            String pTime = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(date);
                            newsSummary.setPtime(pTime);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        return newsSummary;
                    }
                })
                .distinct()
                //对新闻信息根据时间排序
                .toSortedList(new Comparator<NewsSummary>() {
                    @Override
                    public int compare(NewsSummary o1, NewsSummary o2) {
                        return o2.getPtime().compareTo(o1.getPtime());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<NewsSummary>>() {
                    @Override
                    public void accept(@NonNull List<NewsSummary> newsSummaries) throws Exception {

                    }
                });


    }
}
