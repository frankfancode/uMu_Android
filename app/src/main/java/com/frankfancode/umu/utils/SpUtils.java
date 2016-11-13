package com.frankfancode.umu.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {

    private static final String SHARE_PREFERENCES_NAME = "umuchat";
    private static final SpUtils sharedPreferencesUtil = new SpUtils();

    private SharedPreferences sharedPreferences;

    public static SpUtils getInstance() {
        return sharedPreferencesUtil;
    }

    public SpUtils() {

    }

    public void init(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 设置boolean 缓存数据
     */
    public void setBoolean(String key, Boolean value) {
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * 查询boolean 缓存数据
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * 设置String 缓存数据
     */
    public void setString(String key, String value) {
        sharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * 查询String 缓存数据
     */
    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    /**
     * 设置long 缓存数据
     */
    public void setLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * 查询long 缓存数据
     */
    public long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    /**
     * 设置int缓存数据
     */
    public void setInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * 查询int缓存数据
     */
    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    /**
     * 清空指定key对应的缓存数据
     */
    public void remove(String key) {
        sharedPreferences.edit().remove(key).commit();
    }


}
