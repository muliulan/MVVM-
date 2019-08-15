package com.module_main.v;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.library_base.arouter.RouterPath;
import com.library_base.mvvm.BaseActivity;
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
        mBinding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterPath.Main.MAIN).navigation();
                finish();
            }
        });

    }

    @Override
    protected void data(Object data) {

    }
}
