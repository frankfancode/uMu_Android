package com.frankfancode.umu.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.frankfancode.umu.R;
import com.frankfancode.umu.widget.BaseLayout;

/**
 * Created by FrankFan on 2016/11/2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getContentView() != -1) {
            BaseLayout baseLayout = new BaseLayout(this);
            ViewGroup contentLayout = (ViewGroup) baseLayout.findViewById(R.id.base_content);
            LayoutInflater.from(this).inflate(getContentView(), contentLayout, true);
            setContentView(baseLayout);
        }

    }

    protected abstract int getContentView();
}
