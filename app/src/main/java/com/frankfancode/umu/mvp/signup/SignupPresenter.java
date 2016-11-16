package com.frankfancode.umu.mvp.signup;

import android.support.annotation.NonNull;

import com.frankfancode.umu.mvp.base.BasePresenter;

/**
 * Created by FrankFan on 2016/11/17.
 */

public class SignupPresenter extends BasePresenter implements SignupContract.Presenter {
    private SignupContract.View mView;

    @Override
    public void signup(String name, String password, String rePassword) {

    }

    @Override
    public void attachView(@NonNull SignupContract.View view) {
        this.mView = view;
    }
}
