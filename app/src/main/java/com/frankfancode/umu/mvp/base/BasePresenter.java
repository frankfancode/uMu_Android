package com.frankfancode.umu.mvp.base;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by FrankFan on 2016/11/12.
 */

public abstract class BasePresenter<V extends IBaseView> {
    private WeakReference<V> view;


    public void attachView(@NonNull V view) {
        this.view = new WeakReference<V>(view);
    }

    public void detachView() {
        this.view = null;
    }


    protected V view() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }
    }

    public boolean isViewAlive() {
        if (view() != null && view().isAlive()) {
            return true;
        } else {
            return true;
        }
    }


}
