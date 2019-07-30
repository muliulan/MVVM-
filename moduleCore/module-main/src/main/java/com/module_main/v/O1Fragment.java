package com.module_main.v;

import android.os.Bundle;

import com.a.a.a.library_base.arouter.RouterPath;
import com.a.a.a.library_base.mvvm.BaseFragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.module_main.R;
import com.module_main.databinding.FragmentOneBinding;
import com.module_main.vm.O1ViewModule;

/**
 * Created by Administrator on 2019/7/24 0024.
 */
@Route(path = RouterPath.Main.O1)
public class O1Fragment extends BaseFragment<FragmentOneBinding,O1ViewModule>{

    @Override
    protected int initContentView() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
//        mBinding.text.setText("o1");
        mBinding.setData(mViewModel);
    }

    @Override
    protected void data(Object data) {

    }
}
