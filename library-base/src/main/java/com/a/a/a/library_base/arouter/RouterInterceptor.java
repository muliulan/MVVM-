package com.a.a.a.library_base.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.blankj.utilcode.util.ThreadUtils;

/**
 * Created by Administrator on 2019/7/23 0023.
 */
@Interceptor(priority = 8, name = "登录跳转拦截器")
public class RouterInterceptor implements IInterceptor {
   private Context mContext;

    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        if ("".equals(postcard.getPath())) {
            //如果需要再界面示东西，需要切换到主线程进行caoz
            Log.e("mll","线程"+ ThreadUtils.isMainThread());
//            MainLooper.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(mContext, "请登录", Toast.LENGTH_SHORT).show();
//                    ARouter.getInstance().build(RouterManger.Path.USER_LOGIN_ACTIVITY).navigation();
//                    //处理完成，交还控制权
//                    callback.onInterrupt(null);
//                }
//            });
        } else {
            //处理完成，交还控制权
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        mContext = context;
        //此处做一些初始化的工作
    }

}
