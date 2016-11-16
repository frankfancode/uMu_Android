package com.frankfancode.umu.mvp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.base.BaseActivity;
import com.frankfancode.umu.mvp.signup.SignupActivity;

import butterknife.OnClick;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class LoginActivity  extends BaseActivity {

    private static final int REQUEST_SIGNUP = 100;


    private LoginPresenter mPresenter;
    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.hideTitle();
    }

    @OnClick(R.id.link_signup)
    public void LinkSignUp(View v){
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }
}
