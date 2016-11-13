package com.frankfancode.umu.mvp.model;

import android.content.Context;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class LoginContext {
    UserState mUserState =new LogoutState();
    static LoginContext sLoginContext=new LoginContext();
    private LoginContext(){}
    public static LoginContext getLoginContext(){
        return sLoginContext;
    }

    public void setState(UserState state){
        this.mUserState=state;
    }

    public void home(Context context){
        mUserState.home(context);
    }
}
