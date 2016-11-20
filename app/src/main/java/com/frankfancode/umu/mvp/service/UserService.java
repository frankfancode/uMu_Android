package com.frankfancode.umu.mvp.service;

import com.frankfancode.umu.mvp.entity.UserEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by FrankFan on 2016/11/17.
 */

public interface UserService extends BaseService {
    @FormUrlEncoded
    @POST("/user/signup")
    Observable<UserEntity> signup(@Field("name") String name, @Field("passwordMd5") String passwordMd5);

}
