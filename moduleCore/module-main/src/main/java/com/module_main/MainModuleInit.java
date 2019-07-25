package com.module_main;

import android.app.Application;
import android.util.Log;

import com.a.a.a.library_base.IModuleInit;

/**
 * Created by Administrator on 2019/7/24 0024.
 */

public class MainModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        Log.e("init","MainModuleInit");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        return false;
    }
}
