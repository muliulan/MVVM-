package com.a.a.a.library_base.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2019/7/16 0016.
 */

public abstract class BaseActivity<V extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {

    protected abstract int initContentView();
    protected abstract void initView(Bundle savedInstanceState);
    protected abstract void data(Object data);
    protected V mBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        initViewModel();
        initView(savedInstanceState);
        ARouter.getInstance().inject(this);
    }
    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, initContentView());

    }
    private void initViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) createViewModel(this, modelClass);
        }
        getLifecycle().addObserver(mViewModel);
        mViewModel.getViewMoudel().observe(this,nameObserver);
        mViewModel.setActivity(this);
    }

    public <T extends ViewModel> T createViewModel(FragmentActivity activity, Class<T> cls) {
        return ViewModelProviders.of(activity).get(cls);
    }

    Observer<Object> nameObserver = new Observer<Object>() {
        @Override
        public void onChanged(@Nullable Object t) {
            data(t);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(mViewModel);
        if(mBinding != null){
            mBinding.unbind();
        }
    }
}
