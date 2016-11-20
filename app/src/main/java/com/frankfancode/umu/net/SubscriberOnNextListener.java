package com.frankfancode.umu.net;

/**
 * Created by FrankFan on 2016/11/20.
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}