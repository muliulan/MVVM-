package com.module_main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.a.a.a.library_base.mvvm.BaseViewModel;
import com.module_main.m.MainModel;

/**
 * Created by Administrator on 2019/7/25 0025.
 */

public class O1ViewModule extends BaseViewModel<MainModel>{

    public ObservableField<String> userName = new ObservableField<>("");

    public O1ViewModule(@NonNull Application application) {
        super(application);
    }

    @Override
    protected MainModel onInitModel() {
        return  new MainModel(this);
    }

    @Override
    protected void onInit() {
        mModel.onHttp();
    }

    @Override
    public void onHttpData(Object data) {
        userName.set((String) data);
    }
}
