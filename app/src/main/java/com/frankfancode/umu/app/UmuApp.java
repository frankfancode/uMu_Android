package com.frankfancode.umu.app;

import android.app.Application;

import com.frankfancode.umu.utils.SpUtils;

/**
 * Created by FrankFan on 2016/11/10.
 */

public class UmuApp extends Application {
    private static UmuApp mContext;

    public static UmuApp getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        init();
    }

    private void init() {
        SpUtils.getInstance().init(mContext);

    }
}
