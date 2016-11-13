package com.frankfancode.umu.mvp.model;


import com.frankfancode.umu.utils.CacheUtils;

/**
 * Created by Frank on 2016/6/11.
 */

public class UserModel {
    public static boolean isLogin() {
        return CacheUtils.isLogin();
    }

}
