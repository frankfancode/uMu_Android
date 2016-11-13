package com.frankfancode.umu.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.frankfancode.umu.R;
import com.frankfancode.umu.widget.BaseLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by FrankFan on 2016/11/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getContentView() >0) {
            BaseLayout baseLayout = new BaseLayout(this);
            ViewGroup contentLayout = (ViewGroup) baseLayout.findViewById(R.id.base_content);
            LayoutInflater.from(this).inflate(getContentView(), contentLayout, true);
            setContentView(baseLayout);
            getContext();
        } else {

        }
        unbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
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
