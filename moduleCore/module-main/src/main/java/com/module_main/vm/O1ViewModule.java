package com.module_main.vm;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.library_base.mvvm.BaseViewModel;
import com.module_main.TabEntity;
import com.module_main.m.MainModel;

/**
 * Created by Administrator on 2019/7/25 0025.
 */

public class O1ViewModule extends BaseViewModel<MainModel> {

    public ObservableField<String> url = new ObservableField<>();
    public ObservableField<TabEntity> entity = new ObservableField<>();

    public O1ViewModule(@NonNull Application application) {
        super(application);
    }

    @Override
    protected MainModel onInitModel() {
        return  new MainModel(this);
    }

    @Override
    protected void onInit() {

    }
    public void init(){
        mModel.onHttp();
    }
    @Override
    public void onHttpData(Object data) {

        url.set("https://p1.meituan.net/wedding/88201b1f0ceffcd69ec82f479b768c7b925144.jpg%40640w_480h_1e_1c_1l%7Cwatermark%3D0");

        TabEntity tabEntity = new TabEntity((String) data,1,2);
        entity.set(tabEntity);

    }
    public void onclick(View view){
        Log.e("mll","点击");
    }
}
