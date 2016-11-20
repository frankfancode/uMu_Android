package com.frankfancode.umu.mvp.service;

import com.frankfancode.umu.mvp.entity.MovieEntity;
import com.frankfancode.umu.net.HttpResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by FrankFan on 2016/11/19.
 */

public interface MovieService {
    @GET("top250")
    Observable<HttpResult<MovieEntity>> getTopMovie(@Query("start") int start, @Query("count") int count);
}