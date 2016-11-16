package com.frankfancode.umu.mvp.Login;


import com.frankfancode.umu.mvp.base.IBasePresenter;
import com.frankfancode.umu.mvp.base.IBaseView;

/**
 * Created by FrankFan on 16/6/12.
 */
public interface LoginContract {


    interface View extends IBaseView {


        void setUsernameError(String errMsg);


        void setPasswordError(String errMsg);
    }

    interface Presenter extends IBasePresenter<View> {
        void login(String username, String passwordMd5);
    }
}
