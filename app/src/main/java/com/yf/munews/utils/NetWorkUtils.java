package com.yf.munews.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.yf.munews.app.App;

/**
 * Created by ${yf} on 2017/3/20.
 */

public class NetWorkUtils {

    /**
     * 检查是否有可用网络
     *
     * @return
     */
    public static boolean isNetWorkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * 检查是否是wifi
     *
     * @return
     */
    public static boolean isWifiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getActiveNetworkInfo();
        return (wifiInfo != null
                && wifiInfo.getType() == ConnectivityManager.TYPE_WIFI);
    }

    /**
     * 检查是否是2g/3g/4g
     *
     * @return
     */
    public static boolean isMobileConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobileNetWorkInfo = connectivityManager.getActiveNetworkInfo();
        return (mobileNetWorkInfo != null
                && mobileNetWorkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
    }

}
