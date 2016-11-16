package com.frankfancode.umu.mvp.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.base.BaseActivity;
import com.frankfancode.umu.utils.ToastManager;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class GuideActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        ToastManager.INSTANCE.showToast("guide");
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("Guide");
    }
}
