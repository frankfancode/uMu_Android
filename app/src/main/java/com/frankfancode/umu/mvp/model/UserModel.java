package com.frankfancode.umu.mvp.model;


import com.frankfancode.umu.mvp.entity.UserEntity;
import com.frankfancode.umu.mvp.service.UserService;
import com.frankfancode.umu.net.ApiClient;
import com.frankfancode.umu.utils.CacheUtils;

import retrofit2.Callback;

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

    public void signup(String name, String password, Callback<UserEntity> callback) {
        ApiClient.getInstance().getService(UserService.class).signup(name, password);
    }
}
