package com.a.a.a.mymvvm;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.library_base.ui.UiUtils;

/**
 * Created by Administrator on 2019/7/23 0023.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);

        UiUtils.getUiUtils(this);
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
