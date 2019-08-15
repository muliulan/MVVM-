package com.library_base.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2019/7/25 0025.
 */

public abstract class BaseFragment<V extends ViewDataBinding,VM extends  BaseViewModel> extends Fragment{

    protected abstract int initContentView();
    protected abstract void initView(Bundle savedInstanceState);
    protected abstract void data(Object data);

    protected V mBinding;
    protected VM mViewModel;
    private boolean isViewCreate=false;//判断 view 是否可见
    private boolean currentVisibleState=false;//判断 当前节目是否可见

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mBinding==null){
            mBinding = DataBindingUtil.inflate(inflater, initContentView(), container, false);
        }
        isViewCreate=true;
        if(getUserVisibleHint() && !isHidden()){
            dispatchUserVisibleHint(true);
        }
        Log.e("frag","onCreateView");
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(savedInstanceState);
        ARouter.getInstance().inject(this);

    }
    /**
     * 注入绑定
     */
    private void initViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass =  BaseViewModel.class;
            }
            mViewModel = (VM) createViewModel(this, modelClass);
        }
//        binding.setVariable(viewModelId, viewModel);
        //让ViewModel拥有View的生命周期感应
        getLifecycle().addObserver(mViewModel);
        mViewModel.getViewMoudel().observe(this,nameObserver);
        mViewModel.setActivity(this);
    }
    Observer<Object> nameObserver = new Observer<Object>() {
        @Override
        public void onChanged(@Nullable Object t) {
            data(t);
        }
    };
    /**
     * 创建ViewModel
     *
     * @param cls
     * @param <T>
     * @return
     */
    public <T extends ViewModel> T createViewModel(Fragment fragment, Class<T> cls) {
        return ViewModelProviders.of(fragment).get(cls);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getLifecycle().removeObserver(mViewModel);
        if(mBinding != null){
            mBinding.unbind();
        }
        isViewCreate=false;
        currentVisibleState=false;

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("frag","onResume");
        if(!isHidden() && !currentVisibleState && getUserVisibleHint()){
            dispatchUserVisibleHint(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("frag","onPause");
        if(currentVisibleState && getUserVisibleHint()){
            dispatchUserVisibleHint(false);
        }
    }



    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        dispatchUserVisibleHint(!hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("frag","setUserVisibleHint"+"   "+isVisibleToUser);
        if(isViewCreate){
            if(isVisibleToUser && !currentVisibleState){
                dispatchUserVisibleHint(true);
            }else if(!isVisibleToUser && currentVisibleState){
                dispatchUserVisibleHint(false);
            }
        }
    }

    public void dispatchUserVisibleHint(boolean is){
        if(currentVisibleState == is){
            return;
        }
        currentVisibleState=is;
        if(is){
            onFragmentResume();
        }else{
            onFragmentPause();
        }
    }

    public void onFragmentResume(){
        Log.e("frag","resume");

    }

    public void onFragmentPause(){
        Log.e("frag","Pause");

    }
}
