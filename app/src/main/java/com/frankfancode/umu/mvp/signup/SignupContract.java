package com.frankfancode.umu.mvp.signup;

import android.support.annotation.NonNull;

import com.frankfancode.umu.mvp.base.IBasePresenter;
import com.frankfancode.umu.mvp.base.IBaseView;

/**
 * Created by FrankFan on 2016/11/17.
 */

public class SignupContract {
    public interface View extends IBaseView {
        @NonNull
        String getInputName();

        @NonNull
        String getInputPassword();

        @NonNull
        String getReinputPassword();


        void setUsernameError(String errMsg);


        void setPasswordError(String errMsg);

        void setRePasswordError(String errMsg);

    }

    interface Presenter extends IBasePresenter<View> {
        public void signup(String name, String password, String rePassword);
    }
}
