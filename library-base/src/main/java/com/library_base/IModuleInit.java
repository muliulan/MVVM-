package com.library_base;

import android.app.Application;

/**
 * Created by Administrator on 2019/7/24 0024.
 */

public interface IModuleInit {
    //初始化优先的
    boolean onInitAhead(Application application);

    //初始化靠后的
    boolean onInitLow(Application application);
}
