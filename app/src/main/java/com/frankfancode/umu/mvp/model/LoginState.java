package com.frankfancode.umu.mvp.model;

import android.content.Context;
import android.content.Intent;

import com.frankfancode.umu.mvp.home.HomeActivity;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class LoginState implements UserState {

    @Override
    public void home(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
}
