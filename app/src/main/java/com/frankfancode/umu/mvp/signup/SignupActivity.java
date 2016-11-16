package com.frankfancode.umu.mvp.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.Login.LoginActivity;
import com.frankfancode.umu.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by FrankFan on 2016/11/17.
 */

public class SignupActivity extends BaseActivity implements SignupContract.View {

    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.reinput_password)
    EditText reinputPassword;
    @BindView(R.id.btn_signup)
    AppCompatButton btnSignup;
    @BindView(R.id.link_login)
    TextView linkLogin;

    private SignupContract.Presenter mPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_signup;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.hideTitle();
        mPresenter=new SignupPresenter();
    }

    @OnClick({R.id.btn_signup, R.id.link_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_signup:
                mPresenter.signup(inputName.getText().toString(), inputPassword.getText().toString(), reinputPassword.getText().toString());
                break;
            case R.id.link_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    @NonNull
    public String getInputName() {
        return inputName.getText().toString();
    }

    @Override
    @NonNull
    public String getInputPassword() {
        return inputPassword.getText().toString();
    }


    @Override
    @NonNull
    public String getReinputPassword() {
        return reinputPassword.getText().toString();

    }


    @Override
    public void setUsernameError(String errMsg) {
        inputName.setError(errMsg);
    }

    @Override
    public void setPasswordError(String errMsg) {
        inputPassword.setError(errMsg);
    }

    @Override
    public void setRePasswordError(String errMsg) {
        inputPassword.setError(errMsg);
    }
}
