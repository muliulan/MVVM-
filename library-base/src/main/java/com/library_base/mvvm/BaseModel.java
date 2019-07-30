package com.library_base.mvvm;

import com.alibaba.fastjson.JSON;
import com.library_base.Constants;
import com.library_base.http.HttpCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/18 0018.
 */

public class BaseModel implements   IModel {

    public  IBaseViewModel mViewModel;

    public BaseModel(    IBaseViewModel mViewModel){
        this.mViewModel=mViewModel;
    }

    public void Get(  String url, Map<String, String> params, HttpCallback<String> httpcallback){
        GetRequest<String> request = OkGo.<String>get(Constants.BASE_URL+url)
                .tag(this)
                .retryCount(3);
//              .headers("header1", "headerValue1")
        if(params!=null){
            request.params(params);
        }
        request.execute(httpcallback);
    }

    public void Post(String url, Map<String, String> params,HttpCallback<String> httpcallback){
        PostRequest<String> request = OkGo.<String>post(Constants.BASE_URL+url)
                .tag(this)
                .retryCount(3);
        if(params!=null){
            request.params(params);
        }
        request.execute(httpcallback);
    }

    public static <T>T getJsonList(String json,Class<T> c){
        List<T> parseArray = JSON.parseArray(json,c);
        return (T) parseArray;
    }

    public static <T>T getEntity(String json,Class<T> c){
        return JSON.parseObject(json, c);
    }

    @Override
    public void onCleared() {
        OkGo.getInstance().cancelTag(this);
        mViewModel=null;
    }

    @Override
    public void onHttp() {

    }


}
