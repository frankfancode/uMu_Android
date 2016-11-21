package com.frankfancode.umu.mvp.Login;


import android.support.annotation.NonNull;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.base.BasePresenter;
import com.frankfancode.umu.mvp.entity.AuthEntity;
import com.frankfancode.umu.mvp.model.UserModel;
import com.frankfancode.umu.net.ProgressSubscriber;
import com.frankfancode.umu.net.SubscriberOnNextListener;
import com.frankfancode.umu.utils.ResourceUtil;
import com.frankfancode.umu.utils.SecureUtil;
import com.frankfancode.umu.utils.StringUtil;

/**
 * Created by FrankFan on 16/6/12.
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    SubscriberOnNextListener loginOnNext;
    UserModel userModel;

    @Override
    public void attachView(@NonNull LoginContract.View view) {
        super.attachView(view);
        userModel=new UserModel();

    }

    @Override
    public void login(String username, String password) {
        if (validate(username, password)) {

            loginOnNext = new SubscriberOnNextListener<AuthEntity>() {

                @Override
                public void onNext(AuthEntity authEntity) {
                    userModel.saveAuth(authEntity);
                }
            };

            String encryptPassword= SecureUtil.MD5(password);

            userModel.login(new ProgressSubscriber<AuthEntity>(loginOnNext, view().getContext()), username, encryptPassword);
        }
    }

    private boolean validate(String name, String password) {
        boolean valid = true;
        if (StringUtil.isBlank(name)) {
            valid = false;
            view().setUsernameError(ResourceUtil.newInstance().getString(R.string.username_error));

        }
        if (StringUtil.isBlank(password)) {
            view().setPasswordError(ResourceUtil.newInstance().getString(R.string.password_error));
            valid = false;
        }
        return valid;
    }
}
