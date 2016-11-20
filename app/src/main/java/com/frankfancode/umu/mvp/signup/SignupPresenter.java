package com.frankfancode.umu.mvp.signup;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.frankfancode.umu.R;
import com.frankfancode.umu.mvp.base.BasePresenter;
import com.frankfancode.umu.mvp.entity.MovieEntity;
import com.frankfancode.umu.mvp.model.UserModel;
import com.frankfancode.umu.net.HttpMethods;
import com.frankfancode.umu.net.ProgressSubscriber;
import com.frankfancode.umu.net.SubscriberOnNextListener;
import com.frankfancode.umu.utils.ResourceUtil;
import com.frankfancode.umu.utils.StringUtil;
import com.frankfancode.umu.utils.ToastManager;

import rx.Subscriber;


/**
 * Created by FrankFan on 2016/11/17.
 */

public class SignupPresenter extends BasePresenter implements SignupContract.Presenter {
    private SignupContract.View mView;

    private UserModel userModel;

    @Override
    public void attachView(@NonNull SignupContract.View view) {
        super.attachView(view);
        this.mView = view;
        userModel = new UserModel();
    }

    @Override
    public void signup(String name, String password, String rePassword) {
        getMovie();
        /*if (validate(name, password, rePassword)) {
            userModel.signup(name, password, new Callback<UserEntity>() {
                @Override
                public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                    UserEntity user = response.body();
                    if (user.errCode!=0){
                        ToastManager.INSTANCE.showToast(user.errMessage);
                    }else{
                        userModel.saveUser(user);
                    }

                }

                @Override
                public void onFailure(Call<UserEntity> call, Throwable t) {
                    ToastManager.INSTANCE.showToast(t.getMessage());
                }
            });
        }

*/
    }

    private SubscriberOnNextListener getTopMovieOnNext;

    private void getMovie(){
        Subscriber subscriber = new Subscriber<MovieEntity>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(view().getContext(), "Get Top Movie Completed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNext(MovieEntity movieEntity) {


            }
        };
        getTopMovieOnNext = new SubscriberOnNextListener<MovieEntity>() {
            @Override
            public void onNext(MovieEntity movieEntity) {
                ToastManager.INSTANCE.showToast(movieEntity.count);
            }
        };



        HttpMethods.getInstance().getTopMovie(new ProgressSubscriber<MovieEntity>(getTopMovieOnNext,view().getContext()), 0, 10);
    }

    private boolean validate(String name, String password, String rePassword) {
        boolean valid = true;
        if (StringUtil.isBlank(name)) {
            valid = false;
            mView.setUsernameError(ResourceUtil.newInstance().getString(R.string.username_error));

        }
        if (StringUtil.isBlank(password)) {
            mView.setPasswordError(ResourceUtil.newInstance().getString(R.string.password_error));
            valid = false;
        }
        if (StringUtil.isBlank(rePassword) || !StringUtil.isEqual(password, rePassword)) {
            mView.setRePasswordError(ResourceUtil.newInstance().getString(R.string.repassword_error));
            valid = false;
        }
        return valid;
    }


}
