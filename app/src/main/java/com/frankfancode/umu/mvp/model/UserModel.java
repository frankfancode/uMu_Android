package com.frankfancode.umu.mvp.model;


import com.frankfancode.umu.mvp.entity.UserEntity;
import com.frankfancode.umu.net.HttpMethods;
import com.frankfancode.umu.utils.CacheUtils;

import rx.Subscriber;

/**
 * Created by Frank on 2016/6/11.
 */

public class UserModel {
    public static boolean isLogin() {
        return CacheUtils.isLogin();
    }

    public void saveUser(UserEntity user) {
        CacheUtils.saveUser(user);
    }

    public void signup(Subscriber subscriber,String name, String password) {
        HttpMethods.getInstance().singupUser(subscriber,name,password);
    }
}
