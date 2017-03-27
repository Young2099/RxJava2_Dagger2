package com.yf.munews.app;

import com.yf.munews.R;
import com.yf.munews.model.common.ApiConstants;
import com.yf.munews.utils.SharedPreferencesUtil;

import java.util.Arrays;
import java.util.List;

import de.greenrobot.dao.query.Query;
import greendao.NewsChannelTable;
import greendao.NewsChannelTableDao;

/**
 * Created by ${yf} on 2017/3/27.
 */

public class NewsChannelTableManager {

    /**
     * 打开程序初始加载频道的数据
     */
    public static void initDB() {

        if (!SharedPreferencesUtil.getIsData()) {
            NewsChannelTableDao dao = App.getNewsChannelTableDao();
            List<String> channelName = Arrays.asList(App.getInstance().getResources()
                    .getStringArray(R.array.news_channel_name));
            List<String> channelId = Arrays.asList(App.getInstance().getResources().getStringArray(R.array.news_channel_id));
            for (int i = 0; i < channelName.size(); i++) {
                NewsChannelTable entity = new NewsChannelTable(channelName.get(i), channelId.get(i)
                        , ApiConstants.getType(channelId.get(i)), i <= 5, i, i == 0);
                dao.insert(entity);
            }
            SharedPreferencesUtil.setIsData(true);

        }
    }

    /**
     * 加载选中的频道
     * @return
     */
    public static List<NewsChannelTable> loadChannelsMine() {
        Query<NewsChannelTable> build = App.getNewsChannelTableDao()
                .queryBuilder().where(NewsChannelTableDao.Properties.NewsChannelSelect.eq(true))
                .orderAsc(NewsChannelTableDao.Properties.NewsChannelIndex).build();
        return build.list();
    }
}
