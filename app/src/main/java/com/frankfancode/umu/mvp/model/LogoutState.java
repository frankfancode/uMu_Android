package com.frankfancode.umu.mvp.model;

import android.content.Context;
import android.content.Intent;

import com.frankfancode.umu.mvp.Login.LoginActivity;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class LogoutState implements UserState {
    @Override
    public void home(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
