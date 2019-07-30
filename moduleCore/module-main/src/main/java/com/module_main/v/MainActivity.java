package com.module_main.v;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.a.a.a.library_base.arouter.RouterPath;
import com.a.a.a.library_base.mvvm.BaseActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.module_main.R;
import com.module_main.TabEntity;
import com.module_main.databinding.ActivityMainBinding;
import com.module_main.vm.MainViewModel;

import java.util.ArrayList;
@Route(path = RouterPath.Main.MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {

    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    public int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
//        mBinding.setAdd(mViewModel);
//        mBinding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                ARouter.getInstance().build(RouterManger.Path.MAIN_TEST_ACTIVITY)
////                        .withString("name","name")
////                        .withString("n","name1")
////                        .navigation();
//            }
//        });
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mFragments.add((Fragment) ARouter.getInstance().build(RouterPath.Main.O1).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(RouterPath.Main.O2).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(RouterPath.Main.O3).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(RouterPath.Main.O4).navigation());

        CommonTabLayout tl_1 = mBinding.tl1;
        tl_1.setTabData(mTabEntities, this, R.id.frame_layout, mFragments);


    }

    @Override
    protected void data(Object data) {

    }
}
