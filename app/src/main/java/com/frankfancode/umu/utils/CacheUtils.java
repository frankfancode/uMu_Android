package com.frankfancode.umu.utils;

import com.frankfancode.umu.mvp.entity.AuthEntity;
import com.frankfancode.umu.mvp.entity.UserEntity;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Frank on 2016/6/2.
 */

public class CacheUtils {
    public static final String SP_KEY_LOGIN = "SP_KEY_LOGIN";// 是否登录
    private static final String SP_KEY_LAST_VERSION = "SP_KEY_APP_VERSION"; // 指导页版本
    private static final String SP_KEY_CURRENT_USER = "SP_KEY_CURRENT_USER"; //
    private static final String SP_KEY_CACHE_USER_AUTH = "SP_KEY_CACHE_USER_AUTH";// 用户Auth

    /**
     * 存储当前 APP 版本号
     */
    public static void saveAPPVersionCache(int version) {
        SpUtils.getInstance().setInt(SP_KEY_LAST_VERSION, version);
    }

    /**
     * @return 历史指导页版本，默认-1
     */
    public static int getAPPVersionCache() {
        return SpUtils.getInstance().getInt(SP_KEY_LAST_VERSION, -1);
    }

    public static boolean isLogin() {
        return SpUtils.getInstance().getBoolean(SP_KEY_LOGIN, false);
    }

    public static void setLogin() {
        SpUtils.getInstance().setBoolean(SP_KEY_LOGIN, true);
    }

    /**
     * 缓存数据bean
     */
    public static void setBean(String key, Object bean) {
        String beanStr = new Gson().toJson(bean);
        SpUtils.getInstance().setString(key, beanStr);
    }

    /**
     * 查询数据bean
     */
    public static <T> T getBean(String key, Class<T> bean) {
        try {
            String beanStr = SpUtils.getInstance().getString(key, "");
            return new Gson().fromJson(beanStr, bean);
        } catch (Exception e) {
            e.printStackTrace();

            setBean(key, null);
            return null;
        }
    }

    /**
     * 查询数据bean
     */
    public static <T> T getBean(String key, Type type) {
        try {
            String beanStr = SpUtils.getInstance().getString(key, "");
            return new Gson().fromJson(beanStr, type);
        } catch (Exception e) {
            e.printStackTrace();

            setBean(key, null);
            return null;
        }
    }

    public static void saveUser(UserEntity user) {
        setBean(SP_KEY_CURRENT_USER, user);
    }

    public static void saveAuth(AuthEntity auth) {
        setBean(SP_KEY_CACHE_USER_AUTH , auth);
    }

}
