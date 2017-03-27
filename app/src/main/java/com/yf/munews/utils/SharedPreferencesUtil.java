package com.yf.munews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.yf.munews.app.App;


/**
 * Created by ${yf} on 2017/3/27.
 */

public class SharedPreferencesUtil {


    private static void setBoolean(String fileName, String key, boolean value) {
        SharedPreferences.Editor editor = App.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private static boolean getBoolean(String fileName, String key, boolean defaultValue) {
        SharedPreferences preferences = App.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, defaultValue);
    }


    public static boolean getIsData() {
        return getBoolean(Constants.APP_USER, Constants.DTAT_INIT, false);
    }

    public static void setIsData(boolean value) {
        setBoolean(Constants.APP_USER, Constants.DTAT_INIT, value);
    }
}
