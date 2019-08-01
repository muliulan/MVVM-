package com.module_hfive;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.library_base.arouter.RouterPath;
import com.library_base.mvvm.BaseActivity;
import com.module_hfive.databinding.ActivityHfiveBinding;

/**
 * Created by Administrator on 2019/7/31 0031.
 */
@Route(path = RouterPath.Hfive.Hfive)
public class HfiveActivity extends BaseActivity<ActivityHfiveBinding,HfiveViewModule>{

    @Autowired
    public String url;
    private BridgeWebView webView;
    @Override
    protected int initContentView() {
        return R.layout.activity_hfive;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if(url==null){
            return;
        }
        webView = mBinding.webview;
        webView.loadUrl(url);
        webviewConfig();
        UI();
        js();

    }
    private void webviewConfig() {
//        webView.setDefaultHandler(new DefaultHandler());
//        WebSettings settings = webView.getSettings();
//        settings.setJavaScriptEnabled(true);
//        //settings.setPluginsEnabled(true);
//        /***打开本地缓存提供JS调用**/
//        webView.getSettings().setDomStorageEnabled(true);
//        // This next one is crazy. It's the DEFAULT location for your app's cache
//        // But it didn't work for me without this line.
//        // UPDATE: no hardcoded path. Thanks to Kevin Hawkins
//        String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
//        webView.getSettings().setAppCachePath(appCachePath);
//        webView.getSettings().setAllowFileAccess(true);
//        webView.getSettings().setAppCacheEnabled(true);
//        // Set cache size to 8 mb by default. should be more than enough
//        webView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
//        //启用数据库
//        webView.getSettings().setDatabaseEnabled(true);
//        //启用地理定位
//        webView.getSettings().setGeolocationEnabled(true);
//        //设置在WebView内部是否允许访问文件，默认允许访问。
//        webView.getSettings().setAllowFileAccess(true);
//        String localVersion = "";
//        try {
//            PackageInfo packageInfo =  getApplicationContext()
//                    .getPackageManager()
//                    .getPackageInfo( getPackageName(), 0);
//            localVersion = packageInfo.versionName;
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }

        //UA
//        String ua = settings.getUserAgentString();
//        settings.setUserAgentString(ua +"android_wondercv_app"+"&android_app_version="+localVersion);
//        Log.e("hfive_activity","UA2 = "+settings.getUserAgentString());
    }
    public void UI(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setLoadWithOverviewMode(true);


        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                if(myProgressBar==null){
//                    return;
//                }
//                if (newProgress == 100) {
//                    myProgressBar.setVisibility(View.GONE);
//                } else {
//                    if (View.INVISIBLE == myProgressBar.getVisibility()) {
//                        myProgressBar.setVisibility(View.VISIBLE);
//                    }
//                    myProgressBar.setProgress(newProgress);
//                }
                super.onProgressChanged(view, newProgress);
            }

        });


    }
    public void js(){
        //接受 接受js发送的数据
        webView.registerHandler("shareImage", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.e("图片", data);

            }
        });
        //给js发送数据
//        webviewWv.callHandler("functionInJs", new Gson().toJson(user), new CallBackFunction() {
//            @Override
//            public void onCallBack(String data) {
//
//            }
//        });
    }
    @Override
    protected void data(Object data) {



    }
}
