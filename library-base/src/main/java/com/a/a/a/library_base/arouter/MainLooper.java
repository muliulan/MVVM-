package com.a.a.a.library_base.arouter;

import android.os.Looper;

/**
 * Created by Administrator on 2019/7/23 0023.
 */

public class MainLooper extends android.os.Handler {

    private static MainLooper instance = new MainLooper(Looper.getMainLooper());

    protected MainLooper(Looper looper) {
        super(looper);
    }

    public static MainLooper getInstance() {
        return instance;
    }

    public static void runOnUiThread(Runnable runnable) {
        if(Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            instance.post(runnable);
        }

    }
}
