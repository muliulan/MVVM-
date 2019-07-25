package com.a.a.a.library_base.mvvm;

/**
 * Created by Administrator on 2019/7/19 0019.
 */

public interface IModel {
    /**
     * ViewModel销毁时清除Model，与ViewModel共消亡。Model层同样不能持有长生命周期对象
     */
    void onCleared();

    void onHttp();
}
