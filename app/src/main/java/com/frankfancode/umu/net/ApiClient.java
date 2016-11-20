package com.frankfancode.umu.net;


import com.frankfancode.umu.app.UmuConfig;
import com.frankfancode.umu.mvp.service.BaseService;
import com.frankfancode.umu.mvp.service.UserService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by FrankFan on 16/6/15.
 */
public class ApiClient {

    public static final String BASE_URL = "http://192.168.1.102:8080/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;

    private UserService userService;
    private ConcurrentHashMap<Class, BaseService> mServiceMap;

    //构造方法私有
    private ApiClient() {
        //手动创建一个OkHttpClient并设置超时时间

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (UmuConfig.Dev) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        mServiceMap = new ConcurrentHashMap();
    }


    //获取单例
    public static ApiClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public <T> T getService(Class<T> service) {
        if (!mServiceMap.contains(service)) {
            mServiceMap.put(service, mRetrofit.create(UserService.class));
        }
        return (T) mServiceMap.get(service);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final ApiClient INSTANCE = new ApiClient();
    }
}
