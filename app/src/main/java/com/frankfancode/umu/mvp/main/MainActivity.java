package com.frankfancode.umu.mvp.main;

import android.os.Bundle;

import com.frankfancode.umu.mvp.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainContract.View{
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new MainPresenter();
        mPresenter.attachView(this);

    }

    @Override
    protected int getContentView() {
        return -1;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
