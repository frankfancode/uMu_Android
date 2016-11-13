package com.frankfancode.umu.mvp.main;

import com.frankfancode.umu.mvp.base.IBasePresenter;
import com.frankfancode.umu.mvp.base.IBaseView;

/**
 * Created by FrankFan on 2016/11/12.
 */

public class MainContract {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<View> {
    }
}
