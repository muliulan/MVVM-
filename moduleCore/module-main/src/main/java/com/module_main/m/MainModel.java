package com.module_main.m;

import com.a.a.a.library_base.Constants;
import com.a.a.a.library_base.http.HttpCallback;
import com.a.a.a.library_base.mvvm.BaseModel;
import com.a.a.a.library_base.mvvm.IBaseViewModel;
import com.lzy.okgo.model.Response;

/**
 * Created by Administrator on 2019/7/18 0018.
 */

public class MainModel extends BaseModel {

    public MainModel(IBaseViewModel mViewModel) {
        super(mViewModel);
    }

    @Override
    public void onHttp() {
        super.onHttp();
        Get( Constants.TYPE_ZHIHU, null,httpcallback);
    }

    HttpCallback<String> httpcallback=  new HttpCallback<String>(mViewModel.getActivity()){
        @Override
        public void onSuccess(Response<String> response) {
            super.onSuccess(response);
            mViewModel.onHttpData(response.body());
        }
        @Override
        public void onError(Response<String> response) {
            super.onError(response);
        }
    };
}
