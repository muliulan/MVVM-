package com.module_login;

import android.app.Application;
import android.support.annotation.NonNull;

import com.a.a.a.library_base.mvvm.BaseModel;
import com.a.a.a.library_base.mvvm.BaseViewModel;

/**
 * Created by Administrator on 2019/7/24 0024.
 */

public class LoginViewModule extends BaseViewModel{

    public LoginViewModule(@NonNull Application application) {
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
