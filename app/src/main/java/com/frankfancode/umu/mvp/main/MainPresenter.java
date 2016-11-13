package com.frankfancode.umu.mvp.main;

import com.frankfancode.umu.mvp.base.BasePresenter;
import com.frankfancode.umu.mvp.model.LoginContext;
import com.frankfancode.umu.mvp.model.LoginState;
import com.frankfancode.umu.mvp.model.LogoutState;
import com.frankfancode.umu.mvp.model.UserModel;
import com.frankfancode.umu.utils.ToastManager;

import static com.frankfancode.umu.mvp.main.MainContract.View;

/**
 * Created by FrankFan on 2016/11/12.
 */

public class MainPresenter extends BasePresenter implements MainContract.Presenter {
    private View mView;


    @Override
    public void attachView(View view) {
        super.attachView(view);


        if (UserModel.isLogin()) {
            LoginContext.getLoginContext().setState(new LoginState());
            ToastManager.INSTANCE.showToast("login");
        } else {
            LoginContext.getLoginContext().setState(new LogoutState());
            ToastManager.INSTANCE.showToast("not login");
        }
        LoginContext.getLoginContext().home(view.getContext());
    }


}
