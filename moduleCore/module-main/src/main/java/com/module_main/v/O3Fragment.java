package com.module_main.v;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library_base.arouter.RouterPath;
import com.library_base.mvvm.BaseFragment;
import com.module_main.R;
import com.module_main.databinding.FragmentOneBinding;
import com.module_main.vm.O1ViewModule;

/**
 * Created by Administrator on 2019/7/24 0024.
 */
@Route(path = RouterPath.Main.O3)
public class O3Fragment extends BaseFragment<FragmentOneBinding,O1ViewModule> {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("frag","on create3333");
    }
    @Override
    protected int initContentView() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBinding.setData(mViewModel);
    }

    @Override
    protected void data(Object data) {

    }

    @Override
    public void onFragmentResume() {
        super.onFragmentResume();
        Log.e("frag3","开始加载");
        mBinding.text.setText("3333333");
    }

    @Override
    public void onFragmentPause() {
        super.onFragmentPause();
        Log.e("frag3","关闭");
    }

}
