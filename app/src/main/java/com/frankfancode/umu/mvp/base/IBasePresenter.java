package com.frankfancode.umu.mvp.base;

import android.support.annotation.NonNull;

/**
 * Created by FrankFan on 2016/11/12.
 */

public interface IBasePresenter<V> {

    void attachView(@NonNull V view);

    void detachView();
}
