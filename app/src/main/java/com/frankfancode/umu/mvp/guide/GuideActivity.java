package com.frankfancode.umu.mvp.guide;

import com.frankfancode.umu.mvp.base.BaseActivity;
import com.frankfancode.umu.utils.ToastManager;

/**
 * Created by FrankFan on 2016/11/13.
 */

public class GuideActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        ToastManager.INSTANCE.showToast("guide");
        return 0;
    }
}
