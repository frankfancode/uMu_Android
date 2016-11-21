package com.frankfancode.umu.mvp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.base.BaseActivity;
import com.frankfancode.umu.mvp.signup.SignupActivity;
import com.frankfancode.umu.utils.SystemUtil;
import com.frankfancode.umu.utils.ToastManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private static final int REQUEST_SIGNUP = 100;

    @BindView(R.id.btn_login)
    Button loginBtn;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.link_signup)
    TextView linkSignup;


    private LoginPresenter mPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.hideTitle();
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        loginBtn.setFocusable(true);

        loginBtn.setFocusableInTouchMode(true);
        loginBtn.requestFocus();
    }


    @OnClick(R.id.btn_login)
    public void login(View v) {
        SystemUtil.hideKeyboard(LoginActivity.this);
        if (validate()){
            mPresenter.login(inputName.getText().toString(), inputPassword.getText().toString());
        }else {
            onLoginFailed();
        }

    }

    public void onLoginFailed() {
        ToastManager.INSTANCE.showToast("Login failed");
        loginBtn.setEnabled(true);
    }

    @OnClick(R.id.link_signup)
    public void LinkSignUp(View v) {
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }

    @Override
    public void setUsernameError(String errMsg) {

    }

    @Override
    public void setPasswordError(String errMsg) {

    }

    public boolean validate() {
        boolean valid = true;

        String name = inputName.getText().toString();
        String password = inputPassword.getText().toString();

        if (name.isEmpty()) {
            inputName.setError("用户名不能为空");
            valid = false;
        } else {
            inputName.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            inputPassword.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            inputPassword.setError(null);
        }

        return valid;
    }
}

