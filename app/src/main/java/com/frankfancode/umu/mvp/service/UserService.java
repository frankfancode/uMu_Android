package com.frankfancode.umu.mvp.service;

import com.frankfancode.umu.mvp.entity.AuthEntity;
import com.frankfancode.umu.mvp.entity.UserEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by FrankFan on 2016/11/17.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("/user/signup")
    Observable<UserEntity> signup(@Field("name") String name, @Field("encryptPassword") String passwordMd5);

    @FormUrlEncoded
    @POST("/user/login")
    Observable<AuthEntity> login(@Field("name") String name, @Field("encryptPassword") String passwordMd5);
}
