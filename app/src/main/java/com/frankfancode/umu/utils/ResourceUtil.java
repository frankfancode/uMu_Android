package com.frankfancode.umu.utils;

import com.frankfancode.umu.app.UmuApp;
import com.frankfancode.umu.mvp.model.BaseModel;

/**
 * Created by FrankFan on 16/6/14.
 */
public class ResourceUtil extends BaseModel {
    private ResourceUtil() {
    }

    public static ResourceUtil newInstance() {
        return ResourceModelHolder.instance;
    }

    public String getString(int resId) {
        return ResourceModelHolder.appContext.getResources().getString(resId);
    }

    private static class ResourceModelHolder {
        public static UmuApp appContext = UmuApp.getAppContext();
        public static ResourceUtil instance = new ResourceUtil();

    }
}
