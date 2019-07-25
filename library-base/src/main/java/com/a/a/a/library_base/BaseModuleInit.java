package com.a.a.a.library_base;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Administrator on 2019/7/24 0024.
 */

public class BaseModuleInit implements IModuleInit{
    @Override
    public boolean onInitAhead(Application application) {
          Log.e("init","BaseModuleInit");
        //初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        return false;
    }
}
