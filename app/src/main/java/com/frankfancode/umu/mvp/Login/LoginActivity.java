package com.frankfancode.umu.mvp.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.base.BaseActivity;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class LoginActivity  extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.hideTitle();
    }
}
