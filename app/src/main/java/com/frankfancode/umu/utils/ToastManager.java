package com.frankfancode.umu.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.frankfancode.umu.app.UmuApp;

public enum ToastManager {
    INSTANCE;

    private static Context context;
    private static Toast toast;

    static {
        context = UmuApp.getAppContext();
        toast = Toast.makeText(UmuApp.getAppContext(), "", Toast.LENGTH_SHORT);
    }

    public void showToast(int resId) {
        showToast(context.getResources().getString(resId));
    }

    public void showToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            toast.setText(text);
            toast.show();
        }
    }
}
