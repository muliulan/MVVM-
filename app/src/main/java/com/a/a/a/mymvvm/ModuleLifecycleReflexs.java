package com.a.a.a.mymvvm;

/**
 * Created by Administrator on 2019/7/24 0024.
 */

public class ModuleLifecycleReflexs {
    private static final String BaseInit = "com.library_base.BaseModuleInit";
    //主业务模块
    private static final String MainInit = "com.module_main.MainModuleInit";

    public static String[] initModuleNames = {BaseInit, MainInit };
}
