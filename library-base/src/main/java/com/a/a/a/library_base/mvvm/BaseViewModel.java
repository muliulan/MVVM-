package com.a.a.a.library_base.mvvm;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2019/7/16 0016.
 */

public abstract class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements IBaseViewModel {

    protected abstract void onInit();
    protected M mModel;
    public MutableLiveData mLivedata;
    public BaseActivity mActivity;


    public BaseViewModel(@NonNull Application application) {
        super(application);

    }

    public MutableLiveData getViewMoudel(){
        if(mLivedata==null){
            mLivedata = new MutableLiveData<>();
        }
        return mLivedata;
    }
    public void setActivity(BaseActivity ma){
        this.mActivity=ma;
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {
    }

    @Override
    public void onCreate() {
        onInit();
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public Activity getActivity() {
        return mActivity;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(mModel!=null){
            mModel.onCleared();
            mModel=null;
        }if(mActivity!=null){
            mActivity=null;
        }
    }
}