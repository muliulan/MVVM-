package com.module_main.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.library_base.mvvm.BaseViewModel;
import com.module_main.m.MainModel;


/**
 * Created by Administrator on 2019/7/16 0016.
 */

public class MainViewModel extends BaseViewModel<MainModel> {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected MainModel onInitModel() {
        return  null;
    }

    @Override
    protected void onInit() {
//        mModel.onHttp();
    }


    @Override
    public void onHttpData(Object data) {
//        mLivedata.setValue(data);
//        if(data instanceof String){
//            userName.set((String)data);
//        }
    }
}
