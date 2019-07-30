package com.module_main.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.library_base.mvvm.BaseModel;
import com.library_base.mvvm.BaseViewModel;


/**
 * Created by Administrator on 2019/7/24 0024.
 */

public class SplashViewModel extends BaseViewModel {

    public SplashViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected BaseModel onInitModel() {
        return null;
    }

    @Override
    protected void onInit() {

    }

    @Override
    public void onHttpData(Object data) {

    }
}
