package com.frankfancode.umu.net;

import com.frankfancode.umu.app.UmuConfig;
import com.frankfancode.umu.mvp.entity.AuthEntity;
import com.frankfancode.umu.mvp.entity.MovieEntity;
import com.frankfancode.umu.mvp.entity.UserEntity;
import com.frankfancode.umu.mvp.service.MovieService;
import com.frankfancode.umu.mvp.service.UserService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by FrankFan on 2016/11/19.
 */
public class HttpMethods {

    public static final String BASE_URL = UmuConfig.URL;

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private MovieService movieService;
    private UserService userService;

    //构造方法私有
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(ResponseConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        movieService = retrofit.create(MovieService.class);
        userService = retrofit.create(UserService.class);
    }

    //获取单例
    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     *
     * @param subscriber 由调用者传过来的观察者对象
     * @param start      起始位置
     * @param count      获取长度
     */
    public void getTopMovie(Subscriber<MovieEntity> subscriber, int start, int count) {
        movieService.getTopMovie(start, count)
                .map(new HttpResultFunc<MovieEntity>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);


    }


    public void singupUser(Subscriber<UserEntity> subscriber, String username, String encryptPassword) {
        userService.signup(username, encryptPassword).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    public void login(Subscriber<AuthEntity> subscriber, String username, String encryptPassword) {
        userService.login(username, encryptPassword).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getResultCode() != 0) {
                throw new ApiException(httpResult.getResultCode(), httpResult.getResultMessage());
            }
            return httpResult.data;
        }
    }

}