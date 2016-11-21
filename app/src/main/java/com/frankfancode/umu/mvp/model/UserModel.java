package com.frankfancode.umu.mvp.model;


import com.frankfancode.umu.mvp.entity.AuthEntity;
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

    public void saveAuth(AuthEntity authEntity) {
        CacheUtils.saveAuth(authEntity);
    }

    public void signup(Subscriber subscriber,String name, String encryptPassword) {
        HttpMethods.getInstance().singupUser(subscriber,name,encryptPassword);
    }

    public void login(Subscriber subscriber, String name, String encryptPassword) {
        HttpMethods.getInstance().login(subscriber,name,encryptPassword);
    }

}
