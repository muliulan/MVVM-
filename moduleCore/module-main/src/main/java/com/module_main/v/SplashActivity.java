package com.module_main.v;

import android.os.Bundle;
import android.view.View;

import com.a.a.a.library_base.arouter.RouterPath;
import com.a.a.a.library_base.mvvm.BaseActivity;
import com.alibaba.android.arouter.launcher.ARouter;
import com.module_main.R;
import com.module_main.databinding.ActivitySplasBinding;
import com.module_main.vm.SplashViewModel;

/**
 * Created by Administrator on 2019/7/24 0024.
 */

public class SplashActivity extends BaseActivity<ActivitySplasBinding,SplashViewModel> {
    @Override
    protected int initContentView() {
        return R.layout.activity_splas;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

//        Fragment navigation = (Fragment) ARouter.getInstance().build(RouterPath.Main.O1).navigation();
//        if(navigation==null){
//            Log.e("mlll","buweinull");
//
//        }
        mBinding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterPath.Login.LOGIN).navigation();
//                finish();
            }
        });

    }

    @Override
    protected void data(Object data) {

    }
}
