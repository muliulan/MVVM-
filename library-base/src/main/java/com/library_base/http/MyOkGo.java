package com.library_base.http;


import com.library_base.Constants;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;

import java.util.Map;

public class MyOkGo {

    public static void Get(Object tag,String url, Map<String, String> params,HttpCallback<String> httpcallback){
        GetRequest<String> request = OkGo.<String>get(Constants.BASE_URL+url)
                .tag(tag)
                .retryCount(3);
//              .headers("header1", "headerValue1")
        if(params!=null){
            request.params(params);
        }
        request.execute(httpcallback);
    }
    public static void Post(Object tag,String url, Map<String, String> params,HttpCallback<String> httpcallback){
        PostRequest<String> request = OkGo.<String>post(Constants.BASE_URL+url)
                .tag(tag)
                .retryCount(3);
        if(params!=null){
            request.params(params);
        }
        request.execute(httpcallback);
    }

}
