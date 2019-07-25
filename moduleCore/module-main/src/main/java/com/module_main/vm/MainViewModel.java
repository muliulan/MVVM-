package com.module_main.vm;

import android.app.Activity;
import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.a.a.a.library_base.mvvm.BaseViewModel;
import com.module_main.m.MainModel;
import com.module_main.v.MainActivity;


/**
 * Created by Administrator on 2019/7/16 0016.
 */

public class MainViewModel extends BaseViewModel<MainModel> {

    public ObservableField<String>  userName = new ObservableField<>("");

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onInit() {

        mModel = new MainModel(this);
        mModel.onHttp();

        Activity activity = getActivity();

        if(mActivity instanceof MainActivity){
            Log.e("mll","dui");
        }
    }

    public void setText(String data){
        userName.set( data);
    }

    @Override
    public void onHttpData(Object data) {
//        mLivedata.setValue(data);
        if(data instanceof String){
            userName.set((String)data);
        }
    }
}
