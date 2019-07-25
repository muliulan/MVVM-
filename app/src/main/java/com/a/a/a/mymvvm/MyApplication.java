package com.a.a.a.mymvvm;

import android.app.Application;

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
    }
}
