package com.module_login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.library_base.arouter.RouterPath;
import com.library_base.mvvm.BaseActivity;
import com.module_login.databinding.ActivityLoginBinding;

/**
 * Created by Administrator on 2019/7/24 0024.
 */
@Route(path = RouterPath.Login.LOGIN)
public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModule> {

    @Autowired
    public String q1;
    @Autowired
    public String q2;

    @Override
    protected int initContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        Log.e("mlll",q1+"   "+q2);
        mBinding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterPath.Main.MAIN).navigation();

            }
        });
    }

    @Override
    protected void data(Object data) {

    }
}
