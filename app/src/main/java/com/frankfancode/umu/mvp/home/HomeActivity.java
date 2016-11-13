package com.frankfancode.umu.mvp.home;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.base.BaseActivity;
import com.frankfancode.umu.utils.ToastManager;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class HomeActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        ToastManager.INSTANCE.showToast("home");
        return R.layout.activity_main;
    }
}
