package com.frankfancode.umu.view.activity;

import android.os.Bundle;

import com.frankfancode.umu.R;
import com.frankfancode.umu.utils.ToastManager;
import com.frankfancode.umu.view.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
