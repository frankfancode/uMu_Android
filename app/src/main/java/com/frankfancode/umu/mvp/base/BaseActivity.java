package com.frankfancode.umu.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frankfancode.umu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by FrankFan on 2016/11/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    @BindView(R.id.appbar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getContentView() > 0) {
            setContentView(R.layout.layout_base);
            ViewGroup contentLayout = (ViewGroup) findViewById(R.id.base_content);
            LayoutInflater.from(this).inflate(getContentView(), contentLayout, true);
            unbinder = ButterKnife.bind(this);
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        } else {

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected void hideTitle() {
        appBar.setVisibility(View.GONE);
    }

    protected void setTitle(String s) {
        appBar.setVisibility(View.VISIBLE);
        toolbar.setTitle(s);

    }

    protected abstract int getContentView();

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public boolean isAlive() {

        return isFinishing();
    }
}
